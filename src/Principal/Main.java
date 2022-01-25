package Principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

    
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LIBRERIAPU");
        EntityManager em = emf.createEntityManager();
        Menu nuevaEjecucion = new Menu();
        nuevaEjecucion.menu();
    }
    
}
