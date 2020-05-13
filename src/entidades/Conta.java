package entidades;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Conta {

    protected Integer numero;
    protected String agencia;
    protected Double saldo;
    protected Date abertura;

    protected Pessoa titular;

    public Conta(Integer numero, String agencia, Double saldo, Date abertura, Pessoa titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.abertura = abertura;
        this.titular = titular;
    }

    public abstract boolean sacar(double valor);

    public abstract boolean depositar(double valor);

    public abstract boolean tranferirDinheiro(double valor, Conta destino);

    @Override
    public String toString() {
        return "Conta Nº " + numero + "\n" +
                "Agência " + agencia + "\n" +
                "Saldo R$ " + new DecimalFormat("#.00").format(saldo) + "\n" +
                "Abertura " + new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(abertura) + "\n" +
                "Titular " + titular.getNome() + "\n";
    }
}
