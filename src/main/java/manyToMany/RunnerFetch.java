package manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(Patient.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        Doctor doctor =session.get(Doctor.class,3);
        System.out.println(doctor);

        Patient patient = session.get(Patient.class,4);
        System.out.println(patient);








        session.getTransaction().commit();
        session.close();
    }
}
