package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.io.FileOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



import java.io.InputStream;

@MultipartConfig
@WebServlet("/imgupload")
public class ImgUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ImgUpload() {
        super();
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession h=request.getSession();
		String email=(String) h.getAttribute("email");
    	Part file=request.getPart("image");
		String imageFileName=getSubmittedFileName(file);
		
		String uploadPath="D:/javaPrograms/Online_Medicine_Donation_System/WebContent/upload/"+imageFileName;
		System.out.println("Image name : "+imageFileName);
		System.out.println("Path : "+uploadPath);
		try
		{
			
		FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
	
		
		//Database Code
		
			int x;
			try {
				x = new UserDao().saveName(imageFileName,email);
			
				if(x>0){
					System.out.println("Image Name inserted");
					request.getRequestDispatcher("voluntarydonation.jsp").forward(request, response);
				}
					
				else
					System.out.println("Image Name Not inserted");
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
		//Show uploaded image on page
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<img src='"+uploadPath+"' alt='Uploaded Image'>");
		
		
	}
	
	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
	}


