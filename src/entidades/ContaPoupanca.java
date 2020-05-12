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
    public String toString() {
        return "Conta Poupança Nº " + getNumero() + "\n" +
                "Agência " + getAgencia() + "\n" +
                "Saldo R$ " + getSaldo() + "\n" +
                "Abertura " + new SimpleDateFormat("dd/MM/yyyy").format(getAbertura()) + "\n" +
                "Titular " + getTitular() + "\n" +
                "Porcentagem de Rendimento " + porcentagemRendimento + "\n" +
                "Dia do Rendimento " + diaRedimento + "\n";
    }
}
