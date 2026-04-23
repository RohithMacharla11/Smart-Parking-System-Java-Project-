public class Vehicle {
    private String vehicleNumber;
    private String type;
    private long entryTime;

    public Vehicle(String vehicleNumber, String type) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.entryTime = System.currentTimeMillis(); // store entry time
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public long getEntryTime() {
        return entryTime;
    }
}