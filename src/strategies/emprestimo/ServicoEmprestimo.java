package src.strategies.emprestimo;

import src.models.Emprestimo;
import src.models.Exemplar;
import src.models.Livro;
import src.models.usuarios.Usuario;

public class ServicoEmprestimo {
    public boolean realizarEmprestimo(Usuario usuario, Livro livro) {
        IRegraEmprestimo regra = usuario.getRegraEmprestimo();

        if (!regra.podeEmprestar(livro, usuario)) {
            System.out.println("Empréstimo negado.");
            return false;
        }

        Exemplar exemplar = livro.obterExemplarDisponivel();
        if (exemplar == null) {
            System.out.println("Sem exemplar disponível.");
            return false;
        }

        int dias = regra.getPrazoEmprestimo();

        Emprestimo emprestimo = new Emprestimo(usuario, exemplar, dias);
        usuario.adicionarEmprestimoAtual(emprestimo);

        System.out.println("Empréstimo realizado com sucesso.");
        return true;
    }
}
