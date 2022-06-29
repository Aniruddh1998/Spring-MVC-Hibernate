package test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import test.model.student;

@Repository
@Transactional
public class studentdao {
	
	@Autowired
	private SessionFactory sess;

	public void save_data(student s) {
		sess.getCurrentSession().save(s);
	}
	
	@SuppressWarnings("unchecked")
	public List<student> getallstudents(){
		return sess.getCurrentSession().createQuery("FROM student").list();
	}
	
	public void delete_data(int id) {
		student s=(student) sess.getCurrentSession().load(student.class, id);
		sess.getCurrentSession().delete(s);
	}

	public student getstud(int id) {
		return (student) sess.getCurrentSession().get(student.class, id);
	}

	public void updatestud(student stud) {
		student s = (student) sess.getCurrentSession().get(student.class, stud.getId());
		s.setFname(stud.getFname());
		s.setLname(stud.getLname());
		s.setEmail(stud.getEmail());
		s.setPassword(stud.getPassword());
		sess.getCurrentSession().update(s);	
	}


}
