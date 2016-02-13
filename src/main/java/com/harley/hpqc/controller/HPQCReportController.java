package com.harley.hpqc.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.harley.hpqc.common.HPQCConstants;
import com.harley.hpqc.common.HPQCUtil;
import com.harley.hpqc.dao.HPQCReportDAO;
import com.harley.hpqc.model.HPQCRecord;

@Controller
public class HPQCReportController {

	@Autowired
	private HPQCReportDAO hpqcReportDAO;
	@Autowired
	private HPQCUtil hpqcUtil;
	
	@Transactional
	@RequestMapping(value = "/upload_raw_file", method = RequestMethod.GET)
	public String uploadRawFile(String fileName) {
		
        List<HPQCRecord> list = new ArrayList<HPQCRecord>();
        
        try {
        	hpqcUtil.fillHPQCRecords(fileName, list);
       	    
       	    System.out.println("calling dao to persist in DB");
       	    hpqcReportDAO.addHPQCRecords(list);
       	    
       	    model.addAttribute("fileName", fileName);
	    }
        catch(HibernateException he) {
        	System.out.println("Hibernate exception thrown - " + he.getMessage());
        }
        catch(Exception e) {
        	System.out.println("Exception while uploading the data - " + e.getMessage());
	     	e.printStackTrace();
	     	return "error";
	    }
        
        return "success";
	}

	@Transactional
	@RequestMapping(value = "/upload_updated_file", method = RequestMethod.GET)
	public String uploadUpdatedFile(String fileName) {

        List<HPQCRecord> list = new ArrayList<HPQCRecord>();
        
        try {
        	hpqcUtil.fillHPQCRecords(fileName, list);
       	    
       	    System.out.println("calling dao to persist in DB");
       	    hpqcReportDAO.updateHPQCRecords(list);
	    }
        catch(HibernateException he) {
        	System.out.println("Hibernate exception thrown - " + he.getMessage());
        }
        catch(Exception e) {
        	System.out.println("Exception while uploading the data - " + e.getMessage());
	     	e.printStackTrace();
	     	return "error";
	    }
        
        return "success";

	}
	
	@Transactional
	@RequestMapping(value = "/generate_report", method = RequestMethod.GET)
	public String generateHPQCReport(String fileName) {
		
		List<HPQCRecord> hpqcRecords = hpqcReportDAO.getHPQCRecords();
		
		if(!(hpqcRecords.isEmpty())) {
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet(HPQCConstants.HPQCReportSheet);
	 
	        try {
		        int rowCount = 0;
		        Row row = sheet.createRow(++rowCount);
		        hpqcUtil.setHeader(sheet, workbook, row);
		        
		        for (HPQCRecord hpqcRecord : hpqcRecords) {
		            row = sheet.createRow(++rowCount);
		            
		            hpqcUtil.setRow(workbook, row, hpqcRecord);
		        }
		        
		        String outputFileName = fileName + "/" + HPQCConstants.HPQCReportFileName;
	        	FileOutputStream outputStream = new FileOutputStream(outputFileName);
	            workbook.write(outputStream);
	            outputStream.close();
	        }
	        catch(Exception e) {
	        	System.out.println("Exception thrown while writing to the excel file - " + e.getMessage());
	        	return "error";
	        }
		}
	        
		return "success";
	}

}