package src.models;
public class Livro {
    private String codigo;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;

    public Livro(String codigo, String titulo, String autor, String editora, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }
    
    public String getCodigo() {
        return codigo;
    }   
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor; 
    }
    public String getEditora() {
        return editora;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
}
