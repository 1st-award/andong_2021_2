import java.util.ArrayList;

public class TreeMapApp {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();

        tm.add(30, "apple");
        tm.add(10, "banana");
        tm.add(40, "caramel");
        tm.add(20, "doughnut");
        tm.add(5, "egg");
        // fish로 오버라이딩 된다.
        tm.add(5, "fish");
        // visitAll()의 return 값이 ArrayList Class이므로 ArrayList Class 변수에 저장한다.
        ArrayList stack = tm.visitAll();
        // ArrayList에 있는 원소를 출력
        for(Object value: stack) {
            System.out.println(value);
        }
    }
}
