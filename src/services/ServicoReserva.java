package services;

import models.Livro;
import models.usuarios.Usuario;
import models.Reserva;

public class ServicoReserva {
    public ServicoReserva() {}
    public boolean reservarLivro(Usuario usuario, Livro livro) {
        if (usuario.temEmprestimoDeLivro(livro)) {
            System.out.println("Reserva negada. Usuario ja possui emprestimo deste livro.");
            return false;
        }
        if (livro.temExemplarEmprestado()) {
            System.out.println("Reserva negada. Nenhum exemplar disponivel para reserva.");
            return false;
        }

        if (usuario.temReservaParaLivro(livro)){
            System.out.println("Reserva negada. Usuario ja possui reserva para este livro.");

            return false;
        }
        usuario.adicionarReserva(new Reserva(usuario, livro));
        System.out.println("Reserva realizada com sucesso.");
        return true;
    }
}
