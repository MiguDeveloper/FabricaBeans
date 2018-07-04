package pe.tuna.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.tuna.dao.EmpleadoDAO;
import pe.tuna.entidad.Empleado;
import pe.tuna.service.EmpleadoService;

import java.io.Serializable;
import java.util.List;

@Service("empleadoService")
@Transactional(readOnly = true)
public class EmpleadoServiceImpl implements EmpleadoService {

    final static Logger logger = Logger.getLogger(EmpleadoServiceImpl.class);

    @Autowired
    EmpleadoDAO empleadoDAO;

    public boolean guardar(Empleado empleado) {
        Integer id = (Integer) empleadoDAO.guardar(empleado);
        logger.debug("Id del nuevo empleado: " + id);
        if (id > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Empleado getByIdEmpleado(int id) {
        logger.debug("Buscar empleado por id: " + id);
        return empleadoDAO.getByIdEmpleado(id);
    }

    public boolean updateEmpleado(Empleado empleado) {
        logger.debug("Actualizando el empleado con id: " + empleado.getId());
        return empleadoDAO.updateEmpleado(empleado);
    }

    public List<Empleado> getLstEmpleado() {
        logger.debug("Obtenemos la lista de empleados de la empresa");
        return empleadoDAO.getLstEmpleado();
    }

    public boolean deleteEmpleado(Empleado empleado) {
        logger.debug("Eliminado el empleado con id: " + empleado.getId());
        return empleadoDAO.deleteEmpleado(empleado);
    }
}
