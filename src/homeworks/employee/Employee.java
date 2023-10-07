package homeworks.employee;

public class Employee {
    private String name;
    private String surname;
    private String employeeID;
    private String company;
    private String position;
    private String salary;

    Employee(String employeeID, String name, String surname, String company, String position, String salary) {
        this.name = name;
        this.surname = surname;
        this.employeeID = employeeID;
        this.company = company;
        this.position = position;
        this.salary = salary;
    }

    Employee() {

    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
