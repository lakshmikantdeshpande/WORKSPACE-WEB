package com.data;
import com.model.*;
import java.sql.*;

public class DAO {
	public static void saveUser(User user) throws Exception{
		Connection con=null;
		try{
			con=DBManager.getConnection();
			PreparedStatement st=con.prepareStatement("insert login values(?,?,?,?,?)");
			st.setString(1, user.getName());
			st.setString(2,user.getUsername());
			st.setString(3,user.getPassword());
			st.setString(4, user.getMobno());
			st.setString(5, user.getEmailid());
			
		
			int result=st.executeUpdate();
			if(result!=1){
				throw new Exception("data not inserted");
				
			}
			
			
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
			
		}
		finally{
			if(con!=null){
				try{
					con.close();
					
				}
				catch(Exception e2){
					throw new Exception(e2.getMessage());
					
				}
				}
		}
	}
	
public static User getUser(String username, String password) throws DataException{
	Connection con=null;
	User user=null;
	try{
		con=DBManager.getConnection();
		
	}
	catch(Exception e){
		throw new DataException(e.getMessage());
		
	}
	try{
		PreparedStatement st=con.prepareStatement("select * from login where username=? and password=?");
		st.setString(1, username);
		st.setString(2,password);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{

				user=new User();
				user.setUsername(username);
				user.setPassword(rs.getString(2));
		}
		else
		{
			throw new DataException("Invalid credentials !!");
		}
	}
		catch(Exception e){
			throw new DataException(e.getMessage());
		}
	return user;
	}
}