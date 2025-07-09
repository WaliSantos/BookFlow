package src.models.usuarios;
public class AlunoGraduacao extends Usuario {
    public AlunoGraduacao(String nome, String codigo) {
        super(nome, codigo);
        this.regraEmprestimo = new src.strategies.emprestimo.RegraEmprestimoGraducao();
    }
}
