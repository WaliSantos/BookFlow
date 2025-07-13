package services;

import models.Emprestimo;
import models.Exemplar;
import models.Livro;
import models.usuarios.Usuario;
import strategies.emprestimo.IRegraEmprestimo;

public class ServicoEmprestimo {
    public ServicoEmprestimo() {
    }
    public boolean realizarEmprestimo(Usuario usuario, Livro livro) {
        Exemplar exemplar = livro.obterExemplarDisponivel();
        if (exemplar == null) {
            System.out.println("Sem exemplar disponivel.");
            return false;
        }

        
        IRegraEmprestimo regra = usuario.getRegraEmprestimo();

        if (!regra.podeEmprestar(livro, usuario)) {
            System.out.println("Emprestimo negado.");
            return false;
        }

        
        int dias = regra.getPrazoEmprestimo();

        Emprestimo emprestimo = new Emprestimo(usuario, exemplar, dias);

        if (usuario.temReservaParaLivro(livro)) {
            usuario.removerReserva(livro);
            System.out.println("Reserva removida para realizar emprestimo.");
        }
        if(livro.temReserva()){
            livro.removerReserva();
            System.out.println("Reserva removida do livro.");
        }
        
        exemplar.emprestar();
        usuario.adicionarEmprestimoAtual(emprestimo);
        System.out.println("Emprestimo realizado com sucesso.");
        return true;
    }
}
