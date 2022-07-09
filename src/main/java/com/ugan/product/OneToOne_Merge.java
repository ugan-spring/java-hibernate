package com.ugan.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ugan.product.config.DBConfig;
import com.ugan.product.entity.Department;
import com.ugan.product.entity.Employee;

public class OneToOne_Merge {

	public static void main(String[] args) {

		SessionFactory sf = DBConfig.getSessionbFactory();

		Session ses1 = sf.openSession();
		Employee e1 = ses1.get(Employee.class,1);
		
		System.out.println(e1);
		e1.getDept().setLoc("Delhi1");

		//e1.setDept(d1);
		ses1.merge(e1);
		
		ses1.beginTransaction().commit();
		
		
	}

}
