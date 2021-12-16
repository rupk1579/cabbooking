package com.example.CabBooking.DTO;

import lombok.Data;

@Data
public class Location {
    private Integer xPosition;
    private Integer yPosition;
    public Location(Integer xPosition,Integer yPosition){
        this.xPosition=xPosition;
        this.yPosition=yPosition;
    }
}
