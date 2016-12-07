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
	
	@Test
	public void testGetStById(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentService uis = (StudentService) ac.getBean("studentService");
		
		Student st = uis.getStById(1);
		System.out.println("***************"+st.getEmail());
		
	}
	
	@Test
	public void testAddSt(){
		Student st = new Student();
		st.setAge(40);
		st.setEmail("sdsde@sdsd.com");
		st.setSid("A001");
		st.setSname("Zhang San");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentService uis = (StudentService) ac.getBean("studentService");
		
		System.out.println(uis.addStudent(st));
	}
	
	@Test
	public void testDeleteSt() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentService uis = (StudentService) ac.getBean("studentService");
		
		System.out.println(uis.removeStudent(13));
	}
	
	@Test
	public void testUpdateSt(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentService uis = (StudentService) ac.getBean("studentService");
		
		Student st = uis.getStById(12);
		st.setEmail("11111@qq.com");
		System.out.println(uis.changeStudent(st));
	}
}
