package homeworks.medicalCenter.storage;

import homeworks.medicalCenter.exceptions.DoctorNotFoundException;
import homeworks.medicalCenter.exceptions.ProfessionNotFoundException;
import homeworks.medicalCenter.model.Doctor;
import homeworks.medicalCenter.model.Patient;
import homeworks.medicalCenter.model.Person;

import java.util.Date;

public class Storage {
    private Person[] people = new Person[10];
    private int index;
    private static final long THIRTY_MINUTES = 1800000;

    public void add(Person person) {
        if (index == people.length) {
            extend();
        }
        people[index++] = person;
    }

    public boolean isFreeDate(Date date, String doctorId) {
        Storage patientsByOneDoctor;
        try {
            patientsByOneDoctor = searchPatientByDoctor(findDoctorById(doctorId));
        } catch (DoctorNotFoundException e) {
            patientsByOneDoctor = null;
        }
        for (int i = 0; i < patientsByOneDoctor.getIndex(); i++) {
            if (Math.abs(((Patient) patientsByOneDoctor.getPeople()[i]).getRegisterDate().getTime() -
                    date.getTime()) < THIRTY_MINUTES) {
                return false;
            }

        }
        return true;
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

    public Storage searchDoctorByProfession(String profession) throws ProfessionNotFoundException {
        Storage doctors = new Storage();
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Doctor && ((Doctor) people[i]).getProfession().equalsIgnoreCase(profession)) {
                doctors.add(people[i]);

            }
        }
        if (doctors.getIndex() == 0) {
            throw new ProfessionNotFoundException();
        }
        return doctors;
    }

    public void deletePatientByDoctorId(String id) {
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Patient) {
                if (((Patient) people[i]).getDoctor().getId().equals(id)) {
                    deleteByIndex(i--);
                }
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

    public Doctor findDoctorById(String id) throws DoctorNotFoundException {
        for (int i = 0; i < index; i++) {
            if ((people[i] instanceof Doctor) && ((Doctor) people[i]).getId().equals(id)) {
                return (Doctor) people[i];
            }
        }
        throw new DoctorNotFoundException();
    }

    public void deleteDoctorById(String id) throws DoctorNotFoundException {
        for (int i = 0; i < index; i++) {
            if (people[i] instanceof Doctor && ((Doctor) people[i]).getId().equals(id)) {
                deleteByIndex(i--);
            }
        }
        throw new DoctorNotFoundException();
    }

    private void deleteByIndex(int index) {
        if (index > this.index && index < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index + 1; i < this.index; i++) {
            people[i - 1] = people[i];
        }
        this.index--;
    }

    private void extend() {
        Person[] temp = new Person[people.length + 10];
        System.arraycopy(people, 0, temp, 0, index);
        people = temp;
    }

    public int getIndex() {
        return index;
    }

    public Person[] getPeople() {
        return people;
    }
}
