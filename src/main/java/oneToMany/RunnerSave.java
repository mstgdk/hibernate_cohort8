package oneToMany;

import oneToOne.Computer;
import oneToOne.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerSave {


    public static void main(String[] args) {
        House h1 = new House(120);
        House h2 = new House(140);

        Room r1 = new Room("blue");
        Room r2 = new Room("black");
        Room r3 = new Room("red");
        Room r4 = new Room("green");

        h1.getRooms().add(r1);
        h1.getRooms().add(r2);
        h2.getRooms().add(r3);
        h2.getRooms().add(r4);


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(House.class)
                .addAnnotatedClass(Room.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        session.persist(h1);
        session.persist(h2);
        session.persist(r1);
        session.persist(r2);
        session.persist(r3);
        session.persist(r4);





        session.getTransaction().commit();
        session.close();
    }
}
