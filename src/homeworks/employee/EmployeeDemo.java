package homeworks.employee;

import java.util.Scanner;

public class EmployeeDemo {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addEmployee();
                    break;
                case "2":
                    employeeStorage.printAllEmployees();
                    break;
                case "3":
                    System.out.println("Please enter employee ID");
                    employeeStorage.searchById(scanner.nextLine());
                    break;
                case "4":
                    System.out.println("Please enter employee company");
                    employeeStorage.searchByCompany(scanner.nextLine());
                    break;
                case "5":
                    System.out.println("Please enter employee ID");
                    employeeStorage.deleteById(scanner.nextLine());
                    break;
                case "6":
                    changeEmployeeById();
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }

    private static void changeEmployeeById() {
        String[] data = takeEmployeeData();
        employeeStorage.changeEmployee(data[0], data[1], data[2], data[3], data[4], data[5]);
    }

    private static void printCommands() {
        System.out.println("Please enter 0 for EXIT");
        System.out.println("Please enter 1 for ADD EMPLOYEE");
        System.out.println("Please enter 2 for PRINT ALL EMPLOYEES");
        System.out.println("Please enter 3 for SEARCH EMPLOYEE BY EMPLOYEE ID");
        System.out.println("Please enter 4 for SEARCH EMPLOYEE BY COMPANY NAME");
        System.out.println("Please enter 5 for DELETE EMPLOYEE BY ID");
        System.out.println("Please enter 6 for CHANGE EMPLOYEE BY ID");
    }

    private static String[] takeEmployeeData() {
        System.out.println("Please enter employee ID");
        String id = scanner.nextLine();
        System.out.println("Please enter employee name");
        String name = scanner.nextLine();
        System.out.println("Please enter employee surname");
        String surname = scanner.nextLine();
        System.out.println("Please enter employee company");
        String company = scanner.nextLine();
        System.out.println("Please enter employee position");
        String position = scanner.nextLine();
        System.out.println("Please enter employee salary");
        String salary = scanner.nextLine();
        return new String[]{id, name, surname, company, position, salary};
    }

    private static void addEmployee() {
        String[] data = takeEmployeeData();
        Employee employee = new Employee(data[0], data[1], data[2], data[3], data[4], data[5]);
        employeeStorage.add(employee);
    }
}
