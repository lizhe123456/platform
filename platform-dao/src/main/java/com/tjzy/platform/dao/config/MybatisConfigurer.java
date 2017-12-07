package com.tjzy.platform.dao.config;

import com.github.pagehelper.PageHelper;
import com.tjzy.platform.model.constant.Constant;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

@Configuration
@EnableTransactionManagement
public class MybatisConfigurer implements TransactionManagementConfigurer{

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(Constant.MODEL_PACKAGE);
        //配置分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();

        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        pageHelper.setProperties(properties);

        factory.setPlugins(new Interceptor[]{pageHelper});

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try{
            factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return factory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
