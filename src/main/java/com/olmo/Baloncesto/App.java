package com.olmo.Baloncesto;

import com.olmo.Baloncesto.repository.EquiposDAO;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	
    	EquiposDAO equiposDAO = new EquiposDAO();
    	
    	
        System.out.println( equiposDAO.read("Dallas Mavericks") );
    }
}
