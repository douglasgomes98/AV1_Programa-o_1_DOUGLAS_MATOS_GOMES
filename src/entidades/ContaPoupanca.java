package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaPoupanca extends Conta {

    private Double porcentagemRendimento;
    private Integer diaRedimento;

    public ContaPoupanca(Integer numero, String agencia, Double saldo, Date abertura, Pessoa titular, Double porcentagemRendimento, Integer diaRedimento) {
        super(numero, agencia, saldo, abertura, titular);
        this.porcentagemRendimento = porcentagemRendimento;
        this.diaRedimento = diaRedimento;
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
    public String toString() {
        return "Conta Poupança Nº " + numero + "\n" +
                "Agência " + agencia + "\n" +
                "Saldo R$ " + saldo + "\n" +
                "Abertura " + new SimpleDateFormat("dd/MM/yyyy").format(abertura) + "\n" +
                "Titular " + titular.getNome() + "\n" +
                "Porcentagem de Rendimento " + porcentagemRendimento + "\n" +
                "Dia do Rendimento " + diaRedimento + "\n";
    }
}
