package pe.tuna.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.tuna.dao.LibroDao;
import pe.tuna.entidad.Curso;
import pe.tuna.entidad.Libro;

import java.io.Serializable;
import java.util.List;

public class PruebaBeans implements Serializable {

    public static ApplicationContext context;

    private static final long serialVersionUID = -457605817537125688L;

    public static void main(String[] args) {

        context = new ClassPathXmlApplicationContext("applicationContext.xml");


        Curso curso = (Curso) context.getBean("curso");
        curso.setCodigo("0001");
        System.out.println(curso.toString());

        Curso curso2 = (Curso) context.getBean("curso");
        System.out.println(curso2.toString());

        Libro libro = new Libro();
        libro.setTitulo("Libro de spring Intermedio - Miguel Ch.");

        LibroDao libroDao = (LibroDao) context.getBean("libroDaoImpl");

        if (libroDao.saveOrUpdate(libro)){
            System.out.println("Datos registrados");
        }else{
            System.out.println("No se puede registrar los datos de un libro ya existente");
        }

        List<Libro> lstLibro = libroDao.getLstLibros();
        System.out.println("Cantidad de libros registrados: " + lstLibro.size());
        for (Libro item: lstLibro) {
            System.out.println("ID: " + item.getId() + ", titulo: " + item.getTitulo());
        }

        Libro item = libroDao.getLibro(1);
        System.out.println("Libro recuperado: " + item.getId() + ", Titulo: " + item.getTitulo());

    }
}
