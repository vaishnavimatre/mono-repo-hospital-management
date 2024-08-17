package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class DirectoryServiceData {
  private long userid;
  

@NotNull(message = "Username is mandatory")
  @NotBlank(message = "username  should not be blank")
  @Size(max = 50, message = "username  length should be at most 20 characters")
  private String username;
  private String email;
  

  @NotNull(message = "Mobile_Number is mandatory")
  private String mobno;
  
  @NotNull(message = "Role is mandatory")
  @NotBlank(message = "Role should not be blank")
  private String role;
  

  @NotNull(message = "password is mandatory")
  @NotBlank(message = "password should not be blank")
  @Size(max = 50, message = "password length should be at most 50 characters")
  private String password;

  @NotNull(message = "confirm is mandatory")
  @NotBlank(message = "confirm should not be blank")
  @Size(max = 50, message = "confirm length should be at most 50 characters")
  private String confirm;
  

  public String getMobno() {
return mobno;}

public void setMobno(String mobno) {
this.mobno = mobno;}

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
 
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirm() {
    return confirm;
  }

  public void setConfirm(String confirm) {
    this.confirm = confirm;
  }
}
