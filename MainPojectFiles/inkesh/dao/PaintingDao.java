package com.inkesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.inkesh.Painting;
import com.inkesh.PestControl;

public class PaintingDao 
{
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}  
	
	public int save(Painting f){    
	    String sql="insert into Painting_table(category_PT,sub_service_PT,date_PT,time1_PT) values('"+f.getCategory_PT()+"','"+f.getSub_service_PT()+"','"+f.getDate_PT()+"','"+f.getTime1_PT()+"')";    
	    return template.update(sql);    
	}    
	public int update(Painting f){    
	    String sql="update Painting_table set name='"+f.getSub_service_PT()+"', salary="+f.getDate_PT()+",designation='"+f.getTime1_PT()+"' where id="+f.getCategory_PT()+"";    
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
	public List<Painting> getCustomer(){    
	    return template.query("select * from Painting_table",new RowMapper<Painting>(){    
	        public Painting mapRow(ResultSet rs, int row) throws SQLException {    
	        	Painting pt=new Painting();    
	            pt.setCategory_PT(rs.getString(1));    
	            pt.setSub_service_PT(rs.getString(2));    
	            pt.setDate_PT(rs.getDate(3));    
	            pt.setTime1_PT(rs.getString(4));    
	            return pt;    
	        }    
	    });    
	} 
}
