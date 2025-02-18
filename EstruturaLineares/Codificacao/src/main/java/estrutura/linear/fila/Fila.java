package estrutura.linear.fila;

import estrutura.linear.Processo;

public class Fila {

    public Processo processoAtual;
    public Fila proximaFila;


    public Fila(){
        this.processoAtual = null;
        this.proximaFila = null;
    }

    public void inserirFila(Processo processoNovo){
        if(this.processoAtual == null){
            this.processoAtual = processoNovo;
            this.proximaFila = new Fila();
        }else{
            this.proximaFila.inserirFila(processoNovo);
        }
    }

    public Processo removerfila() {
        Processo removido = this.processoAtual;
        this.processoAtual = this.proximaFila.processoAtual;
        this.proximaFila = this.proximaFila.proximaFila;
        return removido;
    }

    public void imprimirFila() {
        Fila atual = this;

        if (atual.estaVazia()) {
            System.out.println("A fila está vazia!");
            return;
        }

        System.out.println("Fila de Processos:");
        while (atual.processoAtual != null) {
            System.out.println("Processo: " + atual.processoAtual.getIdentificador() +
                    ", Prioridade: " + atual.processoAtual.getPrioridade());
            atual = atual.proximaFila;
        }
    }


    public boolean estaVazia(){
        if(this.processoAtual == null){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.inserirFila(new Processo("Processo 1", 1));
        fila.inserirFila(new Processo("Processo 2", 2));
        fila.inserirFila(new Processo("Processo 3", 3));

        fila.imprimirFila();

        System.out.println("Removendo processos...");

        System.out.println("Removido: " + fila.removerfila().getIdentificador());

        System.out.println("Fila após processos removidos: ");

        fila.imprimirFila();
    }



}
