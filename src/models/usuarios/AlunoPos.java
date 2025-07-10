package src.models.usuarios;

import src.strategies.emprestimo.IRegraEmprestimo;

public class AlunoPos extends Usuario {
    public AlunoPos(String nome, String codigo) {
        super(nome, codigo);
        this.regraEmprestimo = new src.strategies.emprestimo.RegraEmprestimoPos();
    }

    public IRegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }
}
