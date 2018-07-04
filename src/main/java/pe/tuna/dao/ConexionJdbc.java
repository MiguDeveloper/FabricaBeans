package pe.tuna.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository("conexionJdbc")
public class ConexionJdbc {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public ConexionJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate obtenerTemplate(){
        if (jdbcTemplate == null){
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }
}
