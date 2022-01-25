package entidad.autor;

import com.sun.istack.internal.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {

    @Id
    @GeneratedValue
    private Integer Id;
    @NotNull
    private String nombre;
    @NotNull
    private Boolean alta;

    public Autor() {
    }

    public Autor(Integer Id, String nombre, Boolean alta) {
        this.Id = Id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Autor{" + "Id=" + Id + ", nombre=" + nombre + ", alta=" + alta + '}';
    }

}
