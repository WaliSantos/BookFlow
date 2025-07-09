package src.models.usuarios;
public class Professor extends Usuario {
    public Professor(String nome, String codigo) {
        super(nome, codigo);
        this.regraEmprestimo = new src.strategies.emprestimo.RegraEmprestimoProfessor();
    }
}
