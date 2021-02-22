package com.olmo.Baloncesto.repository;

import java.util.Set;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.olmo.Baloncesto.entity.Equipos;
import com.olmo.Baloncesto.entity.Jugadores;
import com.olmo.Baloncesto.entity.Partidos;
import com.olmo.Baloncesto.service.HibernateUtil;

public class EquiposDAO {
	//Obtenemos el SessionFactory
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	

	
	public void create(String nombre ,String ciudad, String conferencia , String division, 
			Set<Jugadores> jugadoreses, Set<Partidos> partidosesForEquipoVisitante, Set<Partidos> partidosesForEquipoLocal) {
		
		//Abrimos la sesión mediante el SessionFactory
		Session session =sessionFactory.openSession();
		
		//Creamos el objeto
		Equipos equipo = new Equipos(nombre,ciudad,conferencia,division,jugadoreses, partidosesForEquipoVisitante, partidosesForEquipoLocal);
		 Transaction tx=(Transaction) session.beginTransaction();

		session.save(equipo);//<|--- Aqui guardamos el objeto en la base de datos.

		try {
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.close();
		sessionFactory.close(); 
		
	}
	
	public Equipos read(String nombre ) {
		
		//Abrimos la sesión mediante el SessionFactory
		Session session =sessionFactory.openSession();
		Equipos equipo =(Equipos)session.get(Equipos.class,nombre); 
		session.close();
		sessionFactory.close(); 
		return equipo;
	}
	

}
