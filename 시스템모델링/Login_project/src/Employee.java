public class Employee {
    private String empid;
    private String password;
    private String hint;

    public Employee(String empid, String password, String hint) {
        this.empid = empid;
        this.password = password;
        this.hint = hint;
    }

    public boolean validate(String password) {
        if(this.password.equals(password))
            return true;
        else
            return false;
    }

    public String compareHintGetPass(String hint) {
        if(this.hint.equals(hint))
            return password;
        else
            return null;
    }

    public String getEmpid() {
        return empid;
    }
}
