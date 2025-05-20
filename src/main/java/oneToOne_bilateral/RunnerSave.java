package oneToOne_bilateral;

import oneToOne.Computer;
import oneToOne.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {
        Computer02 c1 = new Computer02(1L,"Abrand", "Amodel");
        Computer02 c2 = new Computer02(2L,"Bbrand", "Bmodel");
        Computer02 c3 = new Computer02(3L,"Cbrand", "Cmodel");

        Student02 s1 = new Student02(1L,123,"mesut");
        Student02 s2 = new Student02(2L,124,"erdem");
        Student02 s3 = new Student02(3L,125,"kerem");

        s1.setComputer(c1);
        s2.setComputer(c2);
        s3.setComputer(c3);

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class)
                .addAnnotatedClass(Computer02.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();


        session.persist(c1);
        session.persist(c2);
        session.persist(c3);
        session.persist(s1);
        session.persist(s2);
        session.persist(s3);




        session.getTransaction().commit();
        session.close();
    }
}
