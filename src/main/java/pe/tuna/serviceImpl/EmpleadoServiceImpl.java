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
@Transactional(readOnly = false)
// Por defecto la anotacion Transactional viene con lo siguiente:
// Ambito: PROPAGATION_REQUIRED, propagation = Propagation.PROPAGATION_REQUIRED
// y el ReadOnly en false
// True =  solo se permite realzar consultas con la base de datos
// False = Permite realizar todas la operaciones con la base de datos: create, read, update, delete
public class EmpleadoServiceImpl implements EmpleadoService {

    final static Logger logger = Logger.getLogger(EmpleadoServiceImpl.class);

    @Autowired
    EmpleadoDAO empleadoDAO;


    @Transactional(noRollbackFor = {NumberFormatException.class, ArithmeticException.class})
    public boolean guardar(Empleado empleado) {
        boolean rpta = false;
        Integer id = (Integer) empleadoDAO.guardar(empleado);
        logger.debug("Id del nuevo empleado: " + id);
        if (id > 0) {
            rpta = true;
        } else {
            rpta = false;
        }

        this.actualizarEmpleadoTop();
        return rpta;
    }

    private void actualizarEmpleadoTop() {
        int numero = Integer.valueOf("10.gg");
        logger.info("numero: " + numero);
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
