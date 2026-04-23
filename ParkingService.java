import java.util.*;

public class ParkingService {

    private int totalSlots;
    private Map<Integer, Vehicle> slots;
    private List<String> history;

    public ParkingService(int totalSlots) {
        this.totalSlots = totalSlots;
        this.slots = new HashMap<>();
        this.history = new ArrayList<>();
    }

    // park vehicle
    public void parkVehicle(String number, String type) {
        if (slots.size() >= totalSlots) {
            System.out.println("Parking Full!");
            return;
        }

        for (int i = 1; i <= totalSlots; i++) {
            if (!slots.containsKey(i)) {
                Vehicle v = new Vehicle(number, type);
                slots.put(i, v);

                history.add("Parked -> " + number + " at slot " + i);

                System.out.println("Vehicle parked at slot " + i);
                return;
            }
        }
    }

    // remove vehicle
    public void removeVehicle(int slot) {
        if (!slots.containsKey(slot)) {
            System.out.println("Invalid slot!");
            return;
        }

        Vehicle v = slots.get(slot);

        long exitTime = System.currentTimeMillis();
        long minutes = (exitTime - v.getEntryTime()) / (1000 * 60);

        double fee = FeeCalculator.calculateFee(minutes, v.getType());

        slots.remove(slot);

        history.add("Exited -> " + v.getVehicleNumber() + " Fee: ₹" + fee);

        System.out.println("Vehicle Number: " + v.getVehicleNumber());
        System.out.println("Parking Time: " + minutes + " minutes");
        System.out.println("Total Fee: ₹" + fee);
    }

    // show status
    public void showStatus() {
        System.out.println("\n--- Parking Status ---");

        for (int i = 1; i <= totalSlots; i++) {
            if (slots.containsKey(i)) {
                System.out.println("Slot " + i + " : OCCUPIED");
            } else {
                System.out.println("Slot " + i + " : AVAILABLE");
            }
        }
    }

    // show history
    public void showHistory() {
        System.out.println("\n--- Parking History ---");

        if (history.isEmpty()) {
            System.out.println("No records yet.");
            return;
        }

        for (String record : history) {
            System.out.println(record);
        }
    }
}