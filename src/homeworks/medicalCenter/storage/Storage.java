package homeworks.medicalCenter.storage;

import homeworks.medicalCenter.model.Doctor;
import homeworks.medicalCenter.model.Patient;

import java.util.Date;

public class Storage {
    private Object[] objects = new Object[10];
    private int index;
    private static final long THIRTY_MINUTES = 1800000;

    public void add(Object o) {
        if (index == objects.length) {
            extend();
        }
        objects[index++] = o;
    }

    public boolean isFreeDate(Date date, String doctorId) {
        Storage patientsByOneDoctor = searchPatientByDoctor(findDoctorById(doctorId));
        for (int i = 0; i < patientsByOneDoctor.getIndex(); i++) {
            if (Math.abs(((Patient) patientsByOneDoctor.getObjects()[i]).getRegisterDate().getTime() -
                    date.getTime()) < THIRTY_MINUTES) {
                return false;
            }

        }
        return true;
    }

    public Storage searchPatientByDoctor(Doctor doctor) {
        Storage patients = new Storage();
        for (int i = 0; i < index; i++) {
            if (objects[i] instanceof Patient && ((Patient) objects[i]).getDoctor().equals(doctor)) {
                patients.add(objects[i]);
            }
        }
        return patients;
    }

    public Storage searchDoctorByProfession(String profession) {
        Storage doctors = new Storage();
        for (int i = 0; i < index; i++) {
            if (objects[i] instanceof Doctor && ((Doctor) objects[i]).getProfession().equalsIgnoreCase(profession)) {
                doctors.add(objects[i]);

            }
        }
        return doctors;
    }

    public void deletePatientByDoctorId(String id) {
        for (int i = 0; i < index; i++) {
            if (objects[i] instanceof Patient) {
                if (((Patient) objects[i]).getDoctor().getId().equals(id)) {
                    deleteByIndex(i--);
                }
            }
        }
    }

    public void printDoctors() {
        for (int i = 0; i < index; i++) {
            if (objects[i] instanceof Doctor) {
                System.out.println((objects[i]).toString());
            }
        }
    }

    public void printPatients() {
        for (int i = 0; i < index; i++) {
            if (objects[i] instanceof Patient) {
                System.out.println((objects[i]).toString());
            }
        }
    }

    public Doctor findDoctorById(String id) {
        for (int i = 0; i < index; i++) {
            if ((objects[i] instanceof Doctor) && ((Doctor) objects[i]).getId().equals(id)) {
                return (Doctor) objects[i];
            }
        }
        return null;
    }

    public void deleteDoctorById(String id) {
        for (int i = 0; i < index; i++) {
            if (objects[i] instanceof Doctor && ((Doctor) objects[i]).getId().equals(id)) {
                deleteByIndex(i);
            }
        }
    }

    private void deleteByIndex(int index) {
        for (int i = index + 1; i < this.index; i++) {
            objects[i - 1] = objects[i];
        }
        this.index--;
    }

    private void extend() {
        Object[] temp = new Object[objects.length + 10];
        System.arraycopy(objects, 0, temp, 0, index);
        objects = temp;
    }

    public int getIndex() {
        return index;
    }

    public Object[] getObjects() {
        return objects;
    }
}
