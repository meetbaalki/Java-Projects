package com.harley.hpqc.model;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="hpqc_report")
public class HPQCRecord {
	
	@Id
	@Column (name="req_id")
	private int reqId;
	
	@Column (name="project_plan_uid")
	private double projectPlanUID;
	
	@Column (name="dev_cfg_id")
	private String DevCfgId;
	
	@Column (name="ricefw_type")
	private String RICEFWType;
	
	@Column (name="track")
	private String track;
	
	@Column (name="complexity")
	private String complexity;
	
	@Column (name="plan_group")
	private String planGroup;
	
	@Column (name="business_area")
	private String businessArea;
	
	@Column (name="name")
	private String name;
	
	@Column (name="dev_cfg_status")
	private String DevCfgStatus;
	
	@Column (name="assigned_to")
	private String assignedTo;
	
	@Column (name="developer_configurator")
	private String developerConfigurator;
	
	@Column (name="technical_development_lead")
	private String techDevLead;
	
	@Column (name="spoc")
	private String SPOC;
	
	@Column (name="plan_finish_date")
	private Date planFinishDate;
	
	@Column (name="plan_start_date")
	private Date planStartDate;
	
	@Column (name="actual_start_date")
	private Date actualStartDate;
	
	@Column (name="etc_date")
	private Date etcDate;
	
	@Column (name="actual_finish_date")
	private Date actualFinishDate;
	
	@Column (name="roadblock")
	private String roadblock;
	
	@Column (name="roadblock_status")
	private String roadblockStatus;
	
	@Column (name="barg")
	private String barg;
	
	@Column (name="schedule_adherence")
	private String scheduleAdherence;
	
	@Column (name="decommission")
	private String decommission;
	
	@Column (name="comments")
	private Clob comments;
	
	@Column (name="requirement_type")
	private String requirementType;
	
	@Column (name="target_cycle")
	private String targetCycle;
	
	@Column (name="target_release")
	private String targetRelease;
	
	@Column (name="status_summary")
	private String statusSummary;

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public double getProjectPlanUID() {
		return projectPlanUID;
	}

	public void setProjectPlanUID(double projectPlanUID) {
		this.projectPlanUID = projectPlanUID;
	}

	public String getDevCfgId() {
		return DevCfgId;
	}

	public void setDevCfgId(String devCfgId) {
		DevCfgId = devCfgId;
	}

	public String getRICEFWType() {
		return RICEFWType;
	}

	public void setRICEFWType(String rICEFWType) {
		RICEFWType = rICEFWType;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public String getPlanGroup() {
		return planGroup;
	}

	public void setPlanGroup(String planGroup) {
		this.planGroup = planGroup;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDevCfgStatus() {
		return DevCfgStatus;
	}

	public void setDevCfgStatus(String devCfgStatus) {
		DevCfgStatus = devCfgStatus;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getDeveloperConfigurator() {
		return developerConfigurator;
	}

	public void setDeveloperConfigurator(String developerConfigurator) {
		this.developerConfigurator = developerConfigurator;
	}

	public String getTechDevLead() {
		return techDevLead;
	}

	public void setTechDevLead(String techDevLead) {
		this.techDevLead = techDevLead;
	}

	public String getSPOC() {
		return SPOC;
	}

	public void setSPOC(String sPOC) {
		SPOC = sPOC;
	}

	public Date getPlanFinishDate() {
		return planFinishDate;
	}

	public void setPlanFinishDate(Date planFinishDate) {
		this.planFinishDate = planFinishDate;
	}

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getEtcDate() {
		return etcDate;
	}

	public void setEtcDate(Date etcDate) {
		this.etcDate = etcDate;
	}

	public Date getActualFinishDate() {
		return actualFinishDate;
	}

	public void setActualFinishDate(Date actualFinishDate) {
		this.actualFinishDate = actualFinishDate;
	}

	public String getRoadblock() {
		return roadblock;
	}

	public void setRoadblock(String roadblock) {
		this.roadblock = roadblock;
	}

	public String getRoadblockStatus() {
		return roadblockStatus;
	}

	public void setRoadblockStatus(String roadblockStatus) {
		this.roadblockStatus = roadblockStatus;
	}

	public String getBarg() {
		return barg;
	}

	public void setBarg(String barg) {
		this.barg = barg;
	}

	public String getScheduleAdherence() {
		return scheduleAdherence;
	}

	public void setScheduleAdherence(String scheduleAdherence) {
		this.scheduleAdherence = scheduleAdherence;
	}

	public String getDecommission() {
		return decommission;
	}

	public void setDecommission(String decommission) {
		this.decommission = decommission;
	}

	public Clob getComments() {
		return comments;
	}

	public void setComments(Clob comments) {
		this.comments = comments;
	}

	public String getRequirementType() {
		return requirementType;
	}

	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}

	public String getTargetCycle() {
		return targetCycle;
	}

	public void setTargetCycle(String targetCycle) {
		this.targetCycle = targetCycle;
	}

	public String getTargetRelease() {
		return targetRelease;
	}

	public void setTargetRelease(String targetRelease) {
		this.targetRelease = targetRelease;
	}

	public String getStatusSummary() {
		return statusSummary;
	}

	public void setStatusSummary(String statusSummary) {
		this.statusSummary = statusSummary;
	}
	
	public String toString() {
		if((planFinishDate != null) && (planStartDate != null) && (actualStartDate != null) &&
		   (etcDate != null) && (actualFinishDate != null)) {
			return reqId +", "+  projectPlanUID +", "+  DevCfgId +", "+  RICEFWType +", "
				+  track +", "+  complexity +", "+  planGroup +", "+  businessArea +", "+  name +", "
				+  DevCfgStatus +", "+  assignedTo  +", "+  developerConfigurator +", "+  techDevLead +", "
				+  SPOC +", "+  planFinishDate.toString() +", "+  planStartDate.toString() +", "
				+  actualStartDate.toString() +", "	+  etcDate.toString() +", "+  actualFinishDate.toString() +", "
				+  roadblock +", "+  roadblockStatus +", "	+  barg +", "+  scheduleAdherence +", "
				+  decommission +", "+  comments +", "	+  requirementType +", "+  targetCycle +", "
				+  targetRelease +", "+  statusSummary;
		}
		return reqId +", "+  projectPlanUID +", "+  DevCfgId +", "+  RICEFWType +", "
			+  track +", "+  complexity +", "+  planGroup +", "+  businessArea +", "+  name +", "
			+  DevCfgStatus +", "+  assignedTo  +", "+  developerConfigurator +", "+  techDevLead +", "
			+  SPOC +", "+  " " +", "+  " " +", " +  " " +", "	+  " " +", "+  " " +", "
			+  roadblock +", "+  roadblockStatus +", "	+  barg +", "+  scheduleAdherence +", "
			+  decommission +", "+  comments +", "	+  requirementType +", "+  targetCycle +", "
			+  targetRelease +", "+  statusSummary;
		
	}
	
}
