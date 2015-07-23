/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalPckg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikhil
 */
public class Doctor {

    private final String doctorName;
    private final String doctorSpeciality;
    List<Patient> doctorPatientList = new ArrayList<>();

    Doctor(String name, String speciality) {
        this.doctorName = name;
        this.doctorSpeciality = speciality;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public List<Patient> getDoctorPatientList() {
        return doctorPatientList;
    }

    public void addPatientsToDoctor(Patient patient) {
        doctorPatientList.add(patient);
    }

    String getDoctorspeciality() {
        return doctorSpeciality;
    }

    @Override
    public String toString() {
        return (doctorName + " " + doctorSpeciality);
    }

}
