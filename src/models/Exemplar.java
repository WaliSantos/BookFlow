package models;

public class Exemplar {
    private Livro livro;
    private String codigoLivro;
    private String numeroExemplar;
    private boolean disponivel;

    public Exemplar(String codigoLivro, String numeroExemplar) {
        this.livro = Repositorio.getInstancia().obterLivroPorCodigo(codigoLivro);
        this.codigoLivro = codigoLivro;
        this.numeroExemplar = numeroExemplar;
        this.disponivel = true;
    }
    public String getCodigoLivro() {
        return codigoLivro;
    }
    public String getNumeroExemplar() {
        return numeroExemplar;
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
