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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference; 

import org.springframework.stereotype.Component;

import com.luke.student.module.Student;
import com.luke.student.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

@Component("studentAction")
public class StudentAction extends ActionSupport{
	private StudentService studentService;
	private String rows;
	private String page;
	private InputStream inputStream;
	
	
	 
	 public String getStu() throws UnsupportedEncodingException {
		 
		 List<Student> ls = studentService.getStuByPage(page, rows);
		 
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("rows", ls);
		 map.put("total", studentService.countAllStu());
		 String jsonString = JSON.toJSONString(map);
		 inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
		 
		 return "ajax-success";
	 }

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

}
