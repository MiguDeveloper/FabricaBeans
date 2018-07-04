package pe.tuna.dao;

import pe.tuna.entidad.Empleado;

import java.io.Serializable;
import java.util.List;

public interface EmpleadoDAO {
    public Serializable guardar(Empleado empleado);

    public Empleado getByIdEmpleado(int id);

    public boolean updateEmpleado(Empleado empleado);

    public List<Empleado> getLstEmpleado();

    public boolean deleteEmpleado(Empleado empleado);
}
