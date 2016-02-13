package com.harley.hpqc.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.hibernate.Hibernate;

import com.harley.hpqc.model.HPQCRecord;

public class HPQCUtil {
	
	public void fillHPQCRecords(String fileName, List<HPQCRecord> list) throws IOException, InvalidFormatException {
		
   	    File file=new File(fileName);
   	    InputStream input = new BufferedInputStream(new FileInputStream(file));

   	    Workbook wb = WorkbookFactory.create(input);
   	    Sheet sheet = wb.getSheetAt(0);
   	    
   	    Iterator<Row> rowIterator = sheet.rowIterator();
   	    Row row = null;
   	    
   	    if(rowIterator.hasNext()) {
   	    	row = (Row) rowIterator.next();
   	    }
   	    
   	    System.out.println("physical no of cells - "+ row.getPhysicalNumberOfCells());
   	    int count = 0;
   	    
   	    while(rowIterator.hasNext()) {
        	     row = (Row)rowIterator.next();

        	     HPQCRecord record = new HPQCRecord();
        	     
        	     Iterator<Cell> cellIterator = row.cellIterator();
        	     if(cellIterator.hasNext()) {
        	    	 System.out.println("Record Count value = " + ++count);
        	    	 setHPQCRecord(cellIterator, record);
        	    	 list.add(record);
        	     }
        	     System.out.println("Record added to the list - " + record);
        	     
        }
   	    input.close();
	}
	
	public void setHeader(Sheet sheet, Workbook workbook, Row row) {
	
        CellStyle style = workbook.createCellStyle();
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);

