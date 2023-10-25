package homeworks.medicalCenter;

import homeworks.medicalCenter.exceptions.DoctorNotFoundException;
import homeworks.medicalCenter.exceptions.ProfessionNotFoundException;
import homeworks.medicalCenter.model.Doctor;
import homeworks.medicalCenter.model.Patient;
import homeworks.medicalCenter.storage.Storage;
import homeworks.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenterDemo implements Commands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Storage storage = new Storage();

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            switch (scanner.nextLine()) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_BY_ID:
                    changeDoctorById();
                    break;
                case ADD_PATIENT:
                    addPatient();
                    break;
                case PRINT_PATIENT_BY_DOCTOR:
                    printPatientByDoctor();
                    break;
                case PRINT_PATIENTS:
                    storage.printPatients();
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }

    private static void searchDoctorByProfession() {
        System.out.println("Enter doctor PROFESSION");
        try {
            storage.searchDoctorByProfession(scanner.nextLine()).printDoctors();
        } catch (ProfessionNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void deleteDoctorById() {
        System.out.println("Enter doctor ID");
        String id = scanner.nextLine();
        storage.deletePatientByDoctorId(id);
        try {
            storage.deleteDoctorById(id);
        } catch (DoctorNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void printPatientByDoctor() {
        storage.printDoctors();
        System.out.println("Enter doctor by ID");
        Doctor doctor = null;
        try {
            doctor = storage.findDoctorById(scanner.nextLine());
        } catch (DoctorNotFoundException e) {
            System.out.println(e);
        }

        if (doctor == null) {
            System.out.println("Invalid id!");
            return;
        }
        storage.searchPatientByDoctor(doctor).printPatients();
    }

    private static void addPatient() throws ParseException {
        storage.printDoctors();
        System.out.println("Enter doctor by ID");
        String doctorId = scanner.nextLine();
        Doctor doctor = null;
        try {
            doctor = storage.findDoctorById(doctorId);
        } catch (DoctorNotFoundException e) {
            System.out.println(e);
        }

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
        System.out.println("Enter patient REGISTER DATE");
        Date registerDate = DateUtil.stringToDate(scanner.nextLine());
        while (!storage.isFreeDate(registerDate, doctorId)) {
            System.out.println("The doctor is busy at this date");
            System.out.println("Enter another DATE");
            registerDate = DateUtil.stringToDate(scanner.nextLine());
        }
        storage.add(new Patient(id, name, surname, phoneNumber, email, doctor, registerDate));
    }

    private static void changeDoctorById() {
        System.out.println("Enter doctor ID");
        Doctor doctor = null;
        try {
            doctor = storage.findDoctorById(scanner.nextLine());
        } catch (DoctorNotFoundException e) {
            System.out.println(e);
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
        System.out.println("Enter " + EXIT + " for EXIT");
        System.out.println("Enter " + ADD_DOCTOR + " for ADD DOCTOR");
        System.out.println("Enter " + SEARCH_DOCTOR_BY_PROFESSION + " for SEARCH DOCTOR BY PROFESSION");
        System.out.println("Enter " + DELETE_DOCTOR_BY_ID + " for DELETE DOCTOR BY ID");
        System.out.println("Enter " + CHANGE_DOCTOR_BY_ID + " for CHANGE DOCTOR BY ID");
        System.out.println("Enter " + ADD_PATIENT + " for ADD PATIENT");
        System.out.println("Enter " + PRINT_PATIENT_BY_DOCTOR + " for PRINT ALL PATIENTS BY DOCTOR");
        System.out.println("Enter " + PRINT_PATIENTS + " for PRINT ALL PATIENTS");
    }
}
