package com.inkesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.inkesh.Electrical;

public class ElectricalDao
{
		JdbcTemplate template;    
		    
		public void setTemplate(JdbcTemplate template) {    
		    this.template = template;    
		}  
		
		public int save(Electrical c){    
		    String sql="insert into Electrical_table(category_E,sub_service_E,date_E,time1_E) values('"+c.getCategory_E()+"','"+c.getSub_service_E()+"','"+c.getDate_E()+"','"+c.getTime1_E()+"')";    
		    System.out.println(sql);
		    return template.update(sql);   
		   
		}    
		public int update(Electrical c){    
		    String sql="update Electrical_table set name='"+c.getSub_service_E()+"', salary="+c.getDate_E()+",designation='"+c.getTime1_E()+"' where id="+c.getCategory_E()+"";    
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
		public List<Electrical> getCustomer(){    
		    return template.query("select * from Electrical_table",new RowMapper<Electrical>(){    
		        public Electrical mapRow(ResultSet rs, int row) throws SQLException {    
		        	Electrical e=new Electrical();    
		            e.setCategory_E(rs.getString(1));    
		            e.setSub_service_E(rs.getString(2));    
		            e.setDate_E(rs.getDate(3));    
		            e.setTime1_E(rs.getString(4));    
		            return e;    
		        }    
		    });    
		} 
		}   

