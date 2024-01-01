package com.redbus.dao;

import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.redbus.pojo.Team;

public class IplServiceDaoImpl {

	public static void registerForIpl(Team team) {
		System.out.println("Enter in to IplServiceDaoImpl :: registerForIpl");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(team);
		tx.commit();
		session.close();
		System.out.println("Exit in to IplServiceDaoImpl :: registerForIpl");
	}
	public Team getTeam(String teamName) {
		System.out.println("Enter in to IplServiceDaoImpl :: getTeam");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Team team = (Team) session.get(Team.class, teamName);
		System.out.println("Exit in to IplServiceDaoImpl :: getTeam");
		return team;
	}
	public int deleteTeam(String teamName) {
		System.out.println("Enter in to IplServiceDaoImpl :: getTeam");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query deleteQuery = session.createQuery("delete from Team where teamName=?");
		deleteQuery.setParameter(0, teamName);
		int count = deleteQuery.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		System.out.println("Exit in to IplServiceDaoImpl :: getTeam");
		return count;
	}
}
