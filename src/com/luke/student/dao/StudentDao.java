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

	public int countAllStu() {
		return hibernateTemplate.find("from Student").size();
	}

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

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
