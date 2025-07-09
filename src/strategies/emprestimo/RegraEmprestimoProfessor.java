package src.strategies.emprestimo;
import src.models.Livro;
import src.models.Repositorio;
import src.models.usuarios.Usuario;

public class RegraEmprestimoProfessor implements IRegraEmprestimo {
    @Override
    public int getPrazoEmprestimo() {
        return 8; // Prazo de 8 dias para empréstimo
    }

    @Override
    public boolean podeEmprestar(Livro livro, Usuario usuario, Repositorio repositorio) {
        // implementação da regra de empréstimo para professores
        return true;
    }
}
