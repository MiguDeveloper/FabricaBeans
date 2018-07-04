package pe.tuna.entidad;

import org.springframework.stereotype.Component;

// El nombre que toma por defecto es el nombre de la clase en minuscula el primer caracter
@Component("cliente")
public class Cliente {
    private int id = 0;
    private String nombre = "<Sin informacion>";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
