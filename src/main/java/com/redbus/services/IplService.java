package com.redbus.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.redbus.pojo.Team;
import com.redbus.services.impl.IplServiesImpl;

@Path(value = "/ipl")
public class IplService {
	@GET
	@Path(value = "/wish")
	public Response wishMe() {
		System.out.println("Executing wishMe!!");
		String message = "GoodMorning!!";
		System.out.println("Exiting wishMe!!");
		return Response.status(201).entity(message).build();
	}
	@POST
	@Path(value = "/registerTem")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response registerForIpl(Team team) {
		
		System.out.println("Enter in to IplService :: registerForIpl");
		IplServiesImpl service = new IplServiesImpl();
		System.out.println("Exit in to IplService :: registerForIpl");
		return service.registerForIpl(team);
	}
	@GET
	@Path(value="/getTeamJson")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeamJson(@QueryParam("name") String teamName) {
		System.out.println("Enter into getTeamJson  " + teamName);
		IplServiesImpl service = new IplServiesImpl();
		Team team = service.getTeam(teamName);
		return Response.status(200).entity(team).build();
	}
	@GET
	@Path(value="/getTeamXml")
	@Produces(MediaType.APPLICATION_XML)
	public Response getTeamXml(@QueryParam("name") String teamName) {
		System.out.println("Enter into getTeamXml  " + teamName);
		IplServiesImpl service = new IplServiesImpl();
		Team team = service.getTeam(teamName);
		return Response.status(200).entity(team).build();
	}
	@GET
	@Path(value="/getTeam")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getTeam(@QueryParam("name") String teamName) {
		System.out.println("Enter into getTeam  " + teamName);
		IplServiesImpl service = new IplServiesImpl();
		Team team = service.getTeam(teamName);
		return Response.status(200).entity(team).build();
	}
	
	@DELETE
	@Path(value="/deleteTeam/{name}")
	public Response deleteTeam(@PathParam("name") String teamName) {
		IplServiesImpl service = new IplServiesImpl();
		return service.deleteTeam(teamName);
	}
}
