package org.aafaq.util;

import org.aafaq.entity.Workers;
import org.hibernate.Session;

public class WorkersUpdate {

    public static void main(String[] args) {

        WorkersUpdate w = new WorkersUpdate();

        w.update();

        w.deleteOperation();

        HibernateUtil.shutdown();
    }

    public void update() {

        Session session = null;

        try {

            session = HibernateUtil.getFactory().openSession();

            Workers worker = new Workers();

            worker.setWorker_id(21);
            worker.setWorker_name("Ambreen");
            worker.setWorker_city("Hyderabad");

            session.beginTransaction();

            session.merge(worker);

            session.getTransaction().commit();

            System.out.println("Employee updated successfully!");

        } catch (Exception e) {

            if (session != null) {
                session.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteOperation() {

        Session session = null;

        try {

            session = HibernateUtil.getFactory().openSession();

            session.beginTransaction();

            Workers worker = session.get(Workers.class, 21);

            if (worker != null) {

                session.remove(worker);

                System.out.println("Employee deleted successfully!");

            } else {

                System.out.println("Employee not found!");
            }

            session.getTransaction().commit();

        } catch (Exception e) {

            if (session != null) {
                session.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}
