package com.luke.student.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.enterprise.inject.Typed;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference; 

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.luke.student.module.Student;
import com.luke.student.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

@Component("studentAction")
@Scope("prototype")
public class StudentAction extends ActionSupport{
	private StudentService studentService;
	private String rows;
	private String page;
	private InputStream inputStream;
	private int id;
	private String sid;
	private String sname;
	private int age;
	private String email;

	 public String getStu() {
		 
		 try {
			List<Student> ls = studentService.getStuByPage(page, rows);
			 
			 Map<String,Object> map = new HashMap<String,Object>();
			 map.put("rows", ls);
			 map.put("total", studentService.countAllStu());
			 String jsonString = JSON.toJSONString(map);
			 inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return "ajax-success";
	 }
	 
	 
	 
	 public String addStu() {
		 Student st = new Student();
		 
		 st.setAge(age);
		 st.setEmail(email);
		 st.setSid(sid);
		 st.setSname(sname);
		 
		 try {
			if(studentService.addStudent(st)){
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			}else{
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return "ajax-success";
	 }
	 
	//-----------All getter and setter----------------------
	public StudentService getStudentService() {
		return studentService;
	}
	
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public String getRows() {
		return rows;
	}


	public void setRows(String rows) {
		this.rows = rows;
	}


	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
