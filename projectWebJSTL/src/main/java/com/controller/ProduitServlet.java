package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CategorieDao;
import com.dao.ProduitDao;
import com.models.Categorie;
import com.models.Produit;
import com.service.CategorieDaoImp;
import com.service.ProduitDaoImp;
import com.view.CategorieForm;
import com.view.ProduitForm;


@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProduitForm pf = new ProduitForm();
		ProduitDao catalogue = new ProduitDaoImp();
		if(request.getParameter("addProd") != null) {
			pf.setDescription(request.getParameter("description"));
			pf.setPrix(Double.parseDouble(request.getParameter("prix")));
			pf.setQuantite(Integer.parseInt(request.getParameter("quantite")));
			pf.setSrd(Integer.parseInt(request.getParameter("srd")));
			//pf.setLesCategories(request.getParameter("nomCategorie"));
			Produit prod = new Produit();
			prod.setDescription(request.getParameter("description"));
			prod.setPrix(Double.parseDouble(request.getParameter("prix")));
			prod.setQuantite(Integer.parseInt(request.getParameter("quantite")));
			prod.setSdr(Integer.parseInt(request.getParameter("srd")));
			//prod.setLesCategories(request.getParameter("nomCategorie"));
			catalogue.addProduit(prod);
			pf.setLesProduits(catalogue.listProduits());
		}else if(request.getParameter("idProd") != null){
			pf.setId(Long.parseLong(request.getParameter("idProd")));
			catalogue.removeProduit((int)pf.getId() );
			pf.setLesProduits(catalogue.listProduits());
		}else if(request.getParameter("chercheProd") != null) {
			pf.setMotClePr(request.getParameter("motClePr"));
			pf.setLesProduits(catalogue.selectProdByKeyword(pf.getMotClePr()));
		}else {
			pf.setLesProduits(catalogue.listProduits());
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("prodForm", pf);
		response.sendRedirect("Produit.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
