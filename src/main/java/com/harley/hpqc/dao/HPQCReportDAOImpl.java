package com.harley.hpqc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.harley.hpqc.model.HPQCRecord;

public class HPQCReportDAOImpl implements HPQCReportDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	public List<HPQCRecord> getHPQCRecords() {
		return this.sessionFactory.getCurrentSession().createQuery("from HPQCRecord").list();
	}

	public void addHPQCRecords(List<HPQCRecord> hpqcRecords) {
		for(HPQCRecord hpqcRecord : hpqcRecords) {
			this.sessionFactory.getCurrentSession().save(hpqcRecord);
		}
	}
	
	public void updateHPQCRecords(List<HPQCRecord> hpqcRecords) {
		for(HPQCRecord hpqcRecord : hpqcRecords) {
			this.sessionFactory.getCurrentSession().update(hpqcRecord);
		}
	}
}
