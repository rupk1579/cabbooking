package com.example.CabBooking.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class RiderHistory {
    private RiderUser  riderUser;
    private Date ridingDate;
    private String driverName;
    private Location pickUpLocation;
    private Location destination;
    private Double fare;


}
