package estrutura.linear.nos;

import estrutura.linear.Processo;

public class NoComDuplaLigacao {
    public Processo processo;
    public NoComDuplaLigacao proximo;
    public NoComDuplaLigacao anterior;


    public NoComDuplaLigacao(Processo processo) {
        this.processo = processo;
        this.proximo = null;
        this.anterior = null;
    }
}
