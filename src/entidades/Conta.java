package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conta {

    private Integer numero;
    private String agencia;
    private Double saldo;
    private Date abertura;

    private Pessoa titular;

    public Conta(Integer numero, String agencia, Double saldo, Date abertura, Pessoa titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.abertura = abertura;
        this.titular = titular;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Date getAbertura() {
        return abertura;
    }


    public Pessoa getTitular() {
        return titular;
    }

    public boolean saca(double valor) {
        if (valor < 0 || valor > this.saldo) {
            return false;
        }

        this.saldo -= valor;

        return true;
    }

    public boolean deposita(double valor) {
        if (valor < 0) {
            return false;
        }

        this.saldo += valor;

        return true;
    }

    public boolean tranferirDinheiro(double valor, Conta destino) {
        if (valor < 0 || valor > this.saldo) {
            return false;
        }

        this.saldo -= valor;

        destino.deposita(valor);

        return true;
    }

    @Override
    public String toString() {
        return "Conta Nº " + numero + "\n" +
                "Agência " + agencia + "\n" +
                "Saldo R$ " + saldo + "\n" +
                "Abertura " + new SimpleDateFormat("dd/MM/yyyy").format(abertura) + "\n" +
                "Titular " + titular.getNome() + "\n";
    }
}
