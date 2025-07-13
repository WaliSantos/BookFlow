package models.usuarios;

import models.Livro;
import observers.IObservadorLivro;
import strategies.emprestimo.IRegraEmprestimo;

public class Professor extends Usuario implements IObservadorLivro {
    private int totalNotificacoes = 0;

    public Professor(String nome, String codigo) {
        super(nome, codigo);
        this.regraEmprestimo = new strategies.emprestimo.RegraEmprestimoProfessor();
    }


    @Override
    public void notificar(Livro livro) {
        totalNotificacoes++;
        System.out.println("Professor " + this.getNome() + " foi notificado sobre o livro " + livro.getTitulo());
    }

    public int getTotalNotificacoes() {
        return totalNotificacoes;
    }

    public IRegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }
    public boolean podeSerObservador(){
        return true;
    }
    @Override
    public IObservadorLivro comoObservadorLivro() {
        return this; 
    }
}
