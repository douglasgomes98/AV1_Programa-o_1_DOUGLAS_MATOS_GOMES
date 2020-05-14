package entidades;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// ContaPoupanca herda da classe abstrata Conta
public class ContaPoupanca extends Conta {

    private final Double porcentagemRendimento;
    private final Integer diaRedimento;

    public ContaPoupanca(Integer numero, String agencia, Double saldo, Date abertura, Pessoa titular, Double porcentagemRendimento, Integer diaRedimento) {
        super(numero, agencia, saldo, abertura, titular);
        this.porcentagemRendimento = porcentagemRendimento;
        this.diaRedimento = diaRedimento;
    }

    // Sobrescrita dos metodos da classe abstrata Conta
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
        if (valor <= 0) {
            return false;
        }

        saldo += valor;

        return true;
    }

    @Override
    public boolean tranferirDinheiro(double valor, Conta destino) {
        if (valor <= 0 || valor > saldo || this == destino) {
            return false;
        }

        saldo -= valor;

        destino.depositar(valor);

        return true;
    }

    @Override
    public String toString() {
        String str = saldo > 0 ? new DecimalFormat("#.00").format(saldo) : "0.00";
        return "Conta Poupança Nº " + numero + "\n" +
                "Agência " + agencia + "\n" +
                "Saldo R$ " + str + "\n" +
                "Abertura " + new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(abertura) + "\n" +
                "Titular " + titular.getNome() + "\n" +
                "Porcentagem de Rendimento " + porcentagemRendimento + "\n" +
                "Dia do Rendimento " + diaRedimento + "\n\n";
    }
}
