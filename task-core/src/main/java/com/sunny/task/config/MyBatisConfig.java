package com.sunny.task.config;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @author sunny
 * @date 2017-03-31 11:17
 * @description
 */
//加上这个注解，使得支持事务
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {
    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // 这个配置使全局的映射器启用或禁用缓存
        configuration.setCacheEnabled(true);
        // 允许 JDBC 支持生成的键，需要适合的驱动（如MySQL，SQL Server，Sybase ASE）。
        // 如果设置为 true 则这个设置强制生成的键被使用，尽管一些驱动拒绝兼容但仍然有效（比如 Derby）。
        // 但是在 Oracle 中一般不需要它，而且容易带来其它问题，比如对创建同义词DBLINK表插入时发生以下错误：
        // "ORA-22816: unsupported feature with RETURNING clause" 在 Oracle
        // 中应明确使用 selectKey 方法
        configuration.setUseGeneratedKeys(false);
        // 配置默认的执行器。SIMPLE 执行器没有什么特别之处；REUSE 执行器重用预处理语句；BATCH 执行器重用语句和批量更新
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
        // 全局启用或禁用延迟加载，禁用时所有关联对象都会即时加载
        configuration.setLazyLoadingEnabled(false);
        // 设置SQL语句执行超时时间缺省值，具体SQL语句仍可以单独设置
        configuration.setDefaultStatementTimeout(5000);
        sqlSessionFactoryBean.setConfiguration(configuration);
        // 匹配多个 MapperConfig.xml, 使用mappingLocation属性
      //  PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/bob/**/*Mapper.xml"));

       // sqlSessionFactoryBean.setTypeAliasesPackage("com.sunny.bugmanage.*.model");
        //分页插件
        /*PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});*/
        try {
            //添加XML目录
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/sunny/task/**/mapper/xml/*Mapper.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Override
	@Bean
    public PlatformTransactionManager annotationDrivenTransactionManager () {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
