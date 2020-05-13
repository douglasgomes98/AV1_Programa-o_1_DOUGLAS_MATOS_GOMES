package entidades;

import interfaces.Tributavel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaCorrente extends Conta implements Tributavel {

    private Double taxaAdministracao;
    private Double limite;

    public ContaCorrente(Integer numero, String agencia, Double saldo, Date abertura, Pessoa titular, Double taxaAdministracao, Double limite) {
        super(numero, agencia, saldo, abertura, titular);
        this.taxaAdministracao = taxaAdministracao;
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor < 0 || valor > this.saldo) {
            return false;
        }

        saldo -= valor;

        return true;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor < 0) {
            return false;
        }

        saldo += valor;

        return true;
    }

    @Override
    public boolean tranferirDinheiro(double valor, Conta destino) {
        if (valor < 0 || valor > saldo || this == destino) {
            return false;
        }

        saldo -= valor;

        destino.depositar(valor);

        return true;
    }

    @Override
    public double getValorImposto() {
        return saldo * 0.01;
    }

    @Override
    public String toString() {
        return "Conta Corrente Nº " + numero + "\n" +
                "Agência " + agencia + "\n" +
                "Saldo R$ " + saldo + "\n" +
                "Abertura " + new SimpleDateFormat("dd/MM/yyyy").format(abertura) + "\n" +
                "Titular " + titular.getNome() + "\n" +
                "Taxa de Administração " + taxaAdministracao + "\n" +
                "Limite " + limite + "\n";
    }

}
