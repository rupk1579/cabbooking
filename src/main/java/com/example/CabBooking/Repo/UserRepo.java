package com.example.CabBooking.Repo;

import com.example.CabBooking.DTO.Cab;
import com.example.CabBooking.DTO.DriverUser;
import com.example.CabBooking.DTO.RiderHistory;
import com.example.CabBooking.DTO.RiderUser;

import java.util.List;
import java.util.Map;

public class UserRepo {

    private static UserRepo instance = new UserRepo();
    public static UserRepo getInstance(){
        return instance;
    }

    public Map<Integer, RiderUser> getRiderUserMap() {
        return riderUserMap;
    }

    public void setRiderUserMap(Map<Integer, RiderUser> riderUserMap) {
        this.riderUserMap = riderUserMap;
    }

    public Map<Integer, Cab> getCabMap() {
        return cabMap;
    }

    public void setCabMap(Map<Integer,Cab> cabMap) {
        this.cabMap = cabMap;
    }

    public Map<Integer, DriverUser> getDriverUserMap() {
        return driverUserMap;
    }

    public void setDriverUserMap(Map<Integer, DriverUser> driverUserMap) {
        this.driverUserMap = driverUserMap;
    }

    private  Map<Integer , RiderUser> riderUserMap;
    private Map<Integer,Cab> cabMap;
    private  Map<Integer, DriverUser> driverUserMap;
    private Map<Integer, RiderHistory> riderHistory;

    public Map<Integer, RiderHistory> getRiderHistory() {
        return riderHistory;
    }

    public void setRiderHistory(Map<Integer, RiderHistory> riderHistory) {
        this.riderHistory = riderHistory;
    }

    private UserRepo(){

    }
}
