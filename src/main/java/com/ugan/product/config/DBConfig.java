package com.ugan.product.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.ugan.product.entity.Department;
import com.ugan.product.entity.Employee;


public class DBConfig {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionbFactory() {

		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

		Properties props = new Properties();
		try {
			props.load(ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashMap<String, String> settings = new HashMap<String, String>();

		settings.put(Environment.DRIVER, props.getProperty("mysql.driver"));
		settings.put(Environment.URL, props.getProperty("mysql.url"));
		settings.put(Environment.USER, props.getProperty("mysql.user"));
		settings.put(Environment.PASS, props.getProperty("mysql.password"));
		settings.put(Environment.DIALECT, props.getProperty("mysql.dialect"));
		settings.put(Environment.SHOW_SQL, props.getProperty("show.sql"));
		settings.put(Environment.HBM2DDL_AUTO, props.getProperty("hbm2ddl.auto"));
		settings.put(Environment.FORMAT_SQL, props.getProperty("format.sql"));

		registryBuilder.applySettings(settings);

		registry = registryBuilder.build();

		MetadataSources metadataSources = new MetadataSources(registry);
		metadataSources.addAnnotatedClass(Employee.class);
		metadataSources.addAnnotatedClass(Department.class);
		// metadataSources.addAnnotatedClass(Product.class);

		Metadata metadata = metadataSources.getMetadataBuilder().build();

		sessionFactory = metadata.buildSessionFactory();

		return sessionFactory;
	}

}
