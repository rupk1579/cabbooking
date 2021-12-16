package com.example.CabBooking.DTO;

import lombok.Data;

@Data
public class BookingDetails {
    private String cabNumber;
    private String diverName;
    private String OTP;
    private Integer fare;
    private String message;

}