        XSSFFont font= (XSSFFont)workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        
		int columnCount = 0;
		int rowLength = HPQCConstants.headers.length;
		while (rowLength > 0) {
			Cell cell = row.createCell(++columnCount);
			cell.setCellValue(HPQCConstants.headers[columnCount-1]);
			cell.setCellStyle(style);
			--rowLength;
			sheet.autoSizeColumn(columnCount);
		}
	}
	
	
	public void setRow(Workbook workbook, Row row, HPQCRecord record) throws SQLException {
		
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		
        int columnCount = 0;
        Cell cell = row.createCell(++columnCount);
        cell.setCellValue((int)record.getReqId());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue(record.getProjectPlanUID());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String)record.getDevCfgId());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getRICEFWType());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getTrack());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getComplexity());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getPlanGroup());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getBusinessArea());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getName());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getDevCfgStatus());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getAssignedTo());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getDeveloperConfigurator());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getTechDevLead());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getSPOC());
        cell.setCellStyle(cellStyle);
        
        CreationHelper createHelper = workbook.getCreationHelper();
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dateCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dateCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dateCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat(HPQCConstants.dateFormat));
        cell = row.createCell(++columnCount);
        cell.setCellStyle(dateCellStyle);
        Date date = record.getPlanFinishDate();
        if(date != null) {
        	cell.setCellValue((Date) date );
        }
        cell = row.createCell(++columnCount);
        cell.setCellStyle(dateCellStyle);
        date = record.getPlanStartDate();
        if(date != null) {
        	cell.setCellValue((Date) date );
        }
        cell = row.createCell(++columnCount);
        cell.setCellStyle(dateCellStyle);
        date = record.getActualStartDate();
        if(date != null) {
        	cell.setCellValue((Date) date );
        }
        cell = row.createCell(++columnCount);
        cell.setCellStyle(dateCellStyle);
        date = record.getEtcDate();
        if(date != null) {
        	cell.setCellValue((Date) date );
        }
        cell = row.createCell(++columnCount);
        cell.setCellStyle(dateCellStyle);
        date = record.getActualFinishDate();
        if(date != null) {
        	cell.setCellValue((Date) date );
        }
        
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getRoadblock());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getRoadblockStatus());
        cell.setCellStyle(cellStyle);
        
        Cell bargCell = row.createCell(++columnCount);
        setBargCell(workbook, bargCell, record);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getScheduleAdherence());
        cell.setCellStyle(cellStyle);
        
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getDecommission());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        Clob comments = record.getComments();
        cell.setCellStyle(cellStyle);
        cell.setCellValue(comments.getSubString(1, (int)comments.length()));
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getRequirementType());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getTargetCycle());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getTargetRelease());
        cell.setCellStyle(cellStyle);
        cell = row.createCell(++columnCount);
        cell.setCellValue((String) record.getStatusSummary());
        cell.setCellStyle(cellStyle);
	}
	
	
	private void setHPQCRecord(Iterator<Cell> cellIterator, HPQCRecord record) {
		
		record.setReqId((int)(((Cell) cellIterator.next()).getNumericCellValue()));
		record.setProjectPlanUID(((Cell) cellIterator.next()).getNumericCellValue());
		record.setDevCfgId(((Cell) cellIterator.next()).getStringCellValue());
		record.setRICEFWType(((Cell) cellIterator.next()).getStringCellValue());
		record.setTrack(((Cell) cellIterator.next()).getStringCellValue());
		record.setComplexity(((Cell) cellIterator.next()).getStringCellValue());
		record.setPlanGroup(((Cell) cellIterator.next()).getStringCellValue());
		record.setBusinessArea(((Cell) cellIterator.next()).getStringCellValue());
		record.setName(((Cell) cellIterator.next()).getStringCellValue());
		record.setDevCfgStatus(((Cell) cellIterator.next()).getStringCellValue());
		record.setAssignedTo(((Cell) cellIterator.next()).getStringCellValue());
		record.setDeveloperConfigurator(((Cell) cellIterator.next()).getStringCellValue());
		record.setTechDevLead(((Cell) cellIterator.next()).getStringCellValue());
		record.setSPOC(((Cell) cellIterator.next()).getStringCellValue());
		Date date = ((Cell) cellIterator.next()).getDateCellValue();
		if(date != null) {
			record.setPlanFinishDate(date);
		}
		date = ((Cell) cellIterator.next()).getDateCellValue();
		if(date != null) {
			record.setPlanStartDate(date);
		}
		date = ((Cell) cellIterator.next()).getDateCellValue();
		if(date != null) {
			record.setActualStartDate(date);
		}
		date = ((Cell) cellIterator.next()).getDateCellValue();
		if(date != null) {
			record.setEtcDate(date);
		}
		date = ((Cell) cellIterator.next()).getDateCellValue();
		if(date != null) {
			record.setActualFinishDate(date);
		}
		record.setRoadblock(((Cell) cellIterator.next()).getStringCellValue());
		record.setRoadblockStatus(((Cell) cellIterator.next()).getStringCellValue());
		record.setDecommission(((Cell) cellIterator.next()).getStringCellValue());
		String comments = ((Cell) cellIterator.next()).getStringCellValue();
		record.setComments(Hibernate.createClob(comments));
		System.out.println("Comments length = "+ comments.length());
		record.setRequirementType(((Cell) cellIterator.next()).getStringCellValue());
		record.setTargetCycle(((Cell) cellIterator.next()).getStringCellValue());
		record.setTargetRelease(((Cell) cellIterator.next()).getStringCellValue());
		record.setStatusSummary(((Cell) cellIterator.next()).getStringCellValue());
		
		record.setBarg(getBargValue(record));
		record.setScheduleAdherence(getScheduleAdherence(record));
	}
	
	private String getBargValue(HPQCRecord record) {
		String roadblock = (String) record.getRoadblock();
        String devCfgStatus = (String) record.getDevCfgStatus();
        String barg = "";
        
        if(roadblock.equalsIgnoreCase("yes")) {
        	if(devCfgStatus.equalsIgnoreCase(HPQCConstants.devCfgStatus1) ||
        		devCfgStatus.equalsIgnoreCase(HPQCConstants.devCfgStatus2) ||
        		devCfgStatus.equalsIgnoreCase(HPQCConstants.devCfgStatus3)) {
        		barg = HPQCConstants.bargYellow;
        	}
        	else {
        		barg = HPQCConstants.bargRed;
        	}
        }
        else if((roadblock.length() == 0) || (roadblock.equalsIgnoreCase("no"))) {
        	if((devCfgStatus.equalsIgnoreCase(HPQCConstants.devCfgStatus1)) ||
        	   (devCfgStatus.equalsIgnoreCase(HPQCConstants.devCfgStatus2)) ||
        	   (devCfgStatus.equalsIgnoreCase(HPQCConstants.devCfgStatus3)) ||
        	   (devCfgStatus.equalsIgnoreCase(HPQCConstants.devCfgStatus4)) ||
        	   (devCfgStatus.equalsIgnoreCase(HPQCConstants.devCfgStatus5)) ||
        	   (devCfgStatus.equalsIgnoreCase(HPQCConstants.devCfgStatus6))) {
        		barg = HPQCConstants.bargGreen;
        	}
        }
        
        if(barg.length() == 0) {
        	Date etcDate = record.getEtcDate();
        	Date today = new Date();
        	if((etcDate != null) && ((etcDate.before(today)) || (etcDate.equals(today)))) {
        		barg = HPQCConstants.bargAmber;
        	}
        	else
        	{
        		barg = HPQCConstants.bargBlue;
        	}
        		
        }
        System.out.println("Barg value to be returned from getBargValue = " + barg);
        return barg;
	}
	
	private void setBargCell(Workbook workbook, Cell cell, HPQCRecord record) {
        
        String barg = record.getBarg();

        CellStyle style = workbook.createCellStyle();
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        
        if(barg.equals(HPQCConstants.bargYellow)) {
       		style.setFillForegroundColor(HSSFColor.YELLOW.index);
            cell.setCellValue(HPQCConstants.bargYellow);
       	}
       	else if (barg.equals(HPQCConstants.bargRed)) {
        	style.setFillForegroundColor(HSSFColor.RED.index);
            cell.setCellValue(HPQCConstants.bargRed);
        }
        else if(barg.equals(HPQCConstants.bargGreen)) {
        	style.setFillForegroundColor(HSSFColor.GREEN.index);
		    cell.setCellValue(HPQCConstants.bargGreen);
        }
        else if(barg.equals(HPQCConstants.bargAmber)) {
        	style.setFillForegroundColor(HSSFColor.ORANGE.index);
		    cell.setCellValue(HPQCConstants.bargAmber);
        }
        else if(barg.equals(HPQCConstants.bargBlue)) {
        	style.setFillForegroundColor(HSSFColor.BLUE.index);
		    cell.setCellValue(HPQCConstants.bargBlue);
        }
        
        cell.setCellStyle(style);
   	}

	private String getScheduleAdherence(HPQCRecord record) {
		Date actualFinishDate = record.getActualFinishDate();
		Date etcDate = record.getEtcDate();
		String scheduleAdherence = "";
		
		if((actualFinishDate != null) && (etcDate != null)) {
			if(actualFinishDate.after(etcDate)) {
				scheduleAdherence = HPQCConstants.SchAdherDelayed;
			}
			else if((actualFinishDate.before(etcDate)) || (actualFinishDate.equals(etcDate))) {
				scheduleAdherence = HPQCConstants.SchAdherOnTime;
			}
		}

		return scheduleAdherence;
	}


}
