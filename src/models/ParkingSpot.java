package models;

public class ParkingSpot implements Comparable<ParkingSpot> {
    private String spotId;
    private int floorNumber;
    private SpotType spotType;
    private boolean isAvailable;

    public ParkingSpot(String spotId, int floorNumber, SpotType spotType) {
        this.spotId = spotId;
        this.floorNumber = floorNumber;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public String getSpotId() { return spotId; }
    public SpotType getSpotType() { return spotType; }
    public int getFloorNumber() { return floorNumber; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public int compareTo(ParkingSpot other) {
        return Integer.compare(this.floorNumber, other.floorNumber);
    }
}