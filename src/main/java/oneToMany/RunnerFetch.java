package oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(House.class)
                .addAnnotatedClass(Room.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        House house = session.get(House.class, 2);
        System.out.println(house);

       // session.remove(house);
        Room room = session.get(Room.class,1);
        session.remove(room);


        session.getTransaction().commit();
        session.close();
    }
}
