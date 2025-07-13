package models.usuarios;

import strategies.emprestimo.IRegraEmprestimo;

public class AlunoGraduacao extends Usuario {
    public AlunoGraduacao(String nome, String codigo) {
        super(nome, codigo);
        this.regraEmprestimo = new strategies.emprestimo.RegraEmprestimoGraducao();
    }

    public IRegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }

    public boolean podeSerObservador(){
        return false;
    }
}
