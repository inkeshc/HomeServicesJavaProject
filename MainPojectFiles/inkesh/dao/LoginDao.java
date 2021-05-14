package com.inkesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.inkesh.Customer;
import com.inkesh.Login;





public class LoginDao {
	
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}  
	 public Customer validateUser(Login login) {
		    String sql = "select * from cust where emailC='" + login.getEmailC() + "' and password='" + login.getPassword()
		    + "'";
		    List<Customer> users = template.query(sql, new UserMapper());
		    return users.size() > 0 ? users.get(0) : null;
		    }
	 class UserMapper implements RowMapper< Customer> {
		  public  Customer mapRow(ResultSet rs, int arg1) throws SQLException {
			  Customer e = new  Customer();
			    e.setId(rs.getInt(1));    
	            e.setFname(rs.getString(2));
	            e.setLname(rs.getString(3)); 
	            e.setEmailC(rs.getString(4));
	            e.setPassword(rs.getString(5));
	            e.setMobile_no(rs.getLong(6)); 
	            return e;
		   
		  }
	 }
	}
