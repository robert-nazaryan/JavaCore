package homeworks.medicalCenter.storage;

import homeworks.medicalCenter.model.Doctor;
import homeworks.medicalCenter.model.Patient;

public class PatientStorage {
    private Patient[] patients = new Patient[10];
    private int index;

    public PatientStorage searchPatientByDoctor(Doctor doctor) {
        PatientStorage patientStorage = new PatientStorage();
        for (int i = 0; i < index; i++) {
            if (patients[i].getDoctor().equals(doctor)) {
                patientStorage.add(patients[i]);
            }
        }
        return patientStorage;
    }

    public void deletePatientByDoctor(Doctor doctor) {
        for (int i = 0; i < index; i++) {
            if (patients[i].getDoctor().equals(doctor)) {
                deletePatientByIndex(i);
            }
        }
    }

    public void deletePatientByIndex(int index) {
        for (int i = index; i < this.index; i++) {
            patients[i] = patients[i + 1];
        }
        this.index--;
    }

    public void printPatients() {
        for (int i = 0; i < index; i++) {
            System.out.println(patients[i].toString());
        }
    }

    public void add(Patient patient) {
        if (index == patients.length) {
            extend();
        }
        patients[index++] = patient;
    }

    private void extend() {
        Patient[] temp = new Patient[patients.length + 10];
        System.arraycopy(patients, 0, temp, 0, index);
        patients = temp;
    }
}
