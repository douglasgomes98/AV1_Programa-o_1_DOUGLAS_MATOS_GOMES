package programa;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Aplicacao {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        List<Conta> contas = new ArrayList<>();
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
                case 6:
                    process = false;
            }
        } while (process);
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
}
