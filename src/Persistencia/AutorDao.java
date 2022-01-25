package Persistencia;

import entidad.autor.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AutorDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LIBRERIAPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarAutor(Autor autor) throws Exception {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    //CONSULTA CON PARAMETROS
    public Autor buscarAutorPorNombre(String nombre) throws Exception {
        Autor autor = (Autor) em.createQuery("SELECT a "
                + " FROM Autor a"
                + " WHERE a.nombre LIKE :nombre").
                setParameter("nombre", nombre).
                getSingleResult();
        return autor;
    }
    //CONSULTA SIN PARAMETROS

    public List<Autor> listarAutores() throws Exception {
        List<Autor> autores = em.createQuery("SELECT d FROM Usuario d")
                .getResultList();
        return autores;
    }
}
