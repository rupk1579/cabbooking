package com.example.CabBooking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Cab {
    private Integer id;
    private String cabNumber;
    private CabType cabType;
    private Integer driverId;
    private Location location;
    private Boolean isAssigned;
    private String driverName;

    public Cab(Integer id, String cabNumber, CabType cabType, Integer driverId, Location location, Boolean isAssigned, String driverName) {
        this.id = id;
        this.cabNumber = cabNumber;
        this.cabType = cabType;
        this.driverId = driverId;
        this.location = location;
        this.isAssigned = isAssigned;
        this.driverName = driverName;
    }

    public Cab(String cabNumber, CabType cabType){
       this.cabNumber=cabNumber;
       this.cabType=cabType;
    }


}
