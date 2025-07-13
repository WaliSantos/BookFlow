package services;

import models.usuarios.*;

import java.util.List;

import models.Emprestimo;
import models.Reserva;

public class ServicoConsultaUsuario {
    public ServicoConsultaUsuario() {
    }

    public boolean realizarConsultaUsuario(Usuario usuario) {
//         Dado um usuário, o sistema deverá apresentar a lista de todos os seus empréstimos correntes e passados, 
// assim como de suas reservas. A listagem de cada empréstimo deverá apresentar o título do livro, a data 
// do empréstimo, o status atual do empréstimo (em curso ou finalizado) e a data da devolução realizada 
// ou prevista. 
        List<Emprestimo> emprestimosAtuais = usuario.getEmprestimosAtuais();
        List<Emprestimo> emprestimosPassados = usuario.getEmprestimoPassados();
        List<Reserva> reservas = usuario.getReservas();

        for (Emprestimo emprestimo : emprestimosAtuais) {
            System.out.println("Empréstimo Atual:" + emprestimo);
            System.out.println("Livro: " + emprestimo.getExemplar().getLivro().getTitulo());
            System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Status: Em curso");
            System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
        }
        for (Emprestimo emprestimo : emprestimosPassados) {
            System.out.println("Empréstimo Passado:" + emprestimo);
            System.out.println("Livro: " + emprestimo.getExemplar().getLivro().getTitulo());
            System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Status: Finalizado");
            System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
        }

        for (Reserva reserva : reservas) {
            System.out.println("Reserva:" + reserva);
            System.out.println("Livro: " + reserva.getLivro().getTitulo());
            System.out.println("Usuário: " + reserva.getUsuario().getNome());
            System.out.println("Data da Reserva: " + reserva.getDataReserva());
        }

        System.out.println("Consulta ao usuario realizada com sucesso.");
        return true;

        }
}
