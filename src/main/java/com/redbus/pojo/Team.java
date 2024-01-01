package com.redbus.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "iplteam")
@XmlRootElement
public class Team {

	@Id
	private String teamName;
	private Integer totalMatches;
	private Integer win;
	private Integer lost;
	private String status="Rejected" ;
	
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Integer getTotalMatches() {
		return totalMatches;
	}
	public void setTotalMatches(Integer totalMatches) {
		this.totalMatches = totalMatches;
	}
	public Integer getWin() {
		return win;
	}
	public void setWin(Integer win) {
		this.win = win;
	}
	public Integer getLost() {
		return lost;
	}
	public void setLost(Integer lost) {
		this.lost = lost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
