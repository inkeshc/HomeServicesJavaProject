package com.inkesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.inkesh.Plumbing;

public class PlumbingDao {
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}  
	
	public int save(Plumbing d){    
	    String sql="insert into Plumbing_table(category_P,sub_service_P,date_P,time1_P) values('"+d.getCategory_P()+"','"+d.getSub_service_P()+"','"+d.getDate_P()+"','"+d.getTime1_P()+"')";    
	    return template.update(sql);    
	}    
	public int update(Plumbing d){    
	    String sql="update Plumbing_table set name='"+d.getSub_service_P()+"', salary="+d.getDate_P()+",designation='"+d.getTime1_P()+"' where id="+d.getCategory_P()+"";    
	    return template.update(sql);    
	}    
	/*public int delete(int id){    
	    String sql="delete from Electrical_table where category="+Ecategory+"";    
	    return template.update(sql);    
	}  */  
/*	public Electrical getCustomerByCategory_E(String category_E){    
	    String sql="select * from Electrical_table where category_E=?";    
	    return template.queryForObject(sql, new Object[]{category_E},new BeanPropertyRowMapper<Electrical>(Electrical.class));    
	} 
*/   
	public List<Plumbing> getCustomer(){    
	    return template.query("select * from Plumbing_table",new RowMapper<Plumbing>(){    
	        public Plumbing mapRow(ResultSet rs, int row) throws SQLException {    
	        	Plumbing p=new Plumbing();    
	            p.setCategory_P(rs.getString(1));    
	            p.setSub_service_P(rs.getString(2));    
	            p.setDate_P(rs.getDate(3));    
	            p.setTime1_P(rs.getString(4));    
	            return p;    
	        }    
	    });    
	} 
}
