package src.strategies.emprestimo;
import src.models.Livro;
// import src.models.Repositorio;
import src.models.usuarios.Usuario;

public class RegraEmprestimoGraducao implements IRegraEmprestimo {
    public int getPrazoEmprestimo() {
        return 4; // Prazo de 4 dias para empréstimo
    }

    @Override
    public boolean podeEmprestar(Livro livro,Usuario usuario) {  
        // Implementação da regra de empréstimo para alunoGraduação
        return true;
    }

    
    
}
