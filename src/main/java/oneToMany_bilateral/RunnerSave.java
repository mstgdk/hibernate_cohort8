package oneToMany_bilateral;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerSave {

    public static void main(String[] args) {
        House02 h1 = new House02(120);
        House02 h2 = new House02(140);

        Room02 r1 = new Room02("blue");
        Room02 r2 = new Room02("black");
        Room02 r3 = new Room02("red");
        Room02 r4 = new Room02("green");

       /* h1.getRooms().add(r1);
        h1.getRooms().add(r2);
        h2.getRooms().add(r3);
        h2.getRooms().add(r4);*/

        r1.setHouse(h1);
        r2.setHouse(h1);
        r3.setHouse(h2);
        r4.setHouse(h2);


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(House02.class)
                .addAnnotatedClass(Room02.class)
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
