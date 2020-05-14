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
        // Lista de contas genericas onde eh possivel adicionar qualquer classe que eh um super tipo de conta
        List<? super Conta> contas = new ArrayList<>();
        boolean process = true;

//        contas.add(new ContaCorrente(1, "1", 1.0, new Date(), new Pessoa("Douglas Matos Gomes"), 0.01, 1.0));
//        contas.add(new ContaPoupanca(2, "2", 22.0, new Date(), new Pessoa("Matheus Carvalho de Almeida"), 2.0, 2));
//        contas.add(new ContaCorrente(3, "1", 1.0, new Date(), new Pessoa("Samuel Araujo Delgado"), 0.01, 1.0));

        String menuPrincipal = "Escolha uma opção abaixo: \n" +
                "1 - Adicionar uma conta corrente. \n" +
                "2 - Adiconar uma conta poupanca \n" +
                "3 - Listar contas cadastradas. \n" +
                "4 - Depositar dinheiro \n" +
                "5 - Sacar dinheiro \n" +
                "6 - Transferência de dinheiro. \n" +
                "7 - Encerrar o programa.";
        // do-While para verificar a opcao de escolha do menu
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
                    Conta contaSelecionada = selecionarConta(contas, false);
                    depositarDinheiro(contaSelecionada);
                    break;
                case 5:
                    Conta contaSelect = selecionarConta(contas, false);
                    sacarDinheiro(contaSelect);
                    break;
                case 6:
                    Conta contaSelec = selecionarConta(contas, false);
                    transferirDinheiro(contaSelec, contas);
                    break;
                case 7:
                    process = false;
                    break;
            }
        } while (process);
    }

    // Funcao generica que faz a leitura do teclado e converte o valor recebido para um tipo desejado
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

    // Funcao para adicionar conta corrente
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

    // Funcao para adicionar conta poupanca
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

    // Funcao para listar as contas adicionadas
    public static void listarContas(List<? super Conta> lista) {
        String str = lista.toString().replace("[", "").replace("]", "").replace(", ", "");
        JOptionPane.showMessageDialog(null, str.isEmpty() ? "Nenhuma conta cadastrada!" : str, "Contas Cadastradas", 3);
    }

    // Funcao para selecionar a conta desejada e tambem faz a verificacao de operacao de trasnferencia
    public static Conta selecionarConta(List<? super Conta> contas, boolean transf) {
        boolean error = false;
        Integer idConta = null;

        if (!transf) {
            do {
                idConta = inputValue(Integer.class, "Selecione uma conta", "Digite o número de uma conta");
                if (idConta > 0 && idConta <= contas.size()) {
                    error = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Entrada inválida.", "Alerta", 2);
                    error = true;
                }

            } while (error != false);
        } else {
            do {
                idConta = inputValue(Integer.class, "Selecione uma conta Destino", "Digite o número de uma conta de destino");
                if (idConta > 0 && idConta <= contas.size()) {
                    error = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Entrada inválida.", "Alerta", 2);
                    error = true;
                }

            } while (error != false);
        }

        Conta contaSelecionada = (Conta) contas.get(--idConta);
        return contaSelecionada;
    }

    // Funcao para depositar dinheiro na conta desejada
    public static void depositarDinheiro(Conta conta) {
        boolean error;
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
        } while (error);
    }

    // Funcao para sacar dinheiro na conta desejada
    public static void sacarDinheiro(Conta conta) {
        boolean error = false;
        do {
            Double valor = inputValue(Double.class, "Sacar Dinheiro", "Digite o valor de saque.");
            boolean sucesso = conta.sacar(valor);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Sacar Dinheiro.", 3);
                error = false;
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade inválida.", "Alerta", 2);
                error = true;
            }

        } while (error != false);
    }

    // Funcao para transferir dinheiro na conta desejada para uma conta destino
    public static void transferirDinheiro(Conta conta, List<? super Conta> contas) {
        boolean error = false;
        do {
            Double valor = inputValue(Double.class, "Transferir Dinheiro", "Digite o valor de transferencia.");
            boolean sucesso = conta.tranferirDinheiro(valor, selecionarConta(contas, true));

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Transferir Dinheiro.", 3);
                error = false;
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade inválida.", "Alerta", 2);
                error = true;
            }

        } while (error != false);

    }
}
