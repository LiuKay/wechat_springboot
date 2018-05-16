package com.kay.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by kay on 2018/3/16.
 */
@Configuration
public class SqlSessionFacoryConfiguration {

    @Value("${mybatis_config_file}")
    private String mybatisConfigPath;

    @Value("${mapper_path}")
    private String mapperPath;

    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;


    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean creatSqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigPath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_URL_PREFIX;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packSearchPath+mapperPath));
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

}
