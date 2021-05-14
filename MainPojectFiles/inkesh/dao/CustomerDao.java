package com.inkesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.inkesh.Customer;

public class CustomerDao
{
		JdbcTemplate template;    
		    
		public void setTemplate(JdbcTemplate template) {    
		    this.template = template;    
		}  
		
		public int save(Customer c){    
		    String sql="insert into Cust(id,Fname,Lname,emailC,password,mobile_no,address) values(sequence_id.nextval,'"+c.getFname()+"','"+c.getLname()+"','"+c.getEmailC()+"','"+c.getPassword()+"','"+c.getMobile_no()+"','"+c.getAddress()+"')";    
		    return template.update(sql);    
		}    
		public int update(Customer c){    
		    String sql="update Cust set name='"+c.getFname()+"','"+c.getLname()+"', salary='"+c.getEmailC()+"',designation='"+c.getMobile_no()+"' where id="+c.getId()+"";    
		    return template.update(sql);    
		}    
		public int delete(int id){    
		    String sql="delete from Cust where id="+id+"";    
		    return template.update(sql);    
		}    
		public Customer getCustomerById(int id){    
		    String sql="select * from Cust where id=?";    
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));    
		}    
		public List<Customer> getCustomer(){    
		    return template.query("select * from Cust",new RowMapper<Customer>(){    
		        public Customer mapRow(ResultSet rs, int row) throws SQLException {    
		        	Customer e=new Customer();    
		            e.setId(rs.getInt(1));    
		            e.setFname(rs.getString(2));
		            e.setLname(rs.getString(3)); 
		            e.setEmailC(rs.getString(4));    
		            e.setMobile_no(rs.getLong(5));
		            e.setAddress(rs.getString(6));
		            return e;    
		        }    
		    });    
		} 
		}   

