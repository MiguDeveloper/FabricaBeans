package pe.tuna.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cuenta")
public class Cuenta {
    private int id;
    private Cliente cliente;
    private String codigo;
    private double saldoContable;
    private Banco banco;

    @Autowired
    private TipoCuenta tipoCuenta;


}
