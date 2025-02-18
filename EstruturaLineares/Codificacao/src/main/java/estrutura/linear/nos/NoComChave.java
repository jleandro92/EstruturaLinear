package estrutura.linear.nos;

import estrutura.linear.Processo;

public class NoComChave {

    public String cpf;

    public NoComChave proximo;
    public Processo processo;


    public NoComChave(String cpf, Processo processo) {
        this.cpf = cpf;
        this.processo = processo;
        this.proximo = null;
    }
}
