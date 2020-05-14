1- Modele uma conta. A ideia aqui é apenas modelar, isto é, só identifique que
informações são importantes. Desenhe no papel ou em um software de
modelagem de UML tudo o que uma Conta tem e tudo o que ela faz. Ela deve ter
o nome do titular (String), o número (int), a agência (String), o saldo (double) e
uma data de abertura (String). Além disso, ela deve fazer as seguintes ações: saca,
para retirar um valor do saldo; deposita, para adicionar um valor ao saldo e
transfere valores de uma conta para outra. \
2- Transforme o modelo acima em uma classe Java. Teste-a, usando uma outra classe
que tenha o main. Você deve criar a classe da conta com o nome Conta, mas pode
nomear como quiser a classe de testes, contudo, ela deve possuir o método main.
Utilize as regras de visibilidade e encapsulamento.\
3- Crie um método toString() , que não recebe parâmetro mas devolve o texto com
todas as informações da nossa conta para efetuarmos a impressão.\
4- Construa duas contas com o new, faça um depósito nas duas contas, faça um saque
na primeira conta e uma transferência da segunda conta para a primeira conta.
Após isso, utilize o método toString para mostrar as informações (Atributos das
duas contas).\
5- Crie outras duas classes, ContaCorrente e ContaPoupanca. Adicione os atributos
taxaAdministracao (double) e limite (double) na ContaCorrente. Adicione os
atributos porcentagemRendimento(double) e diaRendimento(int) na 
ContaPoupanca. Faça as duas novas classes herdarem de Conta, transforme a
classe Conta em uma classe abstrata. Reimplemente o método toString nas duas
novas classes de conta.\
6- O que aconteceu com as duas contas criadas na questão 4? Explique e modifique
o código para o bom funcionamento.\
R = As duas deixaram de ser do tipo Conta, e agora são classes que herdam as propriedades
da classe Conta que agora é abstrata. Então as novas classes de conta corrente e poupança
são obrigadas a implementar as funcionares de sacar, despositar e tranferir dinheiro.\
7- Transforme os métodos da Classe Conta em métodos abstratos, e faça a
implementação correta nas Classes ContaCorrente e ContaPoupanca. Comente
justificando a lógica utilizada.\
R= No caso do saque, o valor solicitado não pode ser negativo ou igual a zero, 
além de não ser maior que o saldo da conta.\
No caso do deposito, o valor solicitado não pode ser negavito ou igual a zero.\
No caso da transferencia, o valor solicitado não pode ser negativo ou igual a zero,
alem de não ser maior que o saldo da conta que irá fazer a transferência, além que uma conta
não pode transferir para a conta de origem.\
8- Crie uma interface Tributavel e adicione o método getValorImposto() a essa
interface. Após isso, faça a Classe ContaCorrente implementar essa nova
interface. Implemente o método getValorImposto() na classe ContaCorrente,
atribuindo o valor a ser pago de 0.01 sobre o saldo atual da ContaCorrente.\
9- Lance exceções sobre os métodos que podem acontecer erros de atribuição de
valores indevidos. Modifique os métodos já utilizados na Classe principal para
que não ocorram erros.\
10- Utilizando a Classse JOptionPane, faça opções de entrada de dados para criação
de conta poupança e conta corrente, opções para deposito, saque e transferência.
Após isso, faça opções para mostrar as contas criadas.
