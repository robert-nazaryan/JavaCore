package homeworks.medicalCenter;

import homeworks.medicalCenter.model.Doctor;
import homeworks.medicalCenter.model.Patient;
import homeworks.medicalCenter.storage.Storage;

import java.util.Scanner;

public class MedicalCenterDemo {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Storage storage = new Storage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            switch (scanner.nextLine()) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addDoctor();
                    break;
                case "2":
                    System.out.println("Enter doctor PROFESSION");
                    storage.searchDoctorByProfession(scanner.nextLine()).printDoctors();
                    break;
                case "3":
                    deleteDoctorById();
                    break;
                case "4":
                    changeDoctorById();
                    break;
                case "5":
                    addPatient();
                    break;
                case "6":
                    printPatientByDoctor();
                    break;
                case "7":
                    storage.printPatients();
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }

    private static void deleteDoctorById() {
        System.out.println("Enter doctor ID");
        String id = scanner.nextLine();
        Doctor doctor = (Doctor) storage.findDoctorById(id);
        storage.deletePatientByDoctor(doctor);
        storage.deleteDoctorById(id);
    }

    private static void printPatientByDoctor() {
        storage.printDoctors();
        System.out.println("Enter doctor by ID");
        Doctor doctor = (Doctor) storage.findDoctorById(scanner.nextLine());

        if (doctor == null) {
            System.out.println("Invalid id!");
            return;
        }
        storage.searchPatientByDoctor(doctor).printPatients();
    }

    private static void addPatient() {
        storage.printDoctors();
        System.out.println("Enter doctor by ID");
        Doctor doctor = (Doctor) storage.findDoctorById(scanner.nextLine());

        if (doctor == null) {
            System.out.println("Invalid id!");
            return;
        }
        System.out.println("Enter patient ID");
        String id = scanner.nextLine();
        System.out.println("Enter patient NAME");
        String name = scanner.nextLine();
        System.out.println("Enter patient SURNAME");
        String surname = scanner.nextLine();
        System.out.println("Enter patient PHONE NUMBER");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter patient EMAIL");
        String email = scanner.nextLine();
        storage.add(new Patient(id, name, surname, phoneNumber, email, doctor));
    }

    private static void changeDoctorById() {
        System.out.println("Enter doctor ID");
        Doctor doctor = (Doctor) storage.findDoctorById(scanner.nextLine());

        if (doctor == null) {
            System.out.println("Invalid id!");
            return;
        }
        System.out.println("Enter doctor NAME");
        doctor.setName(scanner.nextLine());
        System.out.println("Enter doctor SURNAME");
        doctor.setSurname(scanner.nextLine());
        System.out.println("Enter doctor PHONE NUMBER");
        doctor.setPhoneNumber(scanner.nextLine());
        System.out.println("Enter doctor EMAIL");
        doctor.setEmail(scanner.nextLine());
        System.out.println("Enter doctor PROFESSION");
        doctor.setProfession(scanner.nextLine());
    }

    private static void addDoctor() {
        System.out.println("Enter doctor ID");
        String id = scanner.nextLine();
        System.out.println("Enter doctor NAME");
        String name = scanner.nextLine();
        System.out.println("Enter doctor SURNAME");
        String surname = scanner.nextLine();
        System.out.println("Enter doctor PHONE NUMBER");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter doctor EMAIL");
        String email = scanner.nextLine();
        System.out.println("Enter doctor PROFESSION");
        String profession = scanner.nextLine();
        storage.add(new Doctor(id, name, surname, phoneNumber, email, profession));
    }

    private static void printCommands() {
        System.out.println("Enter 0 for EXIT");
        System.out.println("Enter 1 for ADD DOCTOR");
        System.out.println("Enter 2 for SEARCH DOCTOR BY PROFESSION");
        System.out.println("Enter 3 for DELETE DOCTOR BY ID");
        System.out.println("Enter 4 for CHANGE DOCTOR BY ID");
        System.out.println("Enter 5 for ADD PATIENT");
        System.out.println("Enter 6 for PRINT ALL PATIENTS BY DOCTOR");
        System.out.println("Enter 7 for PRINT ALL PATIENTS");
    }
}
