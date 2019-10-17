package com.hcbxwy.wegee.common.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局事务控制
 *
 * @author Billson
 * @since 2019/10/17 16:51
 */
@EnableTransactionManagement
@Aspect
@Configuration
public class GlobalTransactionConfig {
    /**
     * 写事务的超时时间为10 秒
     */
    private static final int TX_METHOD_TIMEOUT = 10;

    /**
     * 所有service包或者service子包的任意类的任意方法
     */
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.hcbxwy.wegee.modules..*.service..*.*(..))";

    private final PlatformTransactionManager transactionManager;

    @Autowired
    public GlobalTransactionConfig(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Bean
    public TransactionInterceptor txAdvice() {

        // 这里配置只读事务
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        // 当前存在事务就使用当前事务，当前不存在事务,就开启一个新的事务
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        //检查型异常也回滚
        requiredTx.setRollbackRules(
                Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredTx.setTimeout(TX_METHOD_TIMEOUT);

        // 无事务地执行，挂起任何存在的事务
        RuleBasedTransactionAttribute noTx = new RuleBasedTransactionAttribute();
        noTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);

        Map<String, TransactionAttribute> txMap = new HashMap<>(16);
        //只读事务
        txMap.put("get*", readOnlyTx);
        txMap.put("query*", readOnlyTx);
        txMap.put("find*", readOnlyTx);
        txMap.put("list*", readOnlyTx);
        txMap.put("count*", readOnlyTx);
        txMap.put("exist*", readOnlyTx);
        txMap.put("search*", readOnlyTx);
        txMap.put("fetch*", readOnlyTx);
        //无事务
        txMap.put("noTx*", noTx);
        //写事务
        txMap.put("add*", requiredTx);
        txMap.put("save*", requiredTx);
        txMap.put("insert*", requiredTx);
        txMap.put("update*", requiredTx);
        txMap.put("modify*", requiredTx);
        txMap.put("delete*", requiredTx);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.setNameMap(txMap);

        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }

}
