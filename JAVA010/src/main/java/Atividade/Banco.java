package Atividade;

import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas = new ArrayList<>();

    public void abrirConta(ContaBancaria novaConta) {
        contas.add(novaConta);
    }

    public ContaBancaria buscarConta(String numero) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public void realizarOperacao(String numeroConta, String tipoOperacao, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            switch (tipoOperacao.toLowerCase()) {
                case "deposito":
                    conta.depositar(valor);
                    break;
                case "saque":
                    if (!conta.sacar(valor)) {
                        System.out.println("Saldo insuficiente na conta " + numeroConta);
                    }
                    break;
                default:
                    System.out.println("Operação inválida.");
            }
        } else {
            System.out.println("Conta não encontrada: " + numeroConta);
        }
    }

    public void listarContas() {
        System.out.println("--- Lista de Contas ---");
        for (ContaBancaria conta : contas) {
            System.out.println(conta.getResumo());
        }
    }
}
