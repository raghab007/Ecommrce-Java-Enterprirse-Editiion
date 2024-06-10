package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.databases.DatabaseController;

/**
 * Servlet implementation class ChangeDeliveryStatus
 */
@WebServlet("/ChangeDeliveryStatus")
public class ChangeDeliveryStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeDeliveryStatus() {
    	dbController = new DatabaseController();
    	
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		dbController.changeDeliveryStatus(orderId);
		response.sendRedirect(request.getContextPath()+"/AllOrders");
	
	
	}

}
