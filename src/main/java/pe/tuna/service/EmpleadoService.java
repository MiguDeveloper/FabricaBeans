package pe.tuna.service;

import pe.tuna.entidad.Empleado;

import java.util.List;

public interface EmpleadoService {
    public boolean guardar(Empleado empleado);

    public Empleado getByIdEmpleado(int id);

    public boolean updateEmpleado(Empleado empleado);

    public List<Empleado> getLstEmpleado();

    public boolean deleteEmpleado(Empleado empleado);
}
