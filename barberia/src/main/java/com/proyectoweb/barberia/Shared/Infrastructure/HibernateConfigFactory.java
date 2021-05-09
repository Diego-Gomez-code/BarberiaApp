package com.proyectoweb.barberia.Shared.Infrastructure;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfigFactory {

    @Autowired
    private Environment env;

    @Bean("session-factory")
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());

        FileSystemResource resource1 = new FileSystemResource("./src/main/java/com/proyectoweb/barberia/Users/User/Infrastructure/Hibernate/User.hbm.xml");
        FileSystemResource resource2 = new FileSystemResource("./src/main/java/com/proyectoweb/barberia/Products/Product/Infrastructure/Hibernate/Product.hbm.xml");
        FileSystemResource resource3 = new FileSystemResource("./src/main/java/com/proyectoweb/barberia/Products/CarritoCompra/Infrastructure/Hibernate/CarritoCompra.hbm.xml");
        FileSystemResource resource4 = new FileSystemResource("./src/main/java/com/proyectoweb/barberia/CarritoClientes/CarritoCliente/Infrastructure/Hibernate/CarritoCliente.hbm.xml");
        FileSystemResource resource10 = new FileSystemResource("./src/main/java/com/proyectoweb/barberia/Services/Service/Infrastructure/Hibernates/Service.hbm.xml");
        FileSystemResource resource11 = new FileSystemResource("./src/main/java/com/proyectoweb/barberia/Services/Schedule/Infrastructure/Hibernates/Schedule.hmb.xml");

        sessionFactory.setMappingLocations(resource1, resource2, resource3, resource4,resource10,resource11);
        return sessionFactory;
    }

    @Bean("transactional-manager")
    public PlatformTransactionManager hibernateTransactionManager()
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private DataSource dataSource() {
        String url = env.getProperty("datasource.url");
        String userName = env.getProperty("datasource.username");
        String password = env.getProperty("datasource.password");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mariadb://" + url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MariaDBDialect");
        return hibernateProperties;
    }

}
