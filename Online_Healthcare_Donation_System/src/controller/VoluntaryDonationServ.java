package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/voluntarydonationserv")
public class VoluntaryDonationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VoluntaryDonationServ() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession h=request.getSession();
		String email=(String) h.getAttribute("email");
		
		int insert;
		try {
			insert = new UserDao().insertDonationInfo(email,request.getParameter("ngo"),request.getParameter("brand"),request.getParameter("generic"),Integer.parseInt(request.getParameter("qty")),request.getParameter("mfdDt"),request.getParameter("expDt"));
		
			if (insert>0){
				request.getRequestDispatcher("uploadImg.jsp").include(request, response);
			}
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
