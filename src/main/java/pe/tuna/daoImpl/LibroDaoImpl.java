package pe.tuna.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.tuna.dao.ConexionJdbc;
import pe.tuna.dao.LibroDao;
import pe.tuna.entidad.Libro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("libroDaoImpl")
public class LibroDaoImpl implements LibroDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ConexionJdbc conexionJdbc;

    public boolean saveOrUpdate(Libro libro) {
        boolean respuesta = false;
        try {
            jdbcTemplate = conexionJdbc.obtenerTemplate();
            if (libro.getId() > 0) {
                String sql = "UPDATE libro SET titulo = ? WHERE id = ?";
                jdbcTemplate.update(sql, libro.getTitulo(), libro.getId());
            } else {
                // Hacemos el insert
                String sql = "INSERT INTO libro(titulo) VALUES (?) ";
                jdbcTemplate.update(sql, libro.getTitulo());
            }
            respuesta = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return respuesta;
    }

    public boolean delete(int idLibro) {
        boolean respuesta = false;

        try {
            String sql = "DELETE FROM libro WHERE id = ?";
            jdbcTemplate = conexionJdbc.obtenerTemplate();
            jdbcTemplate.update(sql, idLibro);
            respuesta = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return respuesta;
    }

    public Libro getLibro(int idLibro) {
        Libro libro;
        try {
            String sql = "SELECT id, titulo FROM libro WHERE id = " + idLibro;
            libro = jdbcTemplate.query(sql, new ResultSetExtractor<Libro>() {
                public Libro extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    if (resultSet.next()) {
                        Libro libro = new Libro();
                        libro.setId(resultSet.getInt("id"));
                        libro.setTitulo(resultSet.getString("titulo"));

                        return libro;
                    }
                    return null;
                }
            });
        } catch (Exception ex) {
            libro = null;
        }

        return libro;
    }

    public List<Libro> getLstLibros() {
        List<Libro> lstLibros;

        try {
            String sql = "SELECT id, titulo FROM libro";
            jdbcTemplate = conexionJdbc.obtenerTemplate();
            lstLibros = jdbcTemplate.query(sql, new RowMapper<Libro>() {
                public Libro mapRow(ResultSet resultSet, int i) throws SQLException {
                    Libro libro = new Libro();
                    libro.setId(resultSet.getInt("id"));
                    libro.setTitulo(resultSet.getString("titulo"));

                    return libro;
                }
            });
        } catch (Exception ex) {
            lstLibros = new ArrayList<Libro>();
        }

        return lstLibros;

    }
}
