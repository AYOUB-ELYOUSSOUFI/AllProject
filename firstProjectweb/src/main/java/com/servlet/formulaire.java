package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/formulaire")
public class formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public formulaire() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter sortie = response.getWriter();
		sortie.println("<htmn>");
		sortie.println("<head><title>Enregistrement coordonnees</title></head>");
		sortie.println("<body bgcolor=orange text=yellow>");
		sortie.println("<h2>Enregistrements de vos coordonnees effectue</h2>");
		sortie.print("<p><b>Bonjour "+request.getParameter("civilite")+" ");
		sortie.print(request.getParameter("prenom")+" ");
		sortie.print(request.getParameter("nom")+" ");
		int age = Integer.parseInt(request.getParameter("age"));
		String message = "Vous etes un ";
		if(age>0 && age <12)
			message += "enfant.";
		if(age>=12 && age <18)
			message += "adolescent.";
		if(age>=18 && age <60)
			message += "adulte.";
		if(age>=60)
			message += "une personne du troisieme age.";
		sortie.println("<p>"+ message + "</b></body></html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
