package controller;
import java.sql.Connection;




import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;

import model.Donar;
import model.Medicine;
import model.User;


public class UserDao {

	Connection getConnect() throws ClassNotFoundException, SQLException
	{
		//step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Step 1");
		//step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_donation_db","root","abc123");
		System.out.println("Step 2");
		
		return con;
	}
	
public int signup(String fname, String lname,String email,String pass,String mob,String gender,String id,String role) throws ClassNotFoundException, SQLException{
		
		Connection con=getConnect();
		
		String sql="INSERT INTO user_tbl (first_name,last_name,email,pass,mob_no,gender,id_proof,role) VALUES (?,?,?,?,?,?,?,?)";
	    System.out.println("step 1");
		PreparedStatement ps=con.prepareStatement(sql);
	    System.out.println("step 2");
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, email);
		ps.setString(4, pass);
		ps.setString(5, mob);
		ps.setString(6, gender);
		ps.setString(7, id);
		ps.setString(8, role);
	    System.out.println("step 3");
		int insert=ps.executeUpdate();	
	    System.out.println("step 4");
	    System.out.println("step 5 "+insert);
	    return insert;
			
	}
public int signupNgoUser(String fname, String lname, String email, String pass, String mob,
		String gender, String id, String ngo, String role) throws ClassNotFoundException, SQLException {

	Connection con=getConnect();
	
	String sql="INSERT INTO user_tbl (first_name,last_name,email,pass,mob_no,gender,id_proof,ngo_name,role) VALUES (?,?,?,?,?,?,?,?,?)";
	
	System.out.println("step 1");
	PreparedStatement ps=con.prepareStatement(sql);
    System.out.println("step 2");
	ps.setString(1, fname);
	ps.setString(2, lname);
	ps.setString(3, email);
	ps.setString(4, pass);
	ps.setString(5, mob);
	ps.setString(6, gender);
	ps.setString(7, id);	
	ps.setString(8,ngo);
	ps.setString(9,role);
    System.out.println("step 3");
	int insert=ps.executeUpdate();	
    System.out.println("step 4");
    System.out.println("step 5 "+insert);
    return insert;
}
public int signupNgo(String fname, String lname, String email, String pass, String mob,
		String gender, String id, String ngo, String role) throws ClassNotFoundException, SQLException {

	Connection con=getConnect();
	
	String sql="INSERT INTO ngo_tbl (first_name,last_name,email,pass,mob_no,gender,id_proof,ngo_name,role) VALUES (?,?,?,?,?,?,?,?,?)";
    System.out.println("step 1");
	PreparedStatement ps=con.prepareStatement(sql);
    System.out.println("step 2");
	ps.setString(1, fname);
	ps.setString(2, lname);
	ps.setString(3, email);
	ps.setString(4, pass);
	ps.setString(5, mob);
	ps.setString(6, gender);
	ps.setString(7, id);	
	ps.setString(8,ngo);
	ps.setString(9,role);
    System.out.println("step 3");
	int insert=ps.executeUpdate();	
    System.out.println("step 4");
    System.out.println("step 5 "+insert);
    return insert;
}
	public String signin(String email, String pass) throws ClassNotFoundException, SQLException {
		 Connection con = getConnect();
		    System.out.println("Step 1 check user");
		    String sql = "SELECT role FROM user_tbl WHERE email = ? AND pass = ?";
		    PreparedStatement st = con.prepareStatement(sql);
		    System.out.println("Step 2 check user");
		    st.setString(1, email);
		    st.setString(2, pass);
		    
		    System.out.println("email "+email);
		    System.out.println("pass "+pass);
		    System.out.println("Step 3 check user");
		    ResultSet rs = st.executeQuery();
		    System.out.println("Step 4 check user");
		    String role = null;
		    if (rs.next()) {
		    
		        role = rs.getString("role");
		        System.out.print("role : "+role);
		    }
		    System.out.println("Step 5 check user "+role);
		    con.close();
		    return role;	
	}
	

	public int setRole(String email, String pass) throws ClassNotFoundException, SQLException {
		Connection con = getConnect();
	    System.out.println("Step 1 check user");
	    String sql = "UPDATE user_tbl SET role='Admin' WHERE email = ? AND pass = ? ";
	    PreparedStatement st = con.prepareStatement(sql);
	    System.out.println("Step 2 check user");
	    st.setString(1, email);
	    st.setString(2, pass);
	  int setrole= st.executeUpdate();
	return setrole;
	   	
	}
	public ArrayList<User> getAllUser() throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		 System.out.println("Step 1");
		String sql="SELECT * FROM user_tbl Where role!='Admin'";
		PreparedStatement ps=con.prepareStatement(sql);
		 System.out.println("Step 2");
		ArrayList<User> list=new ArrayList<>();
		 System.out.println("Step 3");
		ResultSet rs=ps.executeQuery();
		System.out.println("Step 4");
			while(rs.next()){
				
				User u=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getBoolean(10));
				System.out.println("Step 5 u: "+u);
				list.add(u);
				System.out.print("User u : "+list);
			}
			 System.out.println("Step 6 "+list);
			return list;
	}
	public ArrayList<User> getAllNgoUser() throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		 System.out.println("Step 1");
		String sql="SELECT * FROM ngo_tbl";
		PreparedStatement ps=con.prepareStatement(sql);
		 System.out.println("Step 2");
		ArrayList<User> list=new ArrayList<>();
		 System.out.println("Step 3");
		ResultSet rs=ps.executeQuery();
		System.out.println("Step 4");
			while(rs.next()){
				
				User u=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				System.out.println("Step 5 u: "+u);
				list.add(u);
				System.out.print("User u : "+list);
			}
			 System.out.println("Step 6 "+list);
			return list;
	}
	
	public ArrayList<Medicine> getAllReqMed() throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		 System.out.println("Step 1");
		String sql="SELECT * FROM medicine_tbl ";
		PreparedStatement ps=con.prepareStatement(sql);
		 System.out.println("Step 2");
		ArrayList<Medicine> list=new ArrayList<>();
		 System.out.println("Step 3");
		ResultSet rs=ps.executeQuery();
		System.out.println("Step 4");
			while(rs.next()){
				
				Medicine m=new Medicine(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
				System.out.println("Step 5 u: "+m);
				list.add(m);
				System.out.print("User u : "+list);
			}
			 System.out.println("Step 6 "+list);
			return list;
	}
	

	public int insertMedicine(String ngo, String brand, String generic, int qty,String add) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		String sql="INSERT INTO medicine_tbl (ngo_name, brand, generic, qty, address) VALUES (?,?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1, ngo);
        ps.setString(2, brand);
        ps.setString(3, generic);
        ps.setInt(4, qty);
        ps.setString(5, add);
        int insert=ps.executeUpdate();
        return insert;
	}

	
