package Persistencia;

import entidad.editorial.Editorial;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EditorialDao {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LIBRERIAPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarEditorial(Editorial editorial) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(editorial); // Para guardar - envio el objeto completo
        em.getTransaction().commit();       
    }
  
}
