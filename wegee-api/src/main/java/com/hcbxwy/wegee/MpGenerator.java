package com.hcbxwy.wegee;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 代码生成器
 *
 * @author Billson
 * @since 2019/9/5 20:40
 */
public class MpGenerator {
    /**
     * 基本输出路径，项目地址
     */
    private static final String BASE_OUT_PATH = "D:\\code";
    private static final String AUTHOR = "Billson";
    private static final String MODULE_NAME = "user";
    private static final String TABLE_NAME = "wg_user_account";

    private static AutoGenerator generator = new AutoGenerator();

    public static void main(String[] args) {
        // 全局配置
        setGlobalConfig();
        // 数据源配置
        setDataSourceConfig();
        // 包配置
        setPackageConfig();
        // 策略配置
        setStrategyConfig();
        // 执行代码生成
        generator.execute();
    }

    private static void setStrategyConfig() {
        StrategyConfig config = new StrategyConfig();
        config.setEntityLombokModel(true);
        config.setEntityBuilderModel(true);
        config.setEntityColumnConstant(true);
        config.setRestControllerStyle(true);
        config.setControllerMappingHyphenStyle(true);
        //使用lombok模式
        config.setEntityLombokModel(true);
        //使用构建者模式
        config.setEntityBuilderModel(true);
        // config.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        // 此处可以修改为您的表前缀
        config.setTablePrefix("wg_");
        // 表名生成策略
        config.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        config.setInclude(TABLE_NAME);
        // 自定义实体父类
        config.setSuperEntityClass("com.hcbxwy.wegee.common.entity.BaseEntity");
        // 自定义实体，公共字段
         config.setSuperEntityColumns("id","create_time","update_time","create_by","update_by");
        // 自定义 dao 父类
//        config.setSuperMapperClass("com.zhiyingwl.base.dao.BaseDao");
        // 自定义 service 父类
//        config.setSuperServiceClass("com.zhiyingwl.base.service.BaseService");
        // 自定义 service 实现类父类
//        config.setSuperServiceImplClass("com.zhiyingwl.base.service.impl.BaseServiceImpl");
        // 自定义 controller 父类
//        config.setSuperControllerClass("com.zhiyingwl.common.base.BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
         config.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
         config.setEntityBuilderModel(true);
        generator.setStrategy(config);
    }

    private static void setPackageConfig() {
        PackageConfig config = new PackageConfig();
        config.setModuleName(MODULE_NAME);
        config.setParent("com.hcbxwy.wegee.modules");
        config.setController("controller");
        config.setMapper("dao");
        generator.setPackageInfo(config);
    }

    private static void setDataSourceConfig() {
        DataSourceConfig config = new DataSourceConfig();
        config.setUrl("jdbc:mysql://localhost:3306/wegee?serverTimezone=Asia/Shanghai&characterEncoding=utf8");
        config.setDriverName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("123456");
        generator.setDataSource(config);
    }

    private static void setGlobalConfig() {
        GlobalConfig config = new GlobalConfig();
        config.setOutputDir(BASE_OUT_PATH);
        config.setAuthor(AUTHOR);
        config.setOpen(true);
        config.setFileOverride(true);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        config.setMapperName("%sDao");
        config.setXmlName("%sDao");
        config.setServiceName("%sService");
        config.setServiceImplName("%sServiceImpl");
        config.setControllerName("%sController");
//        config.setIdType(IdType.AUTO);
        generator.setGlobalConfig(config);
        // set freemarker engine
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

//        TemplateConfig tc = new TemplateConfig();
//        tc.setXml("mapper");
//        generator.setTemplate(tc);
    }
}
