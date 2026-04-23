public class FeeCalculator {

    public static double calculateFee(long minutes, String type) {
        double rate;

        // basic pricing logic
        if (type.equalsIgnoreCase("2W")) {
            rate = 1.5;
        } else if (type.equalsIgnoreCase("4W")) {
            rate = 3.0;
        } else {
            rate = 2.0; // fallback
        }

        // minimum charge rule
        if (minutes < 30) {
            return rate * 30;
        }

        return minutes * rate;
    }
}