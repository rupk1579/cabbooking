package com.example.CabBooking;

import com.example.CabBooking.DTO.*;
import com.example.CabBooking.Service.Registration;
import com.example.CabBooking.Service.SearchCabService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookingApplication {

	public static void main(String[] args) {

		SpringApplication.run(CabBookingApplication.class, args);
		Registration registration = new Registration();
		SearchCabService searchCabService = new SearchCabService();
	    RiderUser riderUser = new RiderUser(1,"Rider1","Rider1@gamil.com","89898989897","jklsdfg",
				new Location(5,6),new Location(10,12),CabType.MINI);
		DriverUser driverUser = new DriverUser(1,"Driver1","driver1@gmail.com","7879898767","WT.max@123",Boolean.TRUE);
		Cab cab = new Cab(1,"HRG1209",CabType.MINI,1,new Location(5,8),Boolean.FALSE,"Driver1");
	    registration.registerRiderUser(riderUser);
	    registration.registerCab(cab);
	    registration.registerDriverUser(driverUser);

	    BookingDetails bookingDetails = searchCabService.searchCab(riderUser);
	    if(bookingDetails.getCabNumber() == null){
			System.out.println(bookingDetails.getMessage());
		}else{
	    	if(searchCabService.verifyOTP(bookingDetails.getOTP(),"8987")){
				System.out.println();
			}
		}



	}



}
