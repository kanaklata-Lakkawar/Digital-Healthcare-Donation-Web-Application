package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/signupngoserv")
public class SignupNgoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignupNgoServ() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println();
		
	
		int insert;
		int insert2;
		try {
			String n=request.getParameter("ngo");
			
			
			insert2= new UserDao().signupNgoUser(request.getParameter("name"), request.getParameter("lname"), request.getParameter("email"), request.getParameter("pswd"), request.getParameter("mob"), request.getParameter("gender"),  request.getParameter("idproof"),request.getParameter("ngo"),request.getParameter("role"));
			insert = new UserDao().signupNgo(request.getParameter("name"), request.getParameter("lname"), request.getParameter("email"), request.getParameter("pswd"), request.getParameter("mob"), request.getParameter("gender"),  request.getParameter("idproof"),request.getParameter("ngo"),request.getParameter("role"));
			
			if(insert>0){
				
				 request.setAttribute("message2", "User(NGO) Registered Successfully!");
				request.getRequestDispatcher("signin.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//request.getRequestDispatcher("signin.jsp").include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
