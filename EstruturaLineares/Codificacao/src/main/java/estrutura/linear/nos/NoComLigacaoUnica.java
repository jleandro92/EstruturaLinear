package estrutura.linear.nos;

import estrutura.linear.Processo;

public class NoComLigacaoUnica {

    public Processo processo;
    public NoComLigacaoUnica proximo;


    public NoComLigacaoUnica(Processo processo) {
        this.processo = processo;
        this.proximo = null;
    }

}
