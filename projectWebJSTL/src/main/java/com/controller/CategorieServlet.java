package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CategorieDao;
import com.models.Categorie;
import com.service.CategorieDaoImp;
import com.view.CategorieForm;


@WebServlet("/adminCategorie")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategorieServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieForm cf = new CategorieForm();
		CategorieDao catalogue = new CategorieDaoImp();
		if(request.getParameter("addCat") != null) {
			cf.setNomCat(request.getParameter("nomCat"));
			cf.setDescription(request.getParameter("description"));
			Categorie cat = new Categorie();
			cat.setNom(request.getParameter("nomCat"));
			cat.setDescription(request.getParameter("description"));
			catalogue.addCategorie(cat);
			cf.setLesCategories(catalogue.listCategories());
		}else if(request.getParameter("idCat") != null){
			cf.setIdCat(Long.parseLong(request.getParameter("idCat")));
			catalogue.removeCategorie((int)cf.getIdCat() );
			cf.setLesCategories(catalogue.listCategories());
		}else if(request.getParameter("chercheCat") != null) {
			cf.setMotCle(request.getParameter("motCle"));
			cf.setLesCategories(catalogue.selectCatByKeyword(cf.getMotCle()));
		}else {
			cf.setLesCategories(catalogue.listCategories());
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("catForm", cf);
		response.sendRedirect("Categorie.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
