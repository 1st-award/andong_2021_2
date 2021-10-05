public class ExtendsCar {
    public static void main(String[] args) {
        Truck tk = new Truck(1500);

        System.out.println("Truck cc: " + tk.getCC());
        System.out.println("Truck YEAR: " + tk.YEAR);
        // Truck maximum 150
        tk.upSpeed(155);
        System.out.println("Truck Speed: " + tk.getSpeed());
    }
}