public class PriceCalculator {

    public static final double FLAG_KM = 2.0;
    public static final double PER_PRICE = 0.8;
    public static final double FLAG_PRICE = 6.0;
    public static final double PER_WAIT_PRICE = 0.25;
    public static final int BASE_KM = 8;
    private double HALF_PER_PRICE = 0.4;

    public int calculate(double distance, int minutes) {
        double price = 0;

        if (distance <= FLAG_KM ) {
            price = calculateBasePrice(minutes);
        }
        if(distance > FLAG_KM && distance <= BASE_KM ){
            price = calculateBasePrice(minutes) + (distance - FLAG_KM) * PER_PRICE ;
        }
        if(distance > BASE_KM){
            price = calculateBasePrice(minutes)+ (distance - FLAG_KM) * PER_PRICE + (distance - BASE_KM) * HALF_PER_PRICE;
        }
        return round(price);
    }

    private double calculateBasePrice(int minutes) {
        double price;
        price = FLAG_PRICE + waitingPrice(minutes);
        return price;
    }

    private double waitingPrice(int minutes) {
        return minutes * PER_WAIT_PRICE;
    }

    public int round(double price) {
        return (int) Math.round(price);
    }
}