public Medicine getDaonationDetail(int id) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		System.out.println(" med step 1" );
		String sql="SELECT * FROM medicine_tbl WHERE medicine_id=?";
	
		PreparedStatement ps=con.prepareStatement(sql);
	
		ps.setInt(1, id);
		System.out.println(" med step 2" );
		Medicine u=null;
		ResultSet rs=ps.executeQuery();
		System.out.println(" med step 3" );
		while(rs.next()){
			u=new Medicine(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
			System.out.println(" med step 4 "+u );
		}
		System.out.println(" med step 5 "+u );
		return u;
		
	}

public int sendDonation(String name, String mob, int id) throws ClassNotFoundException, SQLException {
	Connection con=getConnect();
	 System.out.println("conf Step 1");
	 String sql="UPDATE medicine_tbl SET sender_name=?, mob_no=? WHERE medicine_id=?";
	 PreparedStatement ps=con.prepareStatement(sql);
	 System.out.println("conf Step 1 ");
	 ps.setString(1, name);
    ps.setString(2, mob);
    ps.setInt(3, id);
  	 System.out.println("conf Step 2 ");
	 int sent=ps.executeUpdate();
	 System.out.println("conf Step 3 "+sent);
	 return sent;
	
}

public ArrayList<Medicine> trackReqMedicine() throws ClassNotFoundException, SQLException {
	Connection con=getConnect();
	 System.out.println("Step 1");
	String sql="SELECT * FROM medicine_tbl";
	PreparedStatement ps=con.prepareStatement(sql);
	 System.out.println("Step 2");
	ArrayList<Medicine> list=new ArrayList<>();
	 System.out.println("Step 3");
	ResultSet rs=ps.executeQuery();
	System.out.println("Step 4");
		while(rs.next()){
			
			Medicine m=new Medicine(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
			System.out.println("Step 5 u: "+m);
			list.add(m);
			System.out.print("User u : "+list);
		}
		 System.out.println("Step 6 "+list);
		return list;
}
public LinkedHashSet<User> getNgolist() throws ClassNotFoundException, SQLException {
	
	Connection con=getConnect();
	System.out.println("Step 1 Category");
	String sql="SELECT DISTINCT ngo_name FROM user_tbl WHERE ngo_name IS NOT NULL";
	System.out.println("Step 2 Category");
	PreparedStatement ps=con.prepareStatement(sql);
	System.out.println("Step 3 Category");
	
	
	ResultSet rs= ps.executeQuery();
	System.out.println("Step 4 Category");
	LinkedHashSet<User> list=new LinkedHashSet<>();
	System.out.println("Step 5 Category");
	 while(rs.next())
	 {
		 User c=new User(rs.getString("ngo_name"));
		 System.out.println("Step 6 Category");
		list.add(c);
		 System.out.println("Step 7 Category");
	 }
	
	return list;
}

public int insertDonationInfo(String email, String ngo, String brand, String generic, int qty, String mfdDt, String expDt) throws ClassNotFoundException, SQLException {
	
	Connection con=getConnect();
	String sql="INSERT INTO donation_tbl (donar_email,ngo_name, brand, generic, qty, MFD_dt, EXP_dt) VALUES (?,?,?,?,?,?,?)";
	PreparedStatement ps= con.prepareStatement(sql);
	ps.setString(1, email);
	ps.setString(2, ngo);
    ps.setString(3, brand);
    ps.setString(4, generic);
    ps.setInt(5, qty);
    ps.setString(6, mfdDt);
    ps.setString(7, expDt);
    int insert=ps.executeUpdate();
    return insert;
}

public int saveName(String imageFileName,String email) throws ClassNotFoundException, SQLException
{
	Connection con=getConnect();
	String sql = "UPDATE donation_tbl SET img_name=? WHERE donar_email=?";

	PreparedStatement ps=getConnect().prepareStatement(sql);
	ps.setString(1,imageFileName);
	ps.setString(2, email);
	return ps.executeUpdate();
}

public ArrayList<Donar> getUserDonationHistory(String email) throws ClassNotFoundException, SQLException {
	Connection con=getConnect();
	 System.out.println("Step 1");
	String sql="SELECT * FROM donation_tbl WHERE donar_email=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, email);
	 System.out.println("Step 2");
	ArrayList<Donar> list=new ArrayList<>();
	 System.out.println("Step 3");
	ResultSet rs=ps.executeQuery();
	System.out.println("Step 4");
		while(rs.next()){
			
			Donar m=new Donar(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9));
			System.out.println("Step 5 u: "+m);
			list.add(m);
			System.out.print("User u : "+list);
		}
		 System.out.println("Step 6 "+list);
		return list;
}

public ArrayList<Donar> viewAllDonations() throws ClassNotFoundException, SQLException {
	Connection con=getConnect();
	 System.out.println("Step 1");
	String sql="SELECT * FROM donation_tbl";
	PreparedStatement ps=con.prepareStatement(sql);
	 System.out.println("Step 2");
	ArrayList<Donar> list=new ArrayList<>();
	 System.out.println("Step 3");
	ResultSet rs=ps.executeQuery();
	System.out.println("Step 4");
		while(rs.next()){
			
			Donar m=new Donar(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9));
			System.out.println("Step 5 u: "+m);
			list.add(m);
			System.out.print("User u : "+list);
		}
		 System.out.println("Step 6 "+list);
		return list;
}

public User getProfile(String email) throws ClassNotFoundException, SQLException{

	Connection con=getConnect();
	 System.out.println("get profile Step 1");
	String sql="SELECT * FROM user_tbl WHERE email=?";
	PreparedStatement ps=con.prepareStatement(sql);
	 System.out.println(" get profile Step 2");
	 ps.setString(1, email);
	 ResultSet rs=ps.executeQuery();
	 User u=null;
	 if (rs.next()){
	u= new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(11),rs.getBoolean(10));
	 System.out.println("get profile id proof "+rs.getString(8));
	 }
	return u;	
}

public int changePassword( String email, String pass, String newPass) throws ClassNotFoundException, SQLException {
	
	Connection con=getConnect();
	System.out.println(" changeprofile stu step 1 ");
	String sql="UPDATE user_tbl set  pass=? WHERE email=? and pass=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, newPass);		
	ps.setString(2, email);
	System.out.println("New pass "+newPass);
	ps.setString(3, pass);
	System.out.println(" changeprofile    step 2 ");
	int change=ps.executeUpdate();
	System.out.println(" changeprofile   step 3 "+change); 
	return change;
	
}
public int updateConfirmationStatus(int userId, boolean conf) throws ClassNotFoundException, SQLException {
	
	Connection con=getConnect();
	 System.out.println("conf Step 1");
	 String sql="UPDATE user_tbl SET is_confirm=? WHERE id=?";
	 PreparedStatement ps=con.prepareStatement(sql);
	 System.out.println("conf Step 1 ");
	 ps.setBoolean(1, conf);
     ps.setInt(2, userId);
   	 System.out.println("conf Step 2 ");
	 int setConfirm=ps.executeUpdate();
	 System.out.println("conf Step 3 "+setConfirm);
	 return setConfirm;
	 
	

}

public boolean checkConfirmation(String email) throws ClassNotFoundException, SQLException {
	
	Connection con=getConnect();
	 System.out.println("conf Step 1");
	 String sql="SELECT is_confirm FROM user_tbl WHERE email=?";
	 PreparedStatement st = con.prepareStatement(sql);
	    System.out.println("Step 2 check user");
	    st.setString(1, email);
	   System.out.println("email "+email);
	   
	    System.out.println("Step 3 check user");
	    ResultSet rs = st.executeQuery();
	    System.out.println("Step 4 check user");
	    boolean confirmation = false;
	    if (rs.next()) {
	    
	    	confirmation = rs.getBoolean("is_confirm");
	        System.out.print("role : "+confirmation);
	    }
	    System.out.println("Step 5 check user "+confirmation);
	    con.close();
	    return confirmation;	
}
public String getNgo(String email) throws ClassNotFoundException, SQLException{
	Connection con=getConnect();
	 System.out.println("conf Step 1");
	 String sql="SELECT ngo_name FROM ngo_tbl WHERE email=?";
	 PreparedStatement st = con.prepareStatement(sql);
	    System.out.println("Step 2 check user");
	    st.setString(1, email);
	   System.out.println("email "+email);
	   
	    System.out.println("Step 3 check user");
	    ResultSet rs = st.executeQuery();
	    System.out.println("Step 4 check user");
	    String getngo = null;
	    if (rs.next()) {
	    
	    	getngo = rs.getString("ngo_name");
	        System.out.print("role : "+getngo);
	    }
	    System.out.println("Step 5 check user "+getngo);
	    con.close();
	    return getngo;
}

public ArrayList<User> getUserByFirstName(String searchName) throws ClassNotFoundException, SQLException {
	Connection con=getConnect();
	 System.out.println("Step 1");
	String sql="SELECT * FROM user_tbl WHERE first_name=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, searchName );
	 System.out.println("Step 2");
	ArrayList<User> list=new ArrayList<>();
	 System.out.println("Step 3");
	ResultSet rs=ps.executeQuery();
	System.out.println("Step 4");
		while(rs.next()){
			
			User m=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getBoolean(10));
			System.out.println("Step 5 u: "+m);
			list.add(m);
			System.out.print("User u : "+list);
		}
		 System.out.println("Step 6 "+list);
		return list;
}
}
