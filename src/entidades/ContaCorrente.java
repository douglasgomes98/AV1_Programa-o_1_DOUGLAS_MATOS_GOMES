package entidades;

import interfaces.Tributavel;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
// ContaPoupanca herda da classe abstrata Conta implementacao da interface Tributavel
public class ContaCorrente extends Conta implements Tributavel {

    private final Double taxaAdministracao;
    private final Double limite;

    public ContaCorrente(Integer numero, String agencia, Double saldo, Date abertura, Pessoa titular, Double taxaAdministracao, Double limite) {
        super(numero, agencia, saldo, abertura, titular);
        this.taxaAdministracao = taxaAdministracao;
        this.limite = limite;
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
    public double getValorImposto() {
        return saldo * 0.01;
    }

    @Override
    public String toString() {
        String str = saldo > 0 ? new DecimalFormat("#.00").format(saldo) : "0.00";
        return "Conta Corrente Nº " + numero + "\n" +
                "Agência " + agencia + "\n" +
                "Saldo R$ " + str + "\n" +
                "Abertura " + new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(abertura) + "\n" +
                "Titular " + titular.getNome() + "\n" +
                "Taxa de Administração " + taxaAdministracao + "\n" +
                "Limite " + limite + "\n\n";
    }

}
