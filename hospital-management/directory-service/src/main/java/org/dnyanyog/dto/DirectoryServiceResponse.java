package org.dnyanyog.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class DirectoryServiceResponse {

  private String status;
  private String message;

  private String mobno;
  private String role;
  private String password;
  private String confirm;
  private LocalDateTime timestamp;
  private String username;

  public String getMobno() {
    return mobno;
  }

  public DirectoryServiceResponse setMobno(String mobno) {
    this.mobno = mobno;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public DirectoryServiceResponse setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public DirectoryServiceResponse setUsername(String username) {
    this.username = username;
    return this;
  }

  private long userid;

  public long getUserid() {
    return userid;
  }

  public DirectoryServiceResponse setUserid(long userid) {
    this.userid = userid;
    return this;
  }

  private String email;

  public static DirectoryServiceResponse getInstance() {
    return new DirectoryServiceResponse();
  }

  public String getStatus() {
    return status;
    
  }

  public DirectoryServiceResponse setStatus(String status) {
    this.status = status;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getEmail() {
    return email;
  }

  public DirectoryServiceResponse setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getRole() {
    return role;
  }

  public DirectoryServiceResponse setRole(String role) {
    this.role = role;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public DirectoryServiceResponse setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getConfirm() {
    return confirm;
  }

  public DirectoryServiceResponse setConfirm(String confirm) {
    this.confirm = confirm;
    return this;
  }
}
