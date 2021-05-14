package com.inkesh;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Size;

public class Login {
  @NotEmpty
  @Size(min=2,max=20)
  private String emailC;
  
  @NotNull
  private String password;
  public String getEmailC() {
  return emailC;
  }
  public void setEmailC(String emailC) {
  this.emailC = emailC;
  }
  public String getPassword() {
  return password;
  }
  public void setPassword(String password) {
  this.password = password;
  }
 
}