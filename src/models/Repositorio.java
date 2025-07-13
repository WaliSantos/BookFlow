package src.models;

import java.util.ArrayList;
import java.util.List;
import src.models.usuarios.Usuario;

public class Repositorio {
    private static Repositorio instance;

    private List<Livro> livros =new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    private Repositorio() {

    }

    public static Repositorio getInstance() {
        if (instance == null) {
            instance = new Repositorio();
        }
        return instance;
    }

    public List<Livro> getLivros() {
        return livros;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public void removerLivro(Livro livro) {
        livros.remove(livro);
    } 
    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
    public Livro buscarLivroPorCodigo(String codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo().equalsIgnoreCase(codigo)) {
                return livro;
            }
        }
        return null; 
    }
    public Usuario buscarUsuarioPorCodigo(String codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo().equalsIgnoreCase(codigo)) {
                return usuario;
            }
        }
        return null; 
    }
    
    
}