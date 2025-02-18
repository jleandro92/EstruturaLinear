package estrutura.linear.dicionario;

import estrutura.linear.Processo;
import estrutura.linear.nos.NoComChave;

public class DicionarioDeDados {

    private NoComChave[] tabela;
    private int tamanho;

    public DicionarioDeDados(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new NoComChave[tamanho];
    }

    private int hash(String cpf) {
        return Math.abs(cpf.hashCode()) % tamanho;
    }

    public void inserirProcesso(String cpf, Processo processo) {
        int indice = hash(cpf);
        NoComChave novoNo = new NoComChave(cpf, processo);

        if (tabela[indice] == null) {
            tabela[indice] = novoNo;
        } else {
            NoComChave atual = tabela[indice];
            NoComChave anterior = null;

            while (atual != null) {
                if (atual.cpf.equals(cpf)) {
                    atual.processo = processo;
                    return;
                }
                anterior = atual;
                atual = atual.proximo;
            }

            anterior.proximo = novoNo;
        }
    }

    public void removerProcesso(String cpf) {
        int indice = hash(cpf);
        NoComChave atual = tabela[indice];
        NoComChave anterior = null;

        while (atual != null) {
            if (atual.cpf.equals(cpf)) {
                if (anterior == null) {
                    tabela[indice] = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }

    public Processo buscarProcesso(String cpf) {
        int indice = hash(cpf);
        NoComChave atual = tabela[indice];

        while (atual != null) {
            if (atual.cpf.equals(cpf)) {
                return atual.processo;
            }
            atual = atual.proximo;
        }

        return null;
    }

    public void imprimirProcessos() {
        for (int i = 0; i < tamanho; i++) {
            NoComChave atual = tabela[i];

            while (atual != null) {
                System.out.println("CPF: " + atual.cpf + " | Processo: " + atual.processo.getIdentificador());
                atual = atual.proximo;
            }
        }
    }

    public static void main(String[] args) {
        DicionarioDeDados dicionario = new DicionarioDeDados(10);

        dicionario.inserirProcesso("12345678900", new Processo("Paciente A"));
        dicionario.inserirProcesso("98765432100", new Processo("Paciente B"));
        dicionario.inserirProcesso("11122233344", new Processo("Paciente C"));

        System.out.println("Processos armazenados:");
        dicionario.imprimirProcessos();

        dicionario.removerProcesso("98765432100");
        System.out.println("\nApós remover Paciente B:");
        dicionario.imprimirProcessos();

        System.out.println("\nBuscando Paciente A:");
        Processo encontrado = dicionario.buscarProcesso("12345678900");
        if (encontrado != null) {
            System.out.println("Processo encontrado: " + encontrado.getIdentificador());
        } else {
            System.out.println("Processo não encontrado.");
        }
    }
}
