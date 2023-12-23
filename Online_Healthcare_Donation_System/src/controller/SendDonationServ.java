package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sendonationserv")
public class SendDonationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SendDonationServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int sent=new UserDao().sendDonation(request.getParameter("name"),request.getParameter("mob"),Integer.parseInt(request.getParameter("id")) );
		
		if (sent>0){
			System.out.println("Donation sent");
			request.setAttribute("message5", "Donation sent successfully!");
			request.getRequestDispatcher("sendonation.jsp").forward(request, response);
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
