package homeworks.medicalCenter.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient extends Person {
    private Doctor doctor;
    private Date date;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public Patient(String id, String name, String surname, String phoneNumber, String email, Doctor doctor) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.doctor = doctor;
        this.date = new Date();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", date=" + simpleDateFormat.format(date) +
                ", " + doctor.toString() +
                '}';
    }
}
