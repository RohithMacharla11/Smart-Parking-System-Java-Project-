import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total parking slots: ");
        int slots = sc.nextInt();

        ParkingService service = new ParkingService(slots);

        while (true) {
            System.out.println("\n==== SMART PARKING SYSTEM ====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Show Status");
            System.out.println("4. View History");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter vehicle number: ");
                    String num = sc.nextLine();

                    System.out.print("Enter type (2W/4W): ");
                    String type = sc.nextLine();

                    service.parkVehicle(num, type);
                    break;

                case 2:
                    System.out.print("Enter slot number: ");
                    int slot = sc.nextInt();

                    service.removeVehicle(slot);
                    break;

                case 3:
                    service.showStatus();
                    break;

                case 4:
                    service.showHistory();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}