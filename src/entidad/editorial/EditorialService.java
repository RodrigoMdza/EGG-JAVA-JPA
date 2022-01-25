package entidad.editorial;

import Persistencia.EditorialDao;
import java.util.Scanner;

public class EditorialService {

    private final EditorialDao editorialDao = new EditorialDao();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Editorial crearEditorial(String nombre, Boolean alta) {
        Editorial editorial = new Editorial();
        try {
            editorial.setNombre(nombre);
            editorial.setAlta(false);
            editorial.setId((int) Math.random() * 1000);
            editorialDao.guardarEditorial(editorial);
            return editorial;
        } catch (Exception e) {
            System.out.println("No se guardo la editorial de forma correcta" + e.getMessage());
            return null;
        }
    }
}
