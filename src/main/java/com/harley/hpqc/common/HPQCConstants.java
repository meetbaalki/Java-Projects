package com.harley.hpqc.common;

public class HPQCConstants {

	public static final String HPQCReportSheet 		= "HPQCReport";
	public static final String HPQCReportFileName 	= "HPQCReport.xlsx";
	public static final String[] headers = {"Req ID", "Project Plan UID", "DEV / CFG ID", "RICEFW Type", "Track", 
											"Complexity", "Plan Group", "Business Area", "Name", "DEV / CFG Status", 
											"Assigned To", "Developer/Configurator", "Technical Development Lead", 
											"SPOC", "Plan Finish", "   Plan Start   ", "Actual Start", 
											"             ETC             ", "Actual Finish", "Roadblock", 
											"Roadblock Status", "BARG", "Schedule Adherence", "Decommission", "Comments", 
											"Requirement Type", "Target Cycle", "Target Release", "Status Summary" };
	public static final String dateFormat 			= "mm/dd/yyyy";
	public static final String devCfgStatus1 		= "60-FUT Approved";
	public static final String devCfgStatus2 		= "60-TS Approved";
	public static final String devCfgStatus3 		= "60-Ready for QUT/FUT";
	public static final String devCfgStatus4		= "70-FUT Approved";
	public static final String devCfgStatus5 		= "50-FUT Approved";
	public static final String devCfgStatus6 		= "60-FS Approved";
	public static final String bargYellow			= "Y";
	public static final String bargRed				= "R";
	public static final String bargGreen			= "G";
	public static final String bargAmber			= "A";
	public static final String bargBlue				= "B";
	public static final String SchAdherDelayed		= "DELAYED";
	public static final String SchAdherOnTime		= "ON TIME";
}
