public class TreeMapApp {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();

        tm.add(30, "apple");
        tm.add(10, "banana");
        tm.add(40, "caramel");
        tm.add(20, "doughnut");

        System.out.println(tm.topNode.findAll());
    }
}
