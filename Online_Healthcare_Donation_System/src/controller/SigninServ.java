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


@WebServlet("/signinserv")
public class SigninServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SigninServ() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pswd");
		
		HttpSession h=request.getSession();
		h.setAttribute("email", email);
		HttpSession h1=request.getSession();
		h1.setAttribute("pswd", pass);
		boolean signin;
		
		try {
			
			 String role=new UserDao().signin(email,pass);
			 
			if (role.equals("Donar")){
				boolean confirmation=new UserDao().checkConfirmation(email);
				if( confirmation==true){
					request.getRequestDispatcher("donar.jsp").forward(request, response);
					out.print("user Donar exist");
				}
				else{
					request.setAttribute("message", "wait for Admin to accept!");
					request.getRequestDispatcher("signin.jsp").include(request, response);
					
				}
				
			}
			if (role.equals("NGO")){
				boolean confirmation2=new UserDao().checkConfirmation(email);
				out.print("user NGO exist");
				
				if( confirmation2==true){
					request.getRequestDispatcher("ngo.jsp").forward(request, response);
					out.print("user Donar exist");
				}
				else{
					request.getRequestDispatcher("signin.jsp").include(request, response);
				}
			}
			if (email.equals("admin@gmail.com") && pass.equals("123")){
				int setrole=new UserDao().setRole(email,pass);
				if(setrole>0){
					out.print("role set");
					out.print("user admin exist");
					request.getRequestDispatcher("adminprofile.jsp").forward(request, response);
				}
				
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
