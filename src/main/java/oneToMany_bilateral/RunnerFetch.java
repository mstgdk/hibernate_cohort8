package oneToMany_bilateral;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(House02.class)
                .addAnnotatedClass(Room02.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        House02 house = session.get(House02.class,2);
        System.out.println(house);

        Room02 r3 = session.get(Room02.class,3);
        r3.setHouse(null);
        //session.persist(r2);


        session.getTransaction().commit();
        session.close();
    }
}
