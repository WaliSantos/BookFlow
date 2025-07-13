package models;

import models.usuarios.Usuario;

public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private int prazoEmprestimo;
   

    public Emprestimo(Usuario usuario, Exemplar exemplar, int prazoEmprestimo) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.prazoEmprestimo = usuario.getRegraEmprestimo().getPrazoEmprestimo() ;
        
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public Exemplar getExemplar() { return exemplar;
    }  
    public int getPrazoEmprestimo() {
        return prazoEmprestimo;
    }

    
    
      
    
}
