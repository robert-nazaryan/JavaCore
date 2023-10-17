package homeworks.medicalCenter.model;

import homeworks.medicalCenter.storage.Storage;
import homeworks.medicalCenter.util.DateUtil;

import java.util.Date;

public class Patient extends Person {
    private Doctor doctor;
    private Date registerDate;

    public Patient(String id, String name, String surname, String phoneNumber, String email, Doctor doctor, Date registerDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.doctor = doctor;
        this.registerDate = registerDate;
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
                ", register date=" + DateUtil.dateToString(registerDate) +
                ", " + doctor.toString() +
                '}';
    }

    public Date getRegisterDate() {
        return registerDate;
    }
}
