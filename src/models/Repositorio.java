package models;

import java.util.List;
import java.util.ArrayList;

import models.usuarios.Usuario;


public class Repositorio {
    private static Repositorio instancia;
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();

    private Repositorio() {
        // Constructor privado para evitar instanciación externa
    }
    public static Repositorio getInstancia() {
        if (instancia == null) {
            instancia = new Repositorio();
        }
        return instancia;
    }
    public Usuario obterUsuarioPorCodigo(String codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo().equals(codigo)) {
                return usuario;
            }  
        }
        return null; 
    }

    public Livro obterLivroPorCodigo(String codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo().equals(codigo)) {
                return livro;
            }
        }
        return null; 
    }
}
