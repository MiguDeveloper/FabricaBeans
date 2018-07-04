package pe.tuna.entidad;

import org.springframework.stereotype.Component;

@Component("banco")
public class Banco {
    private int id = 0;
    private String descripcion = "<Banco anonimo>";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
