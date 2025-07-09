package src.models.usuarios;
public class AlunoPos extends Usuario {
    public AlunoPos(String nome, String codigo) {
        super(nome, codigo);
        this.regraEmprestimo = new src.strategies.emprestimo.RegraEmprestimoPos();
    }
}
