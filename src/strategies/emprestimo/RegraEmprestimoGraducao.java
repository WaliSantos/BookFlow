package strategies.emprestimo;
import models.Emprestimo;
import models.Livro;
import models.usuarios.Usuario;

// Estratégia para alunos
// O empréstimo de um livro será realizado para um aluno de graduação ou de pós-graduação apenas se:
// 1. Houver exemplares disponíveis na biblioteca;
// 2. O usuário não estiver “devedor” com livros em atraso;
// 3. O usuário seguir as regras específicas referentes à quantidade máxima de livros que podem ser
// emprestados (conforme Tabela 2);
// 4. A quantidade de reservas existentes do livro deve ser menor do que a quantidade de exemplares
// disponíveis, desde que o usuário não tenha uma reserva para esse livro;
// 5. Se a quantidade de reservas for igual ou superior à de exemplares disponíveis, o empréstimo
// será permitido apenas se uma das reservas for do usuário;
// 6. O usuário não pode ter nenhum empréstimo em andamento de um exemplar desse mesmo livro.

public class RegraEmprestimoGraducao implements IRegraEmprestimo {
    public int getPrazoEmprestimo() {
        return 4; // Prazo de 4 dias para empréstimo
    }

    @Override
    public boolean podeEmprestar(Livro livro,Usuario usuario) {  
        if (!verificarExemplaresDisponiveis(livro)) {
            return false; // Não há exemplares disponíveis
        }
        if (!verificarUsuarioSemDividas(usuario)) {
            return false; // O usuário está devedor
        }
        if (!verificarQuantidadeMaximaLivros(usuario)) {
            return false; // O usuário excedeu a quantidade máxima de livros
        }
        if (!verificarReservasLivros(livro, usuario)) {
            return false; // Reservas não atendem aos critérios
        }
        if (!verificarReservasUsuario(livro, usuario)) {
            return false; // O usuário não tem reserva para o livro
        }
        return verificarEmprestimosAtuais(usuario, livro);
    }

    // 1: Houver exemplares disponíveis na biblioteca;
    public boolean verificarExemplaresDisponiveis(Livro livro) {
        return livro.obterExemplarDisponivel() != null;
    }

    // 2: O usuário não estiver “devedor” com livros em atraso;
    public boolean verificarUsuarioSemDividas(Usuario usuario) {
        return usuario.isDevedor() != true; 
    }
    
    // 3: O usuário seguir as regras específicas referentes à quantidade máxima de livros que podem ser emprestados
    public boolean verificarQuantidadeMaximaLivros(Usuario usuario) {
        return usuario.getEmprestimosAtuais().size() < 2; 
    }
    
    // 4: A quantidade de reservas existentes do livro deve ser menor do que a quantidade de exemplares disponíveis, desde que o usuário não tenha uma reserva para esse livro;
    public boolean verificarReservasLivros(Livro livro, Usuario usuario) {
        if (usuario.temReservaParaLivro(livro)) {
            return true;
        }

        int reservas = livro.getReservas().size();
        int exemplares = livro.getExemplares().size();

        return reservas < exemplares;
    }

    // 5: Se a quantidade de reservas for igual ou superior à de exemplares disponíveis, o empréstimo será permitido apenas se uma das reservas for do usuário;
    public boolean verificarReservasUsuario(Livro livro, Usuario usuario) {
        int reservas = livro.getReservas().size();
        int exemplares = livro.getExemplares().size();

        if (reservas >= exemplares) {
            return usuario.temReservaParaLivro(livro);
        }

        return true;
    }
    // 6: O usuário não pode ter nenhum empréstimo em andamento de um exemplar desse mesmo livro.
    public boolean verificarEmprestimosAtuais(Usuario usuario, Livro livro) {
        for (Emprestimo emprestimo : usuario.getEmprestimosAtuais()) {
            if (emprestimo.getExemplar().getLivro().equals(livro)) {
                return false; 
            }
        }
        return true; 
    }
}