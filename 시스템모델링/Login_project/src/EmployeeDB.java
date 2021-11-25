import java.util.Vector;

public class EmployeeDB {
    static Vector<Employee> employeeList = new Vector<Employee>();

    public static void addEmployeeToList(Employee employee) {
        employeeList.add(employee);
    }

    public static Employee getEmployee(String empid) {
        // search employee empid
        for(Employee employee : employeeList) {
            // compare empid
            if(employee.getEmpid().equals(empid))
                return employee;
        }
        // not found employee return null
        return null;
    }
}
