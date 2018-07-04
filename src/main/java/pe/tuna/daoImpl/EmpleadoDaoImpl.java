package pe.tuna.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.tuna.dao.EmpleadoDAO;
import pe.tuna.entidad.Empleado;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository("empleadoDao")
public class EmpleadoDaoImpl implements EmpleadoDAO {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public Serializable guardar(Empleado empleado) {
        return getSession().save(empleado);
    }

    public Empleado getByIdEmpleado(int id) {
        Empleado empleado=null;
        try {
            Query query = getSession().getNamedNativeQuery("empleado.nativeBuscarPorId");
            query.setParameter("pId",id);
            Object[] resultado = (Object[]) query.getSingleResult();

            empleado = new Empleado();
            empleado.setId(Integer.valueOf(String.valueOf(resultado[0])));
            empleado.setNombres(String.valueOf(resultado[1]));
            empleado.setApellidos(String.valueOf((resultado[2])));
            empleado.setCargo(String.valueOf(resultado[3]));
            empleado.setSalario(Double.valueOf(String.valueOf(resultado[4])));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return empleado;
    }

    public boolean updateEmpleado(Empleado empleado) {
        try {
            getSession().update(empleado);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Empleado> getLstEmpleado() {
        List<Empleado> lstEmpleado;
        try{
            Query query = getSession().getNamedNativeQuery("empleado.nativeBuscarTodos");
            List<Object[]> lstRespuesta = (List<Object[]>) query.getResultList();

            lstEmpleado = new ArrayList<Empleado>();
            for (Object[] rpta : lstRespuesta){
                Empleado empleado = new Empleado();
                empleado.setId(Integer.valueOf(String.valueOf(rpta[0])));
                empleado.setNombres(String.valueOf(rpta[1]));
                empleado.setApellidos(String.valueOf(rpta[2]));
                empleado.setCargo(String.valueOf(rpta[3]));
                empleado.setSalario(Double.valueOf(String.valueOf(rpta[4])));

                lstEmpleado.add(empleado);
            }
        }catch(Exception e){
            lstEmpleado = new ArrayList<Empleado>();
        }

        return lstEmpleado;
    }

    public boolean deleteEmpleado(Empleado empleado) {
        try {
            getSession().delete(empleado);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
