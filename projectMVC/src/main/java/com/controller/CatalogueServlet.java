package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.Catalogue;
import com.view.CategorieForm;


@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CatalogueServlet() {
        super();
        
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse responce) throws IOException , ServletException {
    	CategorieForm cf = new CategorieForm();
    	Catalogue catalogue = new Catalogue();
    	if(request.getParameter("addCat") != null) {
    		cf.setNomCategorie(request.getParameter("nomCat"));
    		cf.setDescription(request.getParameter("description"));
    		catalogue.addCategorie(cf.getNomCategorie(), cf.getDescription());
    		cf.setLesCategories(catalogue.selectAll());
    	}else if (request.getParameter("idCat") != null) {
    		cf.setIdCategorie(Long.parseLong(request.getParameter("idCat")));
    		catalogue.deleteCategorie(cf.getIdCategorie());
    		cf.setLesCategories(catalogue.selectAll());
    	}else if (request.getParameter("chercheCat") != null) {
    		cf.setMotCle(request.getParameter("motCle"));
    		cf.setLesCategories(catalogue.selectById(cf.getMotCle()));
    	}else {
    		cf.setLesCategories(catalogue.selectAll());
    	}
    	
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("catForm", cf);
    	responce.sendRedirect("admin_catalogue.jsp");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		processRequest(request, response);
	}

}
