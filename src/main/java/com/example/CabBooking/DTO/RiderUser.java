package com.example.CabBooking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RiderUser extends User {

    private Location destinationLocation;
    private Location pickupLocation;
    private CabType cabType;
    public RiderUser(Integer id,String name,String emailId,String mobileNo,
                     String password,Location destinationLocation,Location pickupLocation,CabType cabType){
        super(id, name, emailId, mobileNo, password);
        this.destinationLocation=destinationLocation;
        this.pickupLocation=pickupLocation;
        this.cabType=cabType;
    }
}
