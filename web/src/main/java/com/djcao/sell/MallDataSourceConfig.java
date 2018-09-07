//package com.djcao.sell;
//
//import java.io.IOException;
//
//import javax.sql.DataSource;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
///**
// * @author djcao
// * @workcode wb-cdj390654
// * @date 2018-08-05
// */
//@Configuration
//@MapperScan(basePackages = "com.djcao.sell.db.mall.mapper.**",
//    sqlSessionFactoryRef = "mallSqlSessionFactory",
//    sqlSessionTemplateRef = "mallSqlSessionTemplete"
//)
//public class MallDataSourceConfig {
//
//
//    @Primary
//    @Bean(name = "mallDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.mall")
//    public DataSource mallDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//    @Primary
//    @Bean(name = "mallSqlSessionFactory")
//    public SqlSessionFactory mallSqlSessionFactory(@Qualifier("mallDataSource")DataSource dataSource)
//        throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mall/*.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
//    @Primary
//    @Bean(name = "mallSqlSessionTemplete")
//    public SqlSessionTemplate mallSqlSeessionTemplete (@Qualifier(value = "mallSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//    @Primary
//    @Bean(name = "mallDataSourceTransactionManager")
//    public DataSourceTransactionManager mallDataSourceTransactionManager(@Qualifier("mallDataSource")DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//}
