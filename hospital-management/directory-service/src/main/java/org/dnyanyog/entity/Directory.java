package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Directory {

  @Id
  @GeneratedValue
  @Column(name = "userId", nullable = false, insertable = true, updatable = false)
  private long userid;

  @Column(nullable = false, insertable = true, updatable = false, length = 50)
  private String username;

  @Column private String email;
  @Column private String mobno;

  @Column private String role;
  @Column private String password;
  @Column private String confirm;
  
  @Column private String encryptionKey;

  public String getEncryptionKey() {
    return encryptionKey;
  }

  public Directory setEncryptionKey(String encryptionKey) {
    this.encryptionKey = encryptionKey;
    return this;
  }

  public String getMobno() {
    return mobno;
  }

  public Directory setMobno(String mobno) {
    this.mobno = mobno;
    return this; 
  }

  public static Directory getInstance() {
    return new Directory();
  }

  public long getUserid() {
    return userid;
  }

  public Directory setUserid(long userid) {
    this.userid = userid;
    return this; 
  }

  public String getUsername() {
    return username;
  }

  public Directory setUsername(String username) {
    this.username = username;
    return this; 
  }

  public String getEmail() {
    return email;
  }

  public Directory setEmail(String email) {
    this.email = email;
    return this; 
  }

  public String getRole() {
    return role;
  }

  public Directory setRole(String role) {
    this.role = role;
    return this; 
  }

  public String getPassword() {
    return password;
  }

  public Directory setPassword(String password) {
    this.password = password;
    return this; 
  }

  public String getConfirm() {
    return confirm;
  }

  public Directory setConfirm(String confirm) {
    this.confirm = confirm;
    return this; 
  }
}
