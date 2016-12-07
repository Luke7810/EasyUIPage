package com.luke.student.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.luke.student.dao.StudentDao;
import com.luke.student.module.Student;

@Component("studentService")
public class StudentService {
	private StudentDao studentDao;

	public int countAllStu() {
		return studentDao.countAllStu();
	}
	
	public List<Student> getStuByPage(String page, String row){
		int intpage = Integer.parseInt((page == null || page == "0") ? "1": page);;
		int introw = Integer.parseInt((row == null || row == "0") ? "10": row);
		
		return studentDao.getStubyPage(((intpage-1)*introw), introw);
	}
	
	//-----add new student----------------
	public boolean addStudent(Student st){
			try {
				studentDao.saveStudent(st);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
	//----- update student-----------------
	public boolean changeStudent(Student st){
		try {
			studentDao.updateStudent(st);
			return true;
		} catch (Exception e) {
		return false;
		}
	}
	
	//------remove student----------------
	public boolean removeStudent(int id){
		try {
			studentDao.deleteStudent(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//-------get user by id---------------
	public Student getStById(int id){
		return studentDao.getStById(id);
	}
	
	public StudentDao getStudentDao() {
		return studentDao;
	}
	
	@Resource(name="studentDao")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	
}
