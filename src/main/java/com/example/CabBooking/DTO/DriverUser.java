package com.example.CabBooking.DTO;

import lombok.Data;

@Data
public class DriverUser extends User {
    private Boolean isAvailable;

    public DriverUser(Integer id,String name,String emailId,String mobileNo,String password,Boolean isAvailable){
       super(id,name,emailId,mobileNo,password);
       this.isAvailable=isAvailable;
    }
}
