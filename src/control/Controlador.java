package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Conexion;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/logica")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		if (request.getParameter("login") != null) {
			String usuario = request.getParameter("usr");
			se.setAttribute("usu", usuario);
			
			String contra = request.getParameter("pass");
			se.setAttribute("con", contra);
			
			Boolean log = Conexion.logIng(usuario,contra);
			
			if(log) {
				request.getRequestDispatcher("jsp/exito.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("jsp/fallo.jsp").forward(request, response);
			}
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
