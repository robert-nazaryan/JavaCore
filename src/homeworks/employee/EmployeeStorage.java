package homeworks.employee;

public class EmployeeStorage {
    Employee[] employees = new Employee[10];
    int index = 0;

    public void add(Employee employee) {
        if (index == employees.length) {
            extend();
        }
        employees[index++] = employee;
    }

    public void printAllEmployees() {
        for (int i = 0; i < index; i++) {
            printInfo(i);
        }
    }

    public void searchById(String id) {
        for (int i = 0; i < index; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                printInfo(i);
            }
        }
    }

    public void searchByCompany(String company) {
        for (int i = 0; i < index; i++) {
            if (employees[i].getCompany().equalsIgnoreCase(company)) {
                printInfo(i);
            }
        }
    }

    private void printInfo(int index) {
        System.out.println(employees[index].getName() + " " + employees[index].getSurname());
        System.out.println("\tID: " + employees[index].getEmployeeID());
        System.out.println("\tCompany: " + employees[index].getCompany());
        System.out.println("\tPosition: " + employees[index].getPosition());
        System.out.println("\tSalary: " + employees[index].getSalary());
    }

    private void extend() {
        Employee[] temp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, temp, 0, index);
        employees = temp;
    }
}
