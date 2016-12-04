package com.luke.student.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luke.student.module.Student;



public class StudentServiceTest {

	@Test
	public void testCountAllStu() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentService uis = (StudentService) ac.getBean("studentService");
		
		System.out.println("*********"+uis.countAllStu());
	}

	@Test
	public void testGetStuByPage() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentService uis = (StudentService) ac.getBean("studentService");
		
		List<Student> list = uis.getStuByPage("1", "5");
		for(Student s : list){
			System.out.println("*********"+s.getSname());
		}
		
	}

}
