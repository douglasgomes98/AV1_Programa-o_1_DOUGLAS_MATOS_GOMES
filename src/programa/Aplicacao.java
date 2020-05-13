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
        contas.add(new ContaCorrente(1, "1", 1.0, new Date(), new Pessoa("1"), 0.01, 1.0));
        contas.add(new ContaPoupanca(2, "2", 2.0, new Date(), new Pessoa("2"), 2.0, 2));
        contas.add(new ContaCorrente(3, "1", 1.0, new Date(), new Pessoa("1"), 0.01, 1.0));

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
                    contas.add(adicionarContaCorrente(contas.size()));
                    break;
                case 2:
                    contas.add(adicionarContaPoupanca(contas.size()));
                    break;
                case 3:
                    listarContas(contas);
                    break;
                case 4:
                    Conta contaSelecionada = selecionarConta(contas);
                    depositarDinheiro(contaSelecionada);
                    break;
                case 7:
                    process = false;
                    break;
            }
        } while (process);
    }

    public static <T> T inputValue(Class source, String title, String message) {
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

            } catch (NumberFormatException | ClassCastException | NullPointerException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Entrada inválida.", "Alerta", 2);
            }

        } while (valor == null);

        return (T) valor;
    }

    public static ContaCorrente adicionarContaCorrente(Integer quantidadeContas) {
        Integer numero = ++quantidadeContas;
        String agencia = inputValue(String.class, "Cadastro de Conta Corrente: ", "Número da Agência");
        Double saldo = inputValue(Double.class, "Cadastro de Conta Corrente: ", "Saldo inicial");
        Date abertura = new Date();
        Pessoa titular = new Pessoa(inputValue(String.class, "Cadastro de Conta Corrente: ", "Nome do Títular"));
        Double taxaAdministracao = inputValue(Double.class, "Cadastro de Conta Corrente: ", "Taxa de Administração");
        Double limite = inputValue(Double.class, "Cadastro de Conta Corrente: ", "Limite");

        ContaCorrente contaCorrente = new ContaCorrente(numero, agencia, saldo, abertura, titular, taxaAdministracao, limite);

        return contaCorrente;
    }

    public static ContaPoupanca adicionarContaPoupanca(Integer quantidadeContas) {
        Integer numero = ++quantidadeContas;
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
        JOptionPane.showMessageDialog(null, str.isEmpty() ? "Nenhuma conta cadastrada!" : str, "Contas Cadastradas", 3);
    }

    public static Conta selecionarConta(List<? super Conta> contas) {
        boolean error = false;
        Integer idConta = null;

        do {
            idConta = inputValue(Integer.class, "Selecione uma conta", "Digite o número de uma conta");
            System.out.println(idConta);
            if (idConta > 0 && idConta <= contas.size()) {
                error = false;
            } else {
                JOptionPane.showMessageDialog(null, "Entrada inválida.", "Alerta", 2);
                error = true;
            }

        } while (error != false);

        Conta contaSelecionada = (Conta) contas.get(--idConta);
        return contaSelecionada;
    }

    public static void depositarDinheiro(Conta conta) {
        boolean error = false;
        do {
            Double valor = inputValue(Double.class, "Depositar Dinheiro", "Digite o valor do deposito.");
            boolean sucesso = conta.depositar(valor);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Depositar Dinheiro.", 3);
                error = false;
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade inválida.", "Alerta", 2);
                error = true;
            }
        } while (error != false);
    }
}
