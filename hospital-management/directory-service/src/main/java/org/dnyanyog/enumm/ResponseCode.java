package org.dnyanyog.enumm;

public enum ResponseCode {
  Add_User_Success("Success", "Add User Successfully"),
  Add_User_Fail("Fail", "Add User Unsuccessfully"),

  Update_User_Success("Success", "Update User Successfully"),
  Update_User_Fail("Fail", "Update User Unsuccessfully"),

  Check_User_Success("Success", "Check User Successfully"),
  Check_User_Fail("Fail", "Check User Unsuccessfully"),

  Delete_User_Success("Success", "Delete User Successfully"),
  Delete_User_Fail("Fail", "Delete User Unsuccessfully"),
	
	Login_Success("Success", "Login Successfully"),
	Login_Fail("Fail", "Login unSuccessfully");

  private String message;
  private String status;


  private ResponseCode(String message, String status) {
    this.message = message;
    this.status = status;
  
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

 
}
