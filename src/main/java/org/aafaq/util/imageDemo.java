package org.aafaq.util;

import org.aafaq.entity.largeObjectDemo;
import org.hibernate.Session;

import java.io.FileInputStream;

public class imageDemo {

    public static void main(String[] args) {

        imageDemo demo = new imageDemo();

        demo.imageSave();

        HibernateUtil.shutdown();
    }

    public void imageSave() {

        Session session = null;

        try {

            session = HibernateUtil.getFactory().openSession();

            FileInputStream fis =
                    new FileInputStream("src/main/resources/image.png");

            byte[] imageBytes = fis.readAllBytes();

            largeObjectDemo image = new largeObjectDemo();

            image.setStudentId(1);
            image.setStudentImage(imageBytes);

            session.beginTransaction();

            session.persist(image);

            session.getTransaction().commit();

            fis.close();

            System.out.println("Image saved successfully!");

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