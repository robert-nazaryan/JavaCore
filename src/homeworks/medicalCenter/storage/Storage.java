package homeworks.medicalCenter.storage;

import homeworks.medicalCenter.model.Doctor;
import homeworks.medicalCenter.model.Patient;
import homeworks.medicalCenter.model.Person;

public class Storage {
    private Person[] people = new Person[10];
    private int index;

    public void add(Person person) {
        if (index == people.length) {
            extend();
        }
        people[index++] = person;
    }

    public Storage searchPatientByDoctor(Doctor doctor) {
        Storage patients = new Storage();
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Patient && ((Patient) people[i]).getDoctor().equals(doctor)) {
                patients.add(people[i]);
            }
        }
        return patients;
    }

    public Storage searchDoctorByProfession(String profession) {
        Storage doctors = new Storage();
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Doctor) {
                if (((Doctor) people[i]).getProfession().equalsIgnoreCase(profession)) {
                    doctors.add(people[i]);
                }
            }
        }
        return doctors;
    }

    public void deletePatientByDoctor(Doctor doctor) {
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Patient && ((Patient) people[i]).getDoctor().equals(doctor)) {
                deleteByIndex(i);
            }
        }
    }

    public void printDoctors() {
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Doctor) {
                System.out.println((people[i]).toString());
            }
        }
    }

    public void printPatients() {
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Patient) {
                System.out.println((people[i]).toString());
            }
        }
    }

    public Person findDoctorById(String id) {
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Doctor && people[i].getId().equals(id)) {
                return people[i];
            }
        }
        return null;
    }

    public void deleteDoctorById(String id) {
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Doctor && people[i].getId().equals(id)) {
                deleteByIndex(i);
            }
        }
    }

    private void deleteByIndex(int index) {
        for (int i = index; i < this.index; i++) {
            people[i] = people[i + 1];
        }
        this.index--;
    }

    private void extend() {
        Person[] temp = new Person[people.length + 10];
        System.arraycopy(people, 0, temp, 0, index);
        people = temp;
    }
}
