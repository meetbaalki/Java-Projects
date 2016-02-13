package com.harley.hpqc.dao;

import java.util.List;

import com.harley.hpqc.model.HPQCRecord;

public interface HPQCReportDAO {
	public List<HPQCRecord> getHPQCRecords();
	public void addHPQCRecords(List<HPQCRecord> hpqcRecords);
	public void updateHPQCRecords(List<HPQCRecord> hpqcRecords);
	
}
