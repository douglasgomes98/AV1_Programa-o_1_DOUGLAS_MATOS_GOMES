package entidades;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// classe abstrata de conta
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

    // metodos abstratos
    public abstract boolean sacar(double valor);

    public abstract boolean depositar(double valor);

    public abstract boolean tranferirDinheiro(double valor, Conta destino);

    @Override
    public String toString() {
        String str = saldo > 0 ? new DecimalFormat("#.00").format(saldo) : "0.00";
        return "Conta Nº " + numero + "\n" +
                "Agência " + agencia + "\n" +
                "Saldo R$ " + str + "\n" +
                "Abertura " + new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(abertura) + "\n" +
                "Titular " + titular.getNome() + "\n";
    }
}
