package com.example.CabBooking.Service;

import com.example.CabBooking.DTO.Cab;
import com.example.CabBooking.DTO.DriverUser;
import com.example.CabBooking.DTO.RiderUser;
import com.example.CabBooking.Repo.UserRepo;

import java.util.Map;

public class Registration {


    public  void registerRiderUser(RiderUser riderUser){
        Map<Integer,RiderUser> riderUserMap = UserRepo.getInstance().getRiderUserMap();
        riderUserMap.put(riderUser.getId(),riderUser);
    }
    public void registerDriverUser(DriverUser driverUser){
       Map<Integer,DriverUser> driverUserMap = UserRepo.getInstance().getDriverUserMap();
       driverUserMap.put(driverUser.getId(),driverUser);
    }
    public void registerCab(Cab cab){
        UserRepo.getInstance().getCabMap().put(cab.getId(),cab);
    }
}
