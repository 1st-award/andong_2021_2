public class OutPutCount {
    public static void main(String[] args) {
        int data = 200;
        data ++;
        System.out.println("1: " + data); // 1. First Print
        func1(data);
    }
    static void func1(int data) {
        data ++;
        System.out.println("2: " + data); // 2. Second Print
    }
}
