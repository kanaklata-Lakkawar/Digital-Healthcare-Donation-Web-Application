package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reqmedicine")
public class RequestMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RequestMedicine() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int insert=new UserDao().insertMedicine(request.getParameter("ngo"),request.getParameter("brand"),request.getParameter("generic"),Integer.parseInt(request.getParameter("qty")),request.getParameter("add"));
		
		if (insert>0){
			System.out.println("Data inserted");
			request.setAttribute("message4", "Medicine Requested successfully!");
			request.getRequestDispatcher("requestMedicine.jsp").forward(request, response);
		}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
