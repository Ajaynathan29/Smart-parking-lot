package services;

import java.util.PriorityQueue;
import models.ParkingSpot;
import models.VehicleType;

public class ParkingLotService {
    
    private PriorityQueue<ParkingSpot> availableCompactSpots;
    private PriorityQueue<ParkingSpot> availableRegularSpots;
    private PriorityQueue<ParkingSpot> availableLargeSpots;

    public ParkingLotService() {
        availableCompactSpots = new PriorityQueue<>();
        availableRegularSpots = new PriorityQueue<>();
        availableLargeSpots = new PriorityQueue<>();
    }

    public void addParkingSpot(ParkingSpot spot) {
        switch (spot.getSpotType()) {
            case COMPACT -> availableCompactSpots.offer(spot);
            case REGULAR -> availableRegularSpots.offer(spot);
            case LARGE -> availableLargeSpots.offer(spot);
        }
    }

    public ParkingSpot allocateSpot(VehicleType vehicleType) {
        ParkingSpot allocatedSpot = null;
        switch (vehicleType) {
            case MOTORCYCLE:
                allocatedSpot = availableCompactSpots.poll();
                if (allocatedSpot == null) allocatedSpot = availableRegularSpots.poll();
                if (allocatedSpot == null) allocatedSpot = availableLargeSpots.poll();
                break;
            case CAR:
                allocatedSpot = availableRegularSpots.poll();
                if (allocatedSpot == null) allocatedSpot = availableLargeSpots.poll();
                break;
            case BUS:
                allocatedSpot = availableLargeSpots.poll();
                break;
        }

        if (allocatedSpot != null) {
            allocatedSpot.setAvailable(false);
            return allocatedSpot;
        }
        return null; 
    }

    public void freeSpot(ParkingSpot spot) {
        spot.setAvailable(true);
        addParkingSpot(spot);
    }
// ==========================================
    // FEE CALCULATION LOGIC
    // ==========================================
    public double calculateFee(VehicleType vehicleType, int hoursParked) {
        double hourlyRate = 0.0;
        
        // Strategy for pricing based on vehicle size
        switch (vehicleType) {
            case MOTORCYCLE: 
                hourlyRate = 2.00; // $2 per hour
                break;
            case CAR: 
                hourlyRate = 5.00; // $5 per hour
                break;
            case BUS: 
                hourlyRate = 10.00; // $10 per hour
                break;
        }
        
        return hourlyRate * hoursParked;
    }}