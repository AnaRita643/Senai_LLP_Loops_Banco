package Atividade;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        ContaCorrente cc1 = new ContaCorrente("001", "Alice", 2.50);
        ContaPoupanca cp1 = new ContaPoupanca("002", "Bob", 0.05);

        banco.abrirConta(cc1);
        banco.abrirConta(cp1);

        banco.realizarOperacao("001", "deposito", 100.0);
        banco.realizarOperacao("001", "saque", 30.0);

        banco.realizarOperacao("002", "deposito", 200.0);
        banco.realizarOperacao("002", "saque", 50.0);

        ContaBancaria conta = banco.buscarConta("002");
        if (conta instanceof ContaPoupanca poupanca) {
            poupanca.aplicarRendimento();
        }

        banco.listarContas();
    }
}
