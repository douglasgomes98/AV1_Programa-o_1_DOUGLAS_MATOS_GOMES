package programa;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;
import entidades.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Aplicacao {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        List<? super Conta> contas = new ArrayList<>();
        boolean process = true;

        String menuPrincipal = "Escolha uma opção abaixo: \n" +
                "1 - Adicionar uma conta corrente. \n" +
                "2 - Adiconar uma conta poupanca \n" +
                "3 - Listar contas cadastradas. \n" +
                "4 - Depositar dinheiro \n" +
                "5 - Sacar dinheiro \n" +
                "6 - Transferência de dinheiro. \n" +
                "7 - Encerrar o programa.";

        do {
            Integer option = inputValue(Integer.class, "Menu principal", menuPrincipal);

            switch (option) {
                case 1:
                    contas.add(adicionarContaCorrente());
                    break;
                case 2:
                    contas.add(adicionarContaPoupanca());
                    break;
                case 3:
                    listarContas(contas);
                    break;
                case 7:
                    process = false;
            }
        } while (process);
    }

    public static <T> T inputValue(Class source, String title, String message) {
        boolean error = false;
        Number valor = null;

        do {
            try {
                String value = JOptionPane.showInputDialog(null, message, title, 3);

                if (value == null || value.isEmpty()) {
                    throw new NullPointerException();
                }

                try {
                    if (source.equals(Double.class)) {
                        valor = Double.parseDouble(value);
                    } else if (source.equals(Integer.class)) {
                        valor = (int) Double.parseDouble(value);
                    } else {
                        return (T) value;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Entrada inválida.", "Alerta", 2);
                }

                error = false;
            } catch (NumberFormatException | ClassCastException | NullPointerException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Entrada inválida.", "Alerta", 2);
                error = true;
            }

        } while (valor == null);

        return (T) valor;
    }

    public static ContaCorrente adicionarContaCorrente() {
        Integer numero = inputValue(Integer.class, "Cadastro de Conta Corrente: ", "Número da Conta");
        String agencia = inputValue(String.class, "Cadastro de Conta Corrente: ", "Número da Agência");
        Double saldo = inputValue(Double.class, "Cadastro de Conta Corrente: ", "Saldo inicial");
        Date abertura = new Date();
        Pessoa titular = new Pessoa(inputValue(String.class, "Cadastro de Conta Corrente: ", "Nome do Títular"));
        Double taxaAdministracao = inputValue(Double.class, "Cadastro de Conta Corrente: ", "Taxa de Administração");
        Double limite = inputValue(Double.class, "Cadastro de Conta Corrente: ", "Limite");

        ContaCorrente contaCorrente = new ContaCorrente(numero, agencia, saldo, abertura, titular, taxaAdministracao, limite);

        return contaCorrente;
    }

    public static ContaPoupanca adicionarContaPoupanca() {
        Integer numero = inputValue(Integer.class, "Cadastro de Conta Poupança: ", "Número da Conta");
        String agencia = inputValue(String.class, "Cadastro de Conta Poupança: ", "Número da Agência");
        Double saldo = inputValue(Double.class, "Cadastro de Conta Poupança: ", "Saldo inicial");
        Date abertura = new Date();
        Pessoa titular = new Pessoa(inputValue(String.class, "Cadastro de Conta Poupança: ", "Nome do Títular"));
        Double porcentagemRedimento = inputValue(Double.class, "Cadastro de Conta Poupança: ", "Porcentagem de Rendimento");
        Integer diaRedimento = inputValue(Integer.class, "Cadastro de Conta Poupança: ", "Dia de Rendimento");

        ContaPoupanca contaPoupanca = new ContaPoupanca(numero, agencia, saldo, abertura, titular, porcentagemRedimento, diaRedimento);

        return contaPoupanca;
    }

    public static void listarContas(List<? super Conta> lista) {
        String str = lista.toString().replace("[", "").replace("]", "").replace(", ", "");
        JOptionPane.showMessageDialog(null, str, "Contas Cadastradas", 3);
    }

}
