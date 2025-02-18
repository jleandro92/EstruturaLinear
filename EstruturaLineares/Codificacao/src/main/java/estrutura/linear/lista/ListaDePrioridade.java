package estrutura.linear.lista;


import estrutura.linear.Processo;
import estrutura.linear.nos.NoComLigacaoUnica;


public class ListaDePrioridade {

    private NoComLigacaoUnica cabeca;

    public ListaDePrioridade() {
        this.cabeca = null;
    }


    public void inserir(Processo processo) {
        NoComLigacaoUnica novoNo = new NoComLigacaoUnica(processo);

        // Se a lista estiver vazia ou se o novo processo tiver maior prioridade que o primeiro
        if (cabeca == null || processo.getPrioridade() >= cabeca.processo.getPrioridade()) {
            novoNo.proximo = cabeca;
            cabeca = novoNo;
        } else {
            // Percorre a lista até encontrar a posição correta
            NoComLigacaoUnica atual = cabeca;
            while (atual.proximo != null && atual.proximo.processo.getPrioridade() >= processo.getPrioridade()) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
        }
    }


    public void remover() {
        if (cabeca != null) {
            cabeca = cabeca.proximo;
        }
    }


    public void imprimir() {
        NoComLigacaoUnica atual = cabeca;
        while (atual != null) {
            System.out.println("ID: " + atual.processo.getIdentificador() +
                    " | Prioridade: " + atual.processo.getPrioridade());
            atual = atual.proximo;
        }
    }


    public static void main(String[] args) {
        ListaDePrioridade lista = new ListaDePrioridade();

        lista.inserir(new Processo("Processo 3", 1));
        lista.inserir(new Processo("Processo 1", 3));
        lista.inserir(new Processo("Processo 2", 2));
        lista.inserir(new Processo("Processo 4", 3));

        System.out.println("Lista de prioridade após inserções:");
        lista.imprimir();

        lista.remover();
        System.out.println("\nLista de prioridade após remoção do mais prioritário:");
        lista.imprimir();
    }
}
