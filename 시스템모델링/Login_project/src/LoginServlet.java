public class LoginServlet {
    private Employee e;

    public boolean login(String empid, String password) {
        e = EmployeeDB.getEmployee(empid);
        if(e.validate(password))
            return true;
        else
            return false;
    }

    public String findUserPassword(String empid, String hint) {
        e = EmployeeDB.getEmployee(empid);
        String userPW = e.compareHintGetPass(hint);
        if(userPW!=null)
            return userPW;
        else
            return "아이디나 힌트가 잘못되었습니다.";
    }

    public void createUser(String empid, String password, String hint) {
        Employee newEmployee = new Employee(empid, password, hint);
        EmployeeDB.addEmployeeToList(newEmployee);
    }
}
