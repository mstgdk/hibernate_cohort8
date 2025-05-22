package manyToMany;

import oneToMany_bilateral.House02;
import oneToMany_bilateral.Room02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerSave {
    public static void main(String[] args) {

        Doctor d1 = new Doctor("KBB");
        Doctor d2 = new Doctor("KALP");
        Doctor d3 = new Doctor("GÖZ");
        Doctor d4 = new Doctor("AA");
        Doctor d5 = new Doctor("MNGD");

        Patient p1 = new Patient("mesut");
        Patient p2 = new Patient("erdem");
        Patient p3 = new Patient("kerem");
        Patient p4 = new Patient("velihan");
        Patient p5 = new Patient("canberk");
        Patient p6 = new Patient("mustafa");
        Patient p7 = new Patient("ali");

        List<Patient> patientList1 = Arrays.asList(p1,p3,p5);
        List<Patient> patientList2 = Arrays.asList(p1,p4,p5);
        List<Patient> patientList3 = Arrays.asList(p1,p2,p5);
        List<Patient> patientList4 = Arrays.asList(p3,p4,p6);
        List<Patient> patientList5 = Arrays.asList(p1,p3,p7);

        d1.setPatientList(patientList1);
        d2.setPatientList(patientList2);
        d3.setPatientList(patientList3);
        d4.setPatientList(patientList4);
        d5.setPatientList(patientList5);

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(Patient.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

       /* session.persist(p1);
        session.persist(p2);
        session.persist(p3);
        session.persist(p4);
        session.persist(p5);
        session.persist(p6);
        session.persist(p7);*/

        session.persist(d1);
        session.persist(d2);
        session.persist(d3);
        session.persist(d4);
        session.persist(d5);








        session.getTransaction().commit();
        session.close();
    }
}
