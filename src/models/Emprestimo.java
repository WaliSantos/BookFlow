package models;

import models.usuarios.Usuario;
import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private int prazoEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
   

    public Emprestimo(Usuario usuario, Exemplar exemplar, int prazoEmprestimo) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.prazoEmprestimo = usuario.getRegraEmprestimo().getPrazoEmprestimo();
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(prazoEmprestimo);
        
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public Exemplar getExemplar() { return exemplar;
    }  
    public int getPrazoEmprestimo() {
        return prazoEmprestimo;
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public boolean isAtrasado() {
        return LocalDate.now().isAfter(dataDevolucao);
    }

    
    
      
    
}
