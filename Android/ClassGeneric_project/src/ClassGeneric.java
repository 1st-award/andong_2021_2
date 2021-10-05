import java.util.ArrayList;

public class ClassGeneric {
    public static void main(String[] args) {
        myClass c1 = new myClass(10);
        myClass c2 = new myClass(20);
        myClass c3 = new myClass(30);
        // create generic list
        ArrayList<myClass> myList= new ArrayList<>();// 1
        myList.add(c1);
        myList.add(c2);
        myList.add(c3);
        int hap = 0;
        for(int i=0; i< myList.size(); ++i) {
            hap += myList.get(i).value;// 2
        }
        System.out.println(hap);
    }

    static class myClass {
        int value;
        myClass (int value) {
            this.value = value;
        }
    }
}
