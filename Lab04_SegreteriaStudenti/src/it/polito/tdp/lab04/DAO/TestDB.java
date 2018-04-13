package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {
		
		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		StudenteDAO sdao = new StudenteDAO();
		Studente studente = sdao.getStudente(154817);
		System.out.println(studente);

	}

}
