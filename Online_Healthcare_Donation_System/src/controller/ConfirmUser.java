package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;


@WebServlet("/confirmuser")
public class ConfirmUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ConfirmUser() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 String[] selectedUserIds = request.getParameterValues("selectedUsers");

	        if (selectedUserIds != null && selectedUserIds.length > 0) {
	            UserDao userDao = new UserDao();

	           
	            for (String userId : selectedUserIds) {
	                int userIdInt = Integer.parseInt(userId);
	               
	               
	                	
	                	int resultUser;
						try {
							resultUser = new UserDao().updateConfirmationStatus(userIdInt, true);
						  if(resultUser>0){
								request.getRequestDispatcher("Userlist.jsp").forward(request, response);
								
							}
	                      
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

	                
	                	
						
				
	            }
	        }

	       
	       
	    }
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
