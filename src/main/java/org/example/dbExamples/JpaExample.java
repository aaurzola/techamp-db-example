package org.example.dbExamples;

import jakarta.persistence.*;
import org.example.model.Libro;

import java.util.List;

public class JpaExample {

    public static void select() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookUnit");
        EntityManager em = emf.createEntityManager();

        //empezar una transaccion
        em.getTransaction().begin();
        TypedQuery<Libro> bookTypedQuery = em.createQuery("SELECT l FROM Libro l", Libro.class);
        List<Libro> bookList = bookTypedQuery.getResultList();
        for(Libro book : bookList) {
            System.out.println(book.toString());
        }
        //final la transaccion
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

    public static void insert() {

        //EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookUnit");

        //EntityManager
        EntityManager em = emf.createEntityManager();

        //Preparar el objeto que introducire
        Libro myNewBook = new Libro("La paloma", "Autor 3", "Este libro me hizo llorar");

        //Iniciar la transaccion
        em.getTransaction().begin();

        //Guardarlo en la bd
        em.persist(myNewBook);

        //finalizar la transaccion
        em.getTransaction().commit();

        //cerrar entityManagers
        em.close();
        emf.close();
    }

    public static void delete() {

        //EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookUnit");

        //EntityManager
        EntityManager em = emf.createEntityManager();

        //Empezar la transaccion
        em.getTransaction().begin();

        //buscar el registro
        Libro bookToDelete = em.find(Libro.class, "Titulo2");

        //eliminar el registro
        em.remove(bookToDelete);

        //finalizar la transaccion
        em.getTransaction().commit();

        //Cerrar EntityManagers
        em.close();
        emf.close();

    }
}
