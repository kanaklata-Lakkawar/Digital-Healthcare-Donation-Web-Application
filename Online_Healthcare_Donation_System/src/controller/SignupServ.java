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


@WebServlet("/signupserv")
public class SignupServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignupServ() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println();
		
	
		int insert;

		try {
			
		
			insert = new UserDao().signup(request.getParameter("fname"), request.getParameter("lname"), request.getParameter("email"), request.getParameter("pswd"), request.getParameter("mob"), request.getParameter("gender"),  request.getParameter("idproof"),request.getParameter("role"));
                                                                                                                                                                                                                                                                
			if(insert>0){
				out.print("user inserted");
				 request.setAttribute("message3", "User Registered Successfully!");
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
