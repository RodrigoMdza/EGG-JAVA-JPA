package Principal;

import entidad.autor.AutorService;
import entidad.editorial.EditorialService;
import entidad.libro.LibroService;
import java.awt.AWTException;
import java.awt.Robot;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    private final Scanner sc;
    private final LibroService libroService;
    private final AutorService autorService;
    private final EditorialService editorialService;

    public Menu() {
        this.sc = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        this.libroService = new LibroService();
        this.autorService = new AutorService();
        this.editorialService = new EditorialService();
    }

    public void menu() throws Exception {
        String respuesta;
        do {
            System.out.println("Seleccione la opción:");
            System.out.println("=====================================");

            System.out.println(" 1- Crear Libro con autor y editorial");
            System.out.println(" 2- Crear Autor solamente");
            System.out.println(" 3- Crear Editorial solamente");
            System.out.println(" 4- Mostrar Libros");
            System.out.println(" 5- Mostrar Autor por Nombre");
            System.out.println(" 6- Mostrar Libro por ISBN");
            System.out.println(" 7- Mostrar Libro por Titulo");
            System.out.println(" 8- Mostrar Libro por Autor");
            System.out.println(" 9 - Mostrar Libro Por Editorial");
            System.out.println(" 0- Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    libroService.crearLibro(cargarTitulo(), cargarAnio(), cargarEjemplares(), cargarEjemplaresPrestados(),
                            cargarEjemplaresRestantes(), false);
                    break;
                case 2:
                    autorService.crearAutor(cargarNombre(), false);
                    break;
                case 3:
                    editorialService.crearEditorial(cargarNombre(), false);
                    break;

                case 4:
                    libroService.imprimirLibros();
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del autor a buscar");
                    autorService.imprimirAutorPorNombre(sc.next());
                    break;
                case 6:
                    System.out.println("Ingrese el ISBN a buscar");
                    libroService.imprimirLibroPorISBN(sc.nextInt());
                    break;
                case 7:
                    System.out.println("Ingrese el titulo a buscar");
                    libroService.imprimirLibroPorTitulo(sc.next());
                    break;
                case 8:
                    System.out.println("Ingrese el autor a buscar");
                    libroService.buscarLibroPorAutor(sc.next());
                    break;
                case 9:
                    System.out.println("Ingrese la editorial a buscar");
                    libroService.buscarLibroPorEditorial(sc.next());
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("Desea realizar una nueva consulta o gestion ???:SI/NO");
            respuesta = sc.next();
            respuesta = respuesta.toUpperCase();
            limpiarPantalla();
        } while ("SI".equals(respuesta));

    }

    public void limpiarPantalla() throws AWTException {
        //Dejo esre metodo para ir borrando la consola.. y que no sea un desorden.
        Robot pressbot = new Robot();
        pressbot.setAutoDelay(30); // Tiempo de espera antes de borrar
        pressbot.keyPress(17); // Orden para apretar CTRL key
        pressbot.keyPress(76);// Orden para apretar L key
        pressbot.keyRelease(17); // Orden para soltar CTRL key
        pressbot.keyRelease(76); // Orden para soltar L key

    }

    public String cargarTitulo() throws Exception {
        String tituloI;
        System.out.println("Ingrese el titulo");
        tituloI = sc.next();
        return tituloI;
    }

    public Integer cargarAnio() {
        System.out.println("Ingrese el anio");
        Integer anioI = sc.nextInt();
        return anioI;
    }

    public Integer cargarEjemplares() {
        System.out.println("Ingrese los ejemplares");
        Integer ejemplaresI = sc.nextInt();
        return ejemplaresI;
    }

    public Integer cargarEjemplaresPrestados() {
        System.out.println("Ingrese los ejemplares prestados");
        Integer ejemplaresPrestadosI = sc.nextInt();
        return ejemplaresPrestadosI;
    }

    public Integer cargarEjemplaresRestantes() {
        System.out.println("Ingrese los ejemplares restantes");
        Integer ejemplaresRestantesI = sc.nextInt();
        return ejemplaresRestantesI;
    }

    public String cargarNombre() {
        System.out.println("Ingrese el nombre");
        String nombreI = sc.next();
        return nombreI;
    }

    /*public Usuario encontrarUsuario() throws Exception {
        System.out.println("Ingrese el ID del usuario");
        String idUsuario = sc.next();
        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        return usuario;
    }*/
    public String buscarPorCorreo() {
        System.out.println("Ingrese el correo de la persona ");
        String correoI = sc.next();
        return correoI;
    }

    public String ingresarIdUsuario() {
        System.out.println("Ingrese el ID del usuario");
        String idUsuario = sc.next();
        return idUsuario;
    }

    public String cargarIdMascot() {
        System.out.println("Ingrese el Id Mascota");
        String idMascota = sc.next();
        return idMascota;
    }
}
