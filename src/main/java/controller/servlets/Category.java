package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Product;
import controller.databases.DatabaseController;
import utils.StringUtils;
@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    DatabaseController dbController;
    public Category() {
        super();
        this.dbController = new DatabaseController();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		if(category.equals("all")){

			ArrayList<Product> products = (ArrayList<Product>) dbController.getProductsInfo();
			request.setAttribute(StringUtils.PRODUCTS_LISTS, products);
			request.getRequestDispatcher("/pages/products.jsp").forward(request, response);
			
		}else {
			ArrayList<Product> products = (ArrayList<Product>) dbController.getProductsCategoryWise(category);
			request.setAttribute(StringUtils.PRODUCTS_LISTS, products);
			request.getRequestDispatcher("/pages/products.jsp").forward(request, response);	
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
