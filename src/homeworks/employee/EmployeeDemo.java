package homeworks.employee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeStorage employeeStorage = new EmployeeStorage();
        boolean isRun = true;
        while (isRun) {
            System.out.println("Please enter 0 for EXIT");
            System.out.println("Please enter 1 for ADD EMPLOYEE");
            System.out.println("Please enter 2 for PRINT ALL EMPLOYEES");
            System.out.println("Please enter 3 for SEARCH EMPLOYEE BY EMPLOYEE ID");
            System.out.println("Please enter 4 for SEARCH EMPLOYEE BY COMPANY NAME");
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    System.out.println("Please enter employee name");
                    String name = scanner.nextLine();
                    System.out.println("Please enter employee surname");
                    String surname = scanner.nextLine();
                    System.out.println("Please enter employee ID");
                    String id = scanner.nextLine();
                    System.out.println("Please enter employee company");
                    String company = scanner.nextLine();
                    System.out.println("Please enter employee position");
                    String position = scanner.nextLine();
                    System.out.println("Please enter employee salary");
                    String salary = scanner.nextLine();
                    Employee employee = new Employee(name, surname, id, company, position, salary);
                    employeeStorage.add(employee);
                    break;
                case "2":
                    employeeStorage.printAllEmployees();
                    break;
                case "3":
                    System.out.println("Please enter employee ID");
                    id = scanner.nextLine();
                    employeeStorage.searchById(id);
                    break;
                case "4":
                    System.out.println("Please enter employee company");
                    company = scanner.nextLine();
                    employeeStorage.searchByCompany(company);
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }
}
