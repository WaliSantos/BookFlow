package src.models.usuarios;

import java.util.ArrayList;
import java.util.List;
import src.models.Emprestimo;
import src.models.Livro;
import src.models.Reserva;
import src.strategies.emprestimo.IRegraEmprestimo;
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

    public List<Emprestimo> getEmprestimosAtuais() {
        return emprestimosAtuais;
    }

    public List<Emprestimo> getEmprestimosPassados() {
        return EmprestimoPassados;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public boolean temReservaParaLivro(Livro livro) {
        for (Reserva reserva : reservas) {
            if (reserva.getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }
}