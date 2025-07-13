package services;

import models.usuarios.*;
import models.Livro;
import models.Emprestimo;
import models.Exemplar;

public class ServicoDevolucao {
    public ServicoDevolucao() {
    }

    public boolean realizarDevolucao(Usuario usuario, Livro livro) {

        Emprestimo emprestimo = usuario.buscarEmprestimoDoLivro(livro);

        if (emprestimo == null) {
            System.out.println("Devolucao negada. Usuario nao possui emprestimo deste livro.");
            return false;
        }

        Exemplar exemplar = emprestimo.getExemplar();

        if (exemplar.isDisponivel()) {
            System.out.println("Devolucao negada. Nenhum exemplar disponivel para devolucao.");
            return false;
        }

        exemplar.devolver(); 
        usuario.removerEmprestimoAtual(exemplar);
        System.out.println("Devolucao realizada com sucesso.");
        return true;

        }
}
