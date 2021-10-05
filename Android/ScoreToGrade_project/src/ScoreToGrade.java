public class ScoreToGrade {
    public static void main(String[] args) {
        int input = 85;
        int jumsu = (input/10)*10;

        switch(jumsu) { // 1
            case 100:
            case 90:
                System.out.println("A 학점"); break;
            case 80:
                System.out.println("B 학점"); break;
            case 70:
                System.out.println("C 학점"); break;
            case 60:
                System.out.println("D 학점"); break;
            default: // 2
                System.out.println("F 학점"); break;
        }
    }
}
