package com.example.CabBooking.Service;

import com.example.CabBooking.DTO.*;
import com.example.CabBooking.Repo.UserRepo;

import javax.xml.crypto.Data;
import java.util.*;


public class SearchCabService {
    private static final Integer fareCharge = 12;

    public BookingDetails searchCab(RiderUser riderUser){
        BookingDetails bookingDetails = new BookingDetails();

        Map<Integer,Cab> cabs = UserRepo.getInstance().getCabMap();
        for(Map.Entry<Integer,Cab> cabMap : cabs.entrySet()){
            Cab cab = cabMap.getValue();
            Integer cabId = cabMap.getKey();
            if(cab.getIsAssigned().equals(Boolean.FALSE) &&
                    cab.getLocation().getXPosition() <= riderUser.getPickupLocation().getXPosition()+5
                    && cab.getCabType().equals(riderUser.getCabType())){
                DriverUser driverUser = UserRepo.getInstance().getDriverUserMap().get(cab.getDriverId());
                if(Boolean.TRUE.equals(driverUser.getIsAvailable())){
                    assignRide(cab);
                    bookingDetails.setDiverName(driverUser.getName());
                    bookingDetails.setCabNumber(cab.getCabNumber());
                    bookingDetails.setOTP(UUID.randomUUID().toString());
                    return  bookingDetails;
                }
            }
        }
        bookingDetails.setMessage("Sorry,No ride available this time...Please try again");
        return bookingDetails;

    }
    private void assignRide(Cab cab){
        //cab.setIsAssigned(Boolean.TRUE);
        UserRepo.getInstance().getCabMap().get(cab.getId()).setIsAssigned(Boolean.TRUE);
    }
    public Boolean verifyOTP(String OTP,String OTPGiven){
      return OTP.equals(OTPGiven) ? Boolean.TRUE :Boolean.FALSE;
    }
    private void makePayment(RiderUser riderUser, Location currentLocation,Cab cab){
        Double fare =calculateDistance(riderUser.getPickupLocation(),currentLocation);
        updateLocation(riderUser,currentLocation,fare,cab);
        System.out.println("Payment has been done....");
        System.out.println("Ride completed");

    }
    private Double calculateDistance(Location startLocation,Location endLocation){

        Double distance= Math.sqrt(Math.pow((startLocation.getXPosition()-endLocation.getXPosition()),2)
        +Math.pow((startLocation.getYPosition()-endLocation.getYPosition()),2));
        return distance*fareCharge;

    }
    private void updateLocation(RiderUser riderUser ,Location destination,Double fare,Cab cab){
        RiderHistory riderHistory = new RiderHistory();
        riderHistory.setRiderUser(riderUser);
        riderHistory.setDestination(destination);
        riderHistory.setFare(fare);
        riderHistory.setDriverName(cab.getDriverName());
        riderHistory.setRidingDate(new Date());
        //calculateMaxId...
        Map<Integer,RiderHistory> riderHistoryMap = UserRepo.getInstance().getRiderHistory();
        int maxId=1;
        for(Map.Entry<Integer,RiderHistory> riderHistoryEntry : riderHistoryMap.entrySet()){
            if(maxId>riderHistoryEntry.getKey()){
                maxId=riderHistoryEntry.getKey();
            }
        }
        UserRepo.getInstance().getRiderHistory().put(maxId+1,riderHistory);
        UserRepo.getInstance().getCabMap().get(cab.getId()).setIsAssigned(Boolean.FALSE);
        UserRepo.getInstance().getCabMap().get(cab.getId()).setLocation(destination);
    }
    public List<RiderHistory> fetchRiderHistory(){
        List<RiderHistory> riderHistories = new ArrayList<>();
        for(Map.Entry<Integer,RiderHistory> riderHistoryEntry : UserRepo.getInstance().getRiderHistory().entrySet()){
            riderHistories.add(riderHistoryEntry.getValue());
        }
        return riderHistories;
    }



}
