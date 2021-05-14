package com.inkesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.inkesh.PestControl;
import com.inkesh.Plumbing;

public class PestControlDao 
{
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}  
	
	public int save(PestControl e){    
	    String sql="insert into PestControl_table(category_PC,sub_service_PC,date_PC,time1_PC) values('"+e.getCategory_PC()+"','"+e.getSub_service_PC()+"','"+e.getDate_PC()+"','"+e.getTime1_PC()+"')";    
	    return template.update(sql);    
	}    
	public int update(PestControl e){    
	    String sql="update PestControl_table set name='"+e.getSub_service_PC()+"', salary="+e.getDate_PC()+",designation='"+e.getTime1_PC()+"' where id="+e.getCategory_PC()+"";    
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
	public List<PestControl> getCustomer(){    
	    return template.query("select * from PestControl_table",new RowMapper<PestControl>(){    
	        public PestControl mapRow(ResultSet rs, int row) throws SQLException {    
	        	PestControl pc=new PestControl();    
	            pc.setCategory_PC(rs.getString(1));    
	            pc.setSub_service_PC(rs.getString(2));    
	            pc.setDate_PC(rs.getDate(3));    
	            pc.setTime1_PC(rs.getString(4));    
	            return pc;    
	        }    
	    });    
	} 
}
