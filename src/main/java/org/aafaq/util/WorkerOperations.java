package org.aafaq.util;

import org.aafaq.entity.Workers;
import org.hibernate.Session;

public class WorkerOperations {

    public void insertEmployee() {

        Session session = null;

        try {

            session = HibernateUtil.getFactory().openSession();

            Workers workers = new Workers();

            workers.setWorker_id(21);
            workers.setWorker_name("Aafaq");
            workers.setWorker_city("Nirmal");

            session.beginTransaction();

            session.persist(workers);

            session.getTransaction().commit();

            System.out.println("Employee inserted successfully!");

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

    public void getEmployeeRow() {

        Session session = null;

        try {

            session = HibernateUtil.getFactory().openSession();

            session.beginTransaction();

            Workers worker = session.get(Workers.class, 21);

            session.getTransaction().commit();

            if (worker != null) {

                System.out.println("Employee Found");

                System.out.println("ID : " + worker.getWorker_id());

                System.out.println("Name : " + worker.getWorker_name());

                System.out.println("City : " + worker.getWorker_city());

            } else {

                System.out.println("Employee not found!");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public void closeFactory() {
        HibernateUtil.shutdown();
    }
}