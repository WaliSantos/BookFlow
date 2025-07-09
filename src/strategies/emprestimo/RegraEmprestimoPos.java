package src.strategies.emprestimo;

import src.models.Livro;
import src.models.Repositorio;
import src.models.usuarios.Usuario;

public class RegraEmprestimoPos implements IRegraEmprestimo {
    @Override
    public int getPrazoEmprestimo() {
        return 5; // Prazo de 5 dias para empréstimo
    }

    @Override
    public boolean podeEmprestar(Livro livro,Usuario usuario,  Repositorio repositorio) {  
        // Implementação da regra de empréstimo para alunoPos
        return true;
    }
    
}
