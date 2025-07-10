package src.models.usuarios;

import src.strategies.emprestimo.IRegraEmprestimo;

public class AlunoGraduacao extends Usuario {
    public AlunoGraduacao(String nome, String codigo) {
        super(nome, codigo);
        this.regraEmprestimo = new src.strategies.emprestimo.RegraEmprestimoGraducao();
    }

    public IRegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }
}
