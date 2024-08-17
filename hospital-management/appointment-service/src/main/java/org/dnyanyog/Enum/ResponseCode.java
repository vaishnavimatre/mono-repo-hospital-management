package org.dnyanyog.Enum;

public enum ResponseCode {
  Add_Appointment_Success("Success", "Add Appointment Successful"),
  Add_Appointment_Fail("Fail", "Add Appointment unSuccessful"),
  Update_Appointment_Success("Success", "update Appointment Successful"),
  Update_Appointment_Fail("Fail", "update Appointment unSuccessful"),
  Search_Appointment_Success("Success", "Search Appointment Successful"),
  Search_Appointment_Fail("Fail", "search Appointment unSuccessful"),
  Delete_Appointment_Success("Success", "Delete Appointment Successful"),
  Delete_Appointment_Fail("Fail", "Delete Appointment unSuccessful");

  private final String message;
  private final String status;


  private ResponseCode(String message, String status) {
    this.message = message;
    this.status = status;
 
  }

  public String getMessage() {
    return message;
  }

  public String getStatus() {
    return status;
  }


}
