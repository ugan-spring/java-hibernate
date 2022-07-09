package com.ugan.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ugan.product.config.DBConfig;
import com.ugan.product.entity.Department;
import com.ugan.product.entity.Employee;

public class OneToOne_Fetch {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();

		Employee e1 = ses1.get(Employee.class,8);
	
		
		System.out.println(e1);
		System.out.println(e1.getDept());
		
		
		
	}

}
