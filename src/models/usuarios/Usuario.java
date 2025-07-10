package src.models.usuarios;

import src.strategies.emprestimo.IRegraEmprestimo;
import src.models.Emprestimo;
import src.models.Reserva;

import java.util.ArrayList;
import java.util.List;
public class Usuario {
    private String nome;
    private String codigo;
    protected IRegraEmprestimo regraEmprestimo;

    private List<Emprestimo> emprestimosAtuais = new ArrayList<>();
    private List<Emprestimo> EmprestimoPassados = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

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

    public void adicionarEmprestimoAtual(Emprestimo emprestimo) {
        emprestimosAtuais.add(emprestimo);
    }

    
}