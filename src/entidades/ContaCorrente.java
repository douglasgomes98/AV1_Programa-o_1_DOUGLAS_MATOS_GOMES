package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaCorrente extends Conta {

    private Double taxaAdministracao;
    private Double limite;

    public ContaCorrente(Integer numero, String agencia, Double saldo, Date abertura, Pessoa titular, Double taxaAdministracao, Double limite) {
        super(numero, agencia, saldo, abertura, titular);
        this.taxaAdministracao = taxaAdministracao;
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Conta Corrente Nº " + getNumero() + "\n" +
                "Agência " + getAgencia() + "\n" +
                "Saldo R$ " + getSaldo() + "\n" +
                "Abertura " + new SimpleDateFormat("dd/MM/yyyy").format(getAbertura()) + "\n" +
                "Titular " + getTitular() + "\n" +
                "Taxa de Administração " + taxaAdministracao + "\n" +
                "Limite " + limite + "\n";
    }
}
