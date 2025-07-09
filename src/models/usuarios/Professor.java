package src.models.usuarios;

import src.models.Livro;
import src.observers.IObservadorLivro;

public class Professor extends Usuario implements IObservadorLivro {
    private int totalNotificacoes = 0;

    public Professor(String nome, String codigo) {
        super(nome, codigo);
        this.regraEmprestimo = new src.strategies.emprestimo.RegraEmprestimoProfessor();
    }


    @Override
    public void notificar(Livro livro) {
        totalNotificacoes++;
        System.out.println("Professor " + this.getNome() + " foi notificado sobre o livro " + livro.getTitulo());
    }

    public int getTotalNotificacoes() {
        return totalNotificacoes;
    }
}
