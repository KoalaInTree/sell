package com.djcao.sell;

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

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
@Configuration
@MapperScan(
    basePackages = "com.djcao.sell.db.flybird.mapper.**",
    sqlSessionTemplateRef = "flySqlSessionTemplate",
    sqlSessionFactoryRef = "flySqlSessionFactory"
)
public class FlyBirdDataSourceConfig {


    @Bean(name = "flyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.flybird")
    public DataSource flyDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "flySqlSessionFactory")
    public SqlSessionFactory flySqlSessionFactory(@Qualifier("flyDataSource")DataSource dataSource)
        throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/flybird/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "flySqlSessionTemplate")
    public SqlSessionTemplate flySqlSessionTemplate(@Qualifier("flySqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "flyDataSourceTransactionManager")
    public DataSourceTransactionManager flyDataSourceTransactionManager(@Qualifier("flyDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
