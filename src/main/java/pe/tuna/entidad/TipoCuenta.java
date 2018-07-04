package pe.tuna.entidad;

import org.springframework.stereotype.Component;

@Component("tipoCuenta")
public class TipoCuenta {
    private int id;
    private String descripcion = "<Sin tipo>";

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
