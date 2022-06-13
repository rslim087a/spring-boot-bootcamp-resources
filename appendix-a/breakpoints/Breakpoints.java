public class Breakpoints {

    public static void main(String[] args) {
        String receipt = getReceipt(2.50, 2.50);
    }

    public static String getReceipt(double price1, double price2) {
        String message = "The total is: $";
        double total = sum(price1, price2);
        return message += "" + total;
    }

    public static double sum(double price1, double price2) {
        return price1 + price2;
    }

}