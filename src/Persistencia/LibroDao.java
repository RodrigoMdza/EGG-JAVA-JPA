package Persistencia;

import entidad.libro.Libro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class LibroDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LIBRERIAPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarLibro(Libro libro) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(libro); // Para guardar - envio el objeto completo
        em.getTransaction().commit();
    }

    //CONSULTA SIN PARAMETROS
    public List<Libro> listarLibros() throws Exception {
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        return libros;
    }

    //CONSULTA CON PARAMETROS
    public Libro imprimirLibroPorISBN(Integer ISBN) throws Exception {
        /*
        TAMBIEN PUEDE HACERSE CON EL METODO FIND:
        return em.find(Libro.class, ISBN);
         */
        Libro libro = (Libro) em.createQuery("SELECT l "
                + " FROM Libro l"
                + " WHERE l.ISBN = :ISBN").
                setParameter("ISBN", ISBN).
                getSingleResult();
        return libro;
    }

    public Libro imprimirLibroPorTitulo(String Titulo) throws Exception {
        try {
            Libro libro = (Libro) em.createQuery("SELECT l "
                    + " FROM Libro l"
                    + " WHERE l.titulo = :titulo").
                    setParameter("titulo", Titulo).
                    getSingleResult();
            return libro;
            // ESTA ES LA EXCEPCION QUE FUNCIONA CUANDO NO ARROJA NINGUN RESULTADO ESE TITULO
        } catch (NoResultException e) {
            return null;
        }

        /*
        TAMBIEN PUEDE HACERSE SIN EL PARSEO:
        return em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo", Libro.class)
                .setParameter("titulo", Titulo)
                .getSingleResult();
         */
    }

    public List<Libro> buscarLibroPorAutor(String autor) throws Exception {
       /*
        ESTA ES OTRA FORMA CASTEANDO.
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :autor", Libro.class)
                .setParameter("autor", autor)
                .getResultList();

        return libros;
       */
       
       return em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :autor", Libro.class)
                .setParameter("autor", autor)
                .getResultList();
    }
    
    public List<Libro> buscarLibroPorEditorial(String editorial) throws Exception {
     
       return em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :editorial", Libro.class)
                .setParameter("editorial", editorial)
                .getResultList();
    }
    

}
