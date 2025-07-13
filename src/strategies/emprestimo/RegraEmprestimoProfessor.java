package strategies.emprestimo;
import models.Livro;
import models.usuarios.Usuario;

// O empréstimo do livro só será concretizado para um professor se:
// 1. Houver a disponibilidade de algum exemplar daquele livro na biblioteca; e
// 2. O usuário não estiver como “devedor” de um livro em atraso.
// Observe que os professores não terão o empréstimo negado, mesmo que haja reservas para o livro em
// questão, e não há limite para a quantidade de livros que eles podem pegar emprestado.

public class RegraEmprestimoProfessor implements IRegraEmprestimo {
    @Override
    public int getPrazoEmprestimo() {
        return 8; // Prazo de 8 dias para empréstimo
    }

    @Override
    public boolean podeEmprestar(Livro livro, Usuario usuario) {
        // implementação da regra de empréstimo para professores
        if (!verificarExemplaresDisponiveis(livro)) {
            return false; // Não há exemplares disponíveis
        }
        if (!verificarUsuarioSemDividas(usuario)) {
            return false; // O usuário está devedor
        }
        // Professores não têm limite de quantidade de livros, então não verificamos isso
        return true;
    }

    // 1: Houver exemplares disponíveis na biblioteca;
    public boolean verificarExemplaresDisponiveis(Livro livro) {
        return livro.obterExemplarDisponivel() != null;
    }

    // 2: O usuário não estiver “devedor” com livros em atraso;
    public boolean verificarUsuarioSemDividas(Usuario usuario) {
        return usuario.isDevedor() != true; 
    }
}
