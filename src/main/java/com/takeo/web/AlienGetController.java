package com.takeo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeo.web.dao.AlienDao;
import com.takeo.web.model.Alien;

/**
 * Servlet implementation class AlienGetController
 */
public class AlienGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AlienGetController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request parameter gives string so we need to parse it to int
		int aid = Integer.parseInt(request.getParameter("aid"));
		AlienDao dao  = new AlienDao();
		Alien a1 = dao.getAlien(aid);
		request.setAttribute("alien", a1);
		RequestDispatcher rd = request.getRequestDispatcher("showAlien.jsp");
		rd.forward(request, response);
		
		
	}


}
