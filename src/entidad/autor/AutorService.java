package entidad.autor;

import Persistencia.AutorDao;

public class AutorService {

    private final AutorDao autorDao = new AutorDao();

    public Autor crearAutor(String nombre, Boolean alta) {
        Autor autor = new Autor();
        try {
            autor.setId((int) Math.random() * 1000);
            autor.setNombre(nombre);
            autor.setAlta(alta);

            autorDao.guardarAutor(autor);
            return autor;
        } catch (Exception e) {
            System.out.println("No se guardo el autor de forma correcta" + e.getMessage());
            return null;
        }
    }

    public void imprimirAutorPorNombre(String nombre) throws Exception {
        System.out.println(autorDao.buscarAutorPorNombre(nombre));
    }
}
