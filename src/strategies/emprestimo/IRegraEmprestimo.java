package src.strategies.emprestimo;

import src.models.Livro;
import src.models.usuarios.Usuario;

public interface IRegraEmprestimo {
    int getPrazoEmprestimo();
    boolean podeEmprestar(Livro livro, Usuario usuario);

    
}





