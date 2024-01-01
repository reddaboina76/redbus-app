package com.redbus.services.impl;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.redbus.dao.IplServiceDaoImpl;
import com.redbus.pojo.Team;

public class IplServiesImpl {

	public Response registerForIpl(Team team) {
		System.out.println("Enter in to IplServiesImpl :: registerForIpl");
		double totalMatches = team.getTotalMatches();
		double win = team.getWin();
		double winRatio = (win / totalMatches) * 100;
		String message;
		if (win > 60) {
			team.setStatus("Accepted");
			// save to database
			System.out.println("Saving to Database!!");
			message = "Congratulations!! Your registered for Ipl!! Start practices!!";
			System.out.println("Team is Accepted!! Start practices!!");
		} else {
			System.out.println("Team is rejected!! Try for Next Year!!");
			message = "Sorry!! team is rejected!! Try Next Year!!";
		}
		IplServiceDaoImpl  dao = new IplServiceDaoImpl();
		dao.registerForIpl(team);
		return Response.status(200).entity(message).build();
	}

	public Team getTeam(String teamName) {
		IplServiceDaoImpl dao = new IplServiceDaoImpl();
		Team team = dao.getTeam(teamName);
		return team;
	}

	public Response deleteTeam(String teamName) {
		IplServiceDaoImpl dao = new IplServiceDaoImpl();
		int count = dao.deleteTeam(teamName);
		String message;
		if(count>0) {
			message=teamName + 	"Delete Successfully!!";
		}else {
			message= teamName +	 "Not Found!!";
		}
		return Response.status(200).entity(message).build();
	}
	
}
