package estrutura.linear.lista;

import estrutura.linear.Processo;
import estrutura.linear.nos.NoComDuplaLigacao;


public class ListaDupla {

    class ListaLigada {
        private NoComDuplaLigacao primeiro = null;
        private NoComDuplaLigacao ultimo = null;


        public void inserir(Processo processo) {
            NoComDuplaLigacao novoNo = new NoComDuplaLigacao(processo);

            if (primeiro == null) {

                primeiro = novoNo;
                ultimo = novoNo;
            } else {

                novoNo.anterior = this.ultimo;
                this.ultimo.proximo = novoNo;
                this.ultimo = novoNo;
            }
        }


        public void remover(Processo processo) {
            NoComDuplaLigacao currentNode = this.primeiro;

            while (currentNode != null) {
                if (currentNode.processo.equals(processo)) {
                    // Se for o primeiro nó, atualiza o primeiro
                    if (currentNode == this.primeiro) {
                        this.primeiro = currentNode.proximo;
                        if (this.primeiro != null) {
                            this.primeiro.anterior = null;
                        }
                    }
                    // Se for o último nó, atualiza o último
                    else if (currentNode == this.ultimo) {
                        this.ultimo = currentNode.anterior;
                        if (this.ultimo != null) {
                            this.ultimo.proximo = null;
                        }
                    }
                    // Se estiver no meio, ajusta os ponteiros
                    else {
                        currentNode.anterior.proximo = currentNode.proximo;
                        currentNode.proximo.anterior = currentNode.anterior;
                    }
                    return; // Sai do método após a remoção
                }
                currentNode = currentNode.proximo; // Avança para o próximo nó
            }
        }


        public void imprimir() {
            NoComDuplaLigacao currentNode = this.primeiro;
            if (currentNode == null) {
                System.out.println("A lista está vazia!");
                return;
            }
            System.out.println("Lista de Processos:");
            while (currentNode != null) {
                System.out.println("Processo: " + currentNode.processo.getIdentificador() +
                        ", Prioridade: " + currentNode.processo.getPrioridade());
                currentNode = currentNode.proximo; // Avança para o próximo nó
            }
        }

    }
    public static void main(String[] args) {
        ListaLigada lista = new ListaDupla().new ListaLigada();


        Processo p1 = new Processo("Processo 1", 1);
        Processo p2 = new Processo("Processo 2", 2);
        Processo p3 = new Processo("Processo 3", 3);
        Processo p4 = new Processo("Processo 4", 4);

        lista.inserir(p4);
        lista.inserir(p1);
        lista.inserir(p2);
        lista.inserir(p3);


        lista.imprimir();


        System.out.println("\nRemovendo Processo 2...");
        lista.remover(p2);
        lista.imprimir();
    }
}
