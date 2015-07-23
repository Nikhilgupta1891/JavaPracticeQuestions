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
public class Hospital {
    
    List<Doctor> doctorList = new ArrayList<>();
    List<Patient> patientList = new ArrayList<>();
    String hospitalName;

    void addDoctor(Doctor o) {
        doctorList.add(o);
    }

    void addPatient(Patient o) {
        patientList.add(o);
    }
    
    void getHospitalName()
    {
        System.out.println(hospitalName + " Hospital");
    }

    Hospital(String name) {
        this.hospitalName = name;
    }

    public List<Doctor> showDoctors() {
        return doctorList;
    }

    public List<Patient> showPatients() {
        return patientList;
    }

    public void assignDoctor() {
        for (Patient patient : patientList) {
            for (Doctor doc : doctorList) {
                if (patient.getDisease().equals("eye")) {
                    if (doc.getDoctorspeciality().equals("Opthalmologist")) {
                        doc.addPatientsToDoctor(patient);
                    }
                }
                if (patient.getDisease().equals("heart patient")) {
                    if (doc.getDoctorspeciality().equals("Surgeon")) {
                        doc.addPatientsToDoctor(patient);
                    }
                }
                if (patient.getDisease().equals("earnose")) {
                    if (doc.getDoctorspeciality().equals("ENT")) {
                        doc.addPatientsToDoctor(patient);
                    }
                }
            }
        }
    }
}
