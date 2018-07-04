package pe.tuna.dao;

import pe.tuna.entidad.Libro;

import java.util.List;

public interface LibroDao {
    public boolean saveOrUpdate(Libro libro);
    public boolean delete(int idLibro);
    public Libro getLibro(int idLibro);
    public List<Libro> getLstLibros();
}
