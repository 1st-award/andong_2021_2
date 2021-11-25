import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String empid, password, hint;
        int selectNumber;
        LoginServlet loginServlet = new LoginServlet();
        Scanner sc = new Scanner(System.in);


        do {
            System.out.print("1. 회원가입\n2. 로그인\n3. 비밀번호 찾기\n4. 종료\n\n번호 입력: ");
            selectNumber = sc.nextInt();

            switch (selectNumber) {
                case 1:
                    System.out.println("\n\n==== 회원가입 하기 ====");
                    System.out.print("아이디: ");
                    empid = sc.next();
                    System.out.print("비밀번호: ");
                    password = sc.next();
                    System.out.print("비밀번호 찾기 힌트: ");
                    hint = sc.next();
                    loginServlet.createUser(empid, password, hint);
                    System.out.println("=====================\n\n");
                    break;
                case 2:
                    System.out.println("\n\n==== 로그인 ====");
                    System.out.print("아이디: ");
                    empid = sc.next();
                    System.out.print("비밀번호: ");
                    password = sc.next();
                    if (loginServlet.login(empid, password)) {
                        System.out.println("Login Success. Welcome!");
                        selectNumber = 4; // login program exit
                    }
                    else
                        System.out.println("Login Failed");
                    System.out.println("===============\n\n");
                    break;
                case 3:
                    System.out.println("\n\n==== 비밀번호 찾기 ====");
                    System.out.print("아이디: ");
                    empid = sc.next();
                    System.out.print("힌트: ");
                    hint = sc.next();
                    String isYourPW = loginServlet.findUserPassword(empid, hint);
                    System.out.println(isYourPW);
                    System.out.println("=====================\n\n");
                    break;
                default:
                    System.out.println("번호를 잘못 입력했습니다. 다시 입력해주세요.");
                    System.out.println("=====================\n\n");
            }
        } while (selectNumber != 4);
    }
}
