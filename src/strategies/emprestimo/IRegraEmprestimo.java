package strategies.emprestimo;

import models.Livro;
// import models.Repositorio;
import models.usuarios.Usuario;

public interface IRegraEmprestimo {
    int getPrazoEmprestimo();
    boolean podeEmprestar(Livro livro, Usuario usuario);
}
