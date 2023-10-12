package homeworks.medicalCenter.storage;

import homeworks.medicalCenter.model.Doctor;

public class DoctorsStorage {
    private Doctor[] doctors = new Doctor[10];
    private int index;

    public void add(Doctor doctor) {
        if (index == doctors.length) {
            extend();
        }
        doctors[index++] = doctor;
    }

    public DoctorsStorage searchDoctorByProfession(String profession) {
        DoctorsStorage doctorsStorage = new DoctorsStorage();
        for (int i = 0; i < index; i++) {
            if (doctors[i].getProfession().equalsIgnoreCase(profession)) {
                doctorsStorage.add(doctors[i]);
            }
        }
        return doctorsStorage;
    }

    public void printDoctors() {
        for (int i = 0; i < index; i++) {
            System.out.println(doctors[i].toString());
        }
    }

    public Doctor findDoctorById(String id) {
        for (int i = 0; i < index; i++) {
            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }
        return null;
    }

    public void deleteDoctorById(String id) {
        for (int i = 0; i < index; i++) {
            if (doctors[i].getId().equals(id)) {
                deleteDoctorByIndex(i);
            }
        }
    }

    private void deleteDoctorByIndex(int index) {
        for (int i = index; i < this.index; i++) {
            doctors[i] = doctors[i + 1];
        }
        this.index--;
    }

    private void extend() {
        Doctor[] temp = new Doctor[doctors.length + 10];
        System.arraycopy(doctors, 0, temp, 0, index);
        doctors = temp;
    }

}
