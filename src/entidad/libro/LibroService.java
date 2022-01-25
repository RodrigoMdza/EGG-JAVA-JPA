package entidad.libro;

import Persistencia.LibroDao;
import entidad.autor.Autor;
import entidad.autor.AutorService;
import entidad.editorial.Editorial;
import entidad.editorial.EditorialService;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class LibroService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private final LibroDao daoLibro;
    private final AutorService autorService;
    private final EditorialService editorialService;

    public LibroService() {
        this.daoLibro = new LibroDao();
        this.autorService = new AutorService();
        this.editorialService = new EditorialService();
    }

    public void crearLibro(String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes,
            boolean alta) throws Exception {

        try {
            //Validamos
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            //Creamos el usuario
            Libro libro = new Libro();
            System.out.println("Ingrese el nombre de la editorial");
            Editorial editorial = editorialService.crearEditorial(leer.next(), false);
            System.out.println("Ingrese el autor");
            Autor autor = autorService.crearAutor(leer.next(), false);

            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(alta);
            libro.setISBN((long) Math.random() * 1000);
            libro.setEditorial(editorial);
            libro.setAutor(autor);

            daoLibro.guardarLibro(libro);

        } catch (Exception e) {
            System.out.println("No se creeo el usuario" + e.getMessage());
        }
    }

    public Collection<Libro> listaLibros() throws Exception {

        try {
            Collection<Libro> libros = daoLibro.listarLibros();
            return libros;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirLibros() throws Exception {
        try {
            //Listamos los usuarios
            Collection<Libro> libros = listaLibros();

            //Imprimimos los usuarios - Solo algunos atributos....
            if (libros.isEmpty()) {
                throw new Exception("No existen libros para imprimir");
            } else {
                for (Libro aux : libros) {
                    System.out.println("*****************************************");
                    System.out.println(" ISBN:" + aux.getISBN()
                            + "\n Titulo:" + aux.getTitulo()
                            + "\n Anio:" + aux.getAnio()
                            + "\n Ejemplares:" + aux.getEjemplares()
                            + "\n Autor:" + aux.getAutor()
                            + "\n Editorial:" + aux.getEditorial());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimirLibroPorISBN(Integer ISBN) throws Exception {
        System.out.println(daoLibro.imprimirLibroPorISBN(ISBN));
    }

    public void imprimirLibroPorTitulo(String Titulo) throws Exception {
        System.out.println(daoLibro.imprimirLibroPorTitulo(Titulo));
    }

    public void buscarLibroPorAutor(String autor) throws Exception {
        try {
            List<Libro> libros = daoLibro.buscarLibroPorAutor(autor);
            if (libros.isEmpty()) {
                throw new Exception("No existen libros para imprimir");
            } else {
                for (Libro aux : libros) {
                    System.out.println("*****************************************");
                    System.out.println(" ISBN:" + aux.getISBN()
                            + "\n Titulo:" + aux.getTitulo()
                            + "\n Anio:" + aux.getAnio()
                            + "\n Ejemplares:" + aux.getEjemplares()
                            + "\n Autor:" + aux.getAutor()
                            + "\n Editorial:" + aux.getEditorial());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarLibroPorEditorial(String editorial) throws Exception {
        try {
            List<Libro> libros = daoLibro.buscarLibroPorEditorial(editorial);
            if (libros.isEmpty()) {
                throw new Exception("No existen libros para imprimir");
            } else {
                for (Libro aux : libros) {
                    System.out.println("*****************************************");
                    System.out.println(" ISBN:" + aux.getISBN()
                            + "\n Titulo:" + aux.getTitulo()
                            + "\n Anio:" + aux.getAnio()
                            + "\n Ejemplares:" + aux.getEjemplares()
                            // PUEDO MOSTRAR TODO DEL AUTOS O SOLO EL NOMBRE
                            + "\n Autor:" + aux.getAutor().getNombre()
                            + "\n Editorial:" + aux.getEditorial().toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

// PARA USAR EL % EN SPQL
// return em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE CONCAT('%', :nombre, '%')", Autor.class).setParameter("nombre", nombre).getResultList();
//   PARA BUSCAR POR MAS DE UN PARAMERO
/*
public Autor buscarAutorPorNombre(String nombre, Boolean estado) throws MiExcepcion {
        try {
            Autor autor = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre AND a.alta = :estado", Autor.class)
                    .setParameter("nombre", nombre)
                    .setParameter("estado", estado)
                    .getSingleResult();

            return autor;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new MiExcepcion("ERROR AL BUSCAR AUTOR POR ID");
        }
    }

 */
