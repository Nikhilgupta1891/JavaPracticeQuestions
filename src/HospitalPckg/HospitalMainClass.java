/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalPckg;

import java.util.List;

/**
 *
 * @author nikhil
 */

public class HospitalMainClass {    
    public static void main(String args[]) {
        Hospital h1 = new Hospital("Appollo");
        
        Doctor o = new Doctor("Doc1", "Surgeon");
        Doctor o1 = new Doctor("Doc2", "Opthalmologist");
        Doctor o2 = new Doctor("Doc3", "ENT");
        
        h1.getHospitalName();
        
        System.out.println("Add Doctors");
        h1.addDoctor(o);
        h1.addDoctor(o1);
        h1.addDoctor(o2);

        System.out.println("Show Doctors");
        List<Doctor> doctorsList = h1.showDoctors();
        System.out.println(doctorsList);

        System.out.println("Add Patient");
        Patient p = new Patient("Patient1 ", 21, " Male ", "eye");
        Patient p1 = new Patient("Patient2 ", 12, " Male ", "heart patient");
        Patient p2 = new Patient("Patient3 ", 23, " Female ", "earnose");
        Patient p3 = new Patient("Patient4 ", 31, " Female ", "earnose");
        Patient p5 = new Patient("Patient5 ", 18, " Male ", "eye");
        Patient p4 = new Patient("Patient6 ", 15, " Male ", "heart patient");
        h1.addPatient(p);
        h1.addPatient(p1);
        h1.addPatient(p2);
        h1.addPatient(p3);
        h1.addPatient(p4);
        h1.addPatient(p5);
        System.out.println(h1.showPatients());

        System.out.println("Assign doctor to patients");
        h1.assignDoctor();

        System.out.println("Doctor and their patients");
        System.out.println(o.getDoctorName() + "" + o.getDoctorPatientList());
        System.out.println(o1.getDoctorName() + "" + o1.getDoctorPatientList());
        System.out.println(o2.getDoctorName() + "" + o2.getDoctorPatientList());
    }
}
    

