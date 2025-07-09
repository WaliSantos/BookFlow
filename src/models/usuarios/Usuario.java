package src.models.usuarios;

import src.strategies.emprestimo.IRegraEmprestimo;

public class Usuario {
    private String nome;
    private String codigo;
    protected IRegraEmprestimo regraEmprestimo;

    public Usuario(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public IRegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }

    
}