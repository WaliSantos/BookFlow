package models;

public class Exemplar {
    private Livro livro;
    private boolean disponivel = true;

    public Exemplar(Livro livro) {
        this.livro = livro;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }

    public Livro getLivro() {
        return livro;
    }
}
