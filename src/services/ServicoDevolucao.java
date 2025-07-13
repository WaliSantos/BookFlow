package services;

import models.usuarios.*;
import models.Livro;
import models.Exemplar;

public class ServicoDevolucao {
    public ServicoDevolucao() {
    }

    public boolean realizarDevolucao(Usuario usuario, Livro livro) {
        if (!usuario.temEmprestimoDeLivro(livro)) {
            System.out.println("Devolucao negada. Usuario nao possui emprestimo deste livro.");
            return false;
        }
        if (!livro.temExemplarEmprestado()) {   
            System.out.println("Devolucao negada. Nenhum exemplar emprestado deste livro.");
            return false;
        }
        Exemplar exemplar = livro.obterExemplarDisponivel();
        if (exemplar == null) {
            System.out.println("Devolucao negada. Nenhum exemplar disponivel para devolucao.");
            return false;
        }
        exemplar.devolver();
        usuario.adicionarEmprestimoPassado(exemplar);
        usuario.removerEmprestimoAtual(exemplar);

        System.out.println("Devolucao realizada com sucesso.");
        return true;

    }
}
