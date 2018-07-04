package pe.tuna.entidad;

import javax.persistence.*;

@Entity
@Table(name = "empleado")

@NamedNativeQueries({
        @NamedNativeQuery(name="empleado.nativeBuscarTodos", query = "SELECT id,nombres,apellidos,cargo,salario FROM empleado"),
        @NamedNativeQuery(name = "empleado.nativeBuscarPorId", query = "SELECT id,nombres,apellidos,cargo,salario FROM empleado WHERE id = :pId")
})
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "nombres", length = 100)
    private String nombres;

    @Column(name = "apellidos", length = 150)
    private String apellidos;

    @Column(name = "cargo", length = 70)
    private String cargo;

    @Column(name = "salario")
    private double salario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
