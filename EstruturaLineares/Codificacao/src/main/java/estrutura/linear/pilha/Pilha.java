package estrutura.linear.pilha;

import estrutura.linear.Processo;

public class Pilha {

    public Processo processoAtual;
    public Pilha proximaPilha;


    public Pilha() {
        this.processoAtual = null;
        this.proximaPilha = null;
    }


    public void inserirPilha(Processo processoNovo) {
        if (this.processoAtual == null) {

            this.processoAtual = processoNovo;
            this.proximaPilha = new Pilha();
        } else {

            this.proximaPilha.inserirPilha(processoNovo);
        }
    }


    public Processo removerPilha() {
        if (this.processoAtual == null) {
            System.out.println("A pilha está vazia!");
            return null;
        }


        if (this.proximaPilha.proximaPilha == null) {
            Processo processoRemovido = this.processoAtual;
            this.processoAtual = null;
            this.proximaPilha = null;
            return processoRemovido;
        }


        return this.proximaPilha.removerPilha();
    }


    public boolean vaziaPilha() {
        return this.processoAtual == null;
    }


    public void imprimirPilha() {
        if (vaziaPilha()) {
            System.out.println("A pilha está vazia!");
            return;
        }

        System.out.println("Pilha de Processos:");
        Pilha atual = this;
        while (atual.processoAtual != null) {
            // Exibe o identificador e prioridade do processo atual
            System.out.println("Processo: " + atual.processoAtual.getIdentificador() +
                    ", Prioridade: " + atual.processoAtual.getPrioridade());
            atual = atual.proximaPilha; // Avança para o próximo elemento na pilha
        }
    }


    public static void main(String[] args) {
        Pilha pilha = new Pilha();


        pilha.inserirPilha(new Processo("Processo 1", 1));
        pilha.inserirPilha(new Processo("Processo 2", 2));
        pilha.inserirPilha(new Processo("Processo 3", 3));


        pilha.imprimirPilha();


        System.out.println("\nRemovendo um processo...");
        pilha.removerPilha();


        pilha.imprimirPilha();
    }
}
