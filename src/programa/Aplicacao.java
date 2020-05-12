package programa;

import entidades.Conta;
import entidades.Pessoa;

import java.util.Date;

public class Aplicacao {

    public static void main(String[] args) {

        Conta conta = new Conta(1, "250", 599.00, new Date(), new Pessoa("Douglas"));
        Conta conta2 = new Conta(2, "251", 451.35, new Date(), new Pessoa("Matheus"));

        System.out.println(conta.getSaldo());

        conta.deposita(1000.00);
        System.out.println(conta.getSaldo());

        conta.saca(500.00);
        System.out.println(conta.getSaldo());

        conta.saca(500.00);
        System.out.println(conta.getSaldo());

        conta.saca(500.00);
        System.out.println(conta.getSaldo());

        conta.saca(500.00);
        System.out.println(conta.getSaldo());

        conta.deposita(200.00);
        System.out.println(conta.getSaldo());

        System.out.println(conta2.getSaldo());
        conta.tranferirDinheiro(100.00, conta2);

        System.out.println(conta.getSaldo());
        System.out.println(conta2.getSaldo());
    }
}
