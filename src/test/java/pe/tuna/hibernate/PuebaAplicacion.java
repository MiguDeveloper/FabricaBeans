package pe.tuna.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pe.tuna.CrudEmpleado;
import pe.tuna.config.AplicacionConf;

public class PuebaAplicacion {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = null;
        try {
            context = new AnnotationConfigApplicationContext(AplicacionConf.class);
            CrudEmpleado application = context.getBean(CrudEmpleado.class);

            application.procesarCrud();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}
