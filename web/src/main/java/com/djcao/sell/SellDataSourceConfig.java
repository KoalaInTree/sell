/*
package com.djcao.sell;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

*/
/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 *//*

@Configuration
@MapperScan(
    basePackages = "com.djcao.sell.db.sell.mapper.**",
    sqlSessionTemplateRef = "sellSqlSessionTemplate",
    sqlSessionFactoryRef = "sellSqlSessionFactory"
)
public class SellDataSourceConfig {


    @Bean(name = "sellDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sell")
    public DataSource sellDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sellSqlSessionFactory")
    public SqlSessionFactory sellSqlSessionFactory(@Qualifier("sellDataSource")DataSource dataSource)
        throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/sell/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sellSqlSessionTemplate")
    public SqlSessionTemplate sellSqlSessionTemplate(@Qualifier("sellSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "sellDataSourceTransactionManager")
    public DataSourceTransactionManager sellDataSourceTransactionManager(@Qualifier("sellDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
*/
