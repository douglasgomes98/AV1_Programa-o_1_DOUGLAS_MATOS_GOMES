package programa;

import entidades.Conta;
import entidades.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>();
        boolean process = true;

        String menuPrincipal = "1 - Adicionar uma conta corrente. \n" +
                "2 - Adiconar uma conta poupanca \n" +
                "3 - Depositar dinheiro \n" +
                "4 - Sacar dinheiro \n" +
                "5 - Transferência de dinheiro. \n" +
                "6 - Encerrar o programa.";
//        adicionarContaCorrente();
        Double numero = 0.0;
        numero = inputValue(numero, "Número da Conta", "Cadastro de Conta Corrente");
        System.out.println(numero);
//        do {
//            try {
//                int option = Integer.parseInt(JOptionPane.showInputDialog(null, menuPrincipal, "Menu de Opções", 3));
//
//                switch (option) {
//                    case 1:
//                        adicionarContaCorrente();
//                    case 6:
//                        process = false;
//                }
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Entrada inválida.");
//            }
//
//        } while (process);
//        ContaCorrente conta = new ContaCorrente(1, "250", 100.00, new Date(), new Pessoa("Douglas"), 25.00, 15000.00);
//        System.out.println(conta.getValorImposto());
//
//        System.out.println(JOptionPane.showInputDialog(null, "Némuro do Cadastro: ", "Cadastro", 3));
//
//        JOptionPane.showMessageDialog(null, "teste");
//
//
//        JOptionPane.showMessageDialog(null, "Extrato"+"\n"+"1º Conta Corrente");
    }

    public static void adicionarContaCorrente() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Cadastro de Conta Corrente: ", "Número da Conta", 3));
        String agencia = JOptionPane.showInputDialog(null, "Cadastro de Conta Corrente: ", "Número da Agência", 3);
        double saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Cadastro de Conta Corrente: ", "Saldo inicial", 3));
        Date abertura = new Date();
        Pessoa titular = new Pessoa(JOptionPane.showInputDialog(null, "Cadastro de Conta Corrente: ", "Nome do Títular", 3));
        double taxaAdministracao = Double.parseDouble(JOptionPane.showInputDialog(null, "Cadastro de Conta Corrente: ", "Taxa de Administração", 3));
        double limite = Double.parseDouble(JOptionPane.showInputDialog(null, "Cadastro de Conta Corrente: ", "Limite", 3));
    }

    public static <T> T inputValue(T source, String message, String title) {
        boolean error = false;
        do {
            try {
                String value = JOptionPane.showInputDialog(null, message, title, 3);
                System.out.println(source.getClass());
                System.out.println(value);

                if (source == null || value == "" || value.isEmpty()) {
                    throw new NullPointerException();
                }

                if (source.getClass().equals(String.class)) {
                    System.out.println("String");

                    return (T) value;
                }

                if (source.getClass().equals(Double.class)) {
                    System.out.println("Double");
                    Double number = 0.0;
                    number = Double.parseDouble(value);

                    return (T) number;
                }

                if (source.getClass().equals(Integer.class)) {
                    System.out.println("Integer");
                    Integer number = 0;
                    number = Integer.parseInt(value);

                    return (T) number;
                }

                error = false;
            } catch (NumberFormatException | ClassCastException | NullPointerException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Entrada inválida.");
                error = true;
            }

        } while (error != false);

        return source;
    }
}
