package com.luke.student.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.luke.student.module.Student;

@Component("studentDao")
public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	//----- Count all student number----------------
	public int countAllStu() {
		return hibernateTemplate.find("from Student").size();
	}

	//------ List student with offset and page size------------------------
	public List<Student> getStubyPage(final int offset, final int length) {

		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from Student");
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}
	
	//------get student by id-----------------------
	public Student getStById(int id){
		List<Student> ls = hibernateTemplate.find("from Student st where st.id="+id);
		if(ls.size()>0){
			return ls.get(0);
		}
		return null;
	}
	
	//------- save student---------------------------
	public void saveStudent(Student st){
		hibernateTemplate.save(st);
	}
	
	//------ update student----------------------------
	public void updateStudent(Student st){
		hibernateTemplate.clear();
		hibernateTemplate.update(st);
	}
	
	//------- delele student---------------------------
	public void deleteStudent(Student st){
		hibernateTemplate.clear();
		hibernateTemplate.delete(st);
	}
	
	public void deleteStudent(int id){
		Student st = getStById(id);
		if(st != null){
			deleteStudent(st);
		}
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
