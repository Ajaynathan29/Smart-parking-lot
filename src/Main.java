import models.ParkingSpot;
import models.SpotType;
import models.VehicleType;
import services.ParkingLotService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Smart Parking Lot...\n");
        ParkingLotService parkingLot = new ParkingLotService();

        // 1. Add physical parking spots to the building
        System.out.println("Building Floor 1 (Compact & Regular spots)...");
        parkingLot.addParkingSpot(new ParkingSpot("1A", 1, SpotType.COMPACT));
        parkingLot.addParkingSpot(new ParkingSpot("1B", 1, SpotType.REGULAR));
        
        System.out.println("Building Floor 2 (Large spots)...");
        parkingLot.addParkingSpot(new ParkingSpot("2A", 2, SpotType.LARGE));

        System.out.println("\n===========================");
        System.out.println("   SIMULATION STARTING     ");
        System.out.println("===========================");

        // 2. Simulate vehicles arriving
        System.out.println("\n[GATE] Motorcycle arriving...");
        ParkingSpot spot1 = parkingLot.allocateSpot(VehicleType.MOTORCYCLE);
        System.out.println("-> Parked successfully in spot: " + spot1.getSpotId()); 

        System.out.println("\n[GATE] Car arriving...");
        ParkingSpot spot2 = parkingLot.allocateSpot(VehicleType.CAR);
        System.out.println("-> Parked successfully in spot: " + spot2.getSpotId()); 

        System.out.println("\n[GATE] Bus arriving...");
        ParkingSpot spot3 = parkingLot.allocateSpot(VehicleType.BUS);
        System.out.println("-> Parked successfully in spot: " + spot3.getSpotId()); 

       // 3. Simulate a vehicle leaving
        if (spot2 != null) {
            System.out.println("\n[EXIT] Car is leaving spot: " + spot2.getSpotId());
            parkingLot.freeSpot(spot2);
            
            // Calculate the fee (Let's pretend they stayed for 4 hours)
            int hoursStayed = 4;
            double fee = parkingLot.calculateFee(VehicleType.CAR, hoursStayed);
            
            System.out.println("--------------------------------");
            System.out.println("        TICKET RECEIPT          ");
            System.out.println(" Vehicle: " + VehicleType.CAR);
            System.out.println(" Time Parked: " + hoursStayed + " hours");
            System.out.println(" Total Due: $" + String.format("%.2f", fee));
            System.out.println("--------------------------------");

        // 4. Another Car arrives and takes the newly freed spot
        System.out.println("\n[GATE] Another Car arriving...");
        ParkingSpot spot4 = parkingLot.allocateSpot(VehicleType.CAR);
    }
}
}