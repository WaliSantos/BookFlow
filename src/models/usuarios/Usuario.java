package models.usuarios;

import strategies.emprestimo.IRegraEmprestimo;
import models.Emprestimo;
import models.Reserva;
import models.Livro;

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

    public List<Emprestimo> getEmprestimosAtuais() {
        return emprestimosAtuais;
    }
    public List<Emprestimo> getEmprestimoPassados() {
        return EmprestimoPassados;
    }

    public IRegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }

    public void adicionarEmprestimoAtual(Emprestimo emprestimo) {
        emprestimosAtuais.add(emprestimo);
    }
    public List<Reserva> getReservas(){
        return reservas;
    }
    public void adicionarReserva(Livro livro) {
        Reserva reserva = new Reserva(this, livro);
        reservas.add(reserva);
       
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }
    public boolean temReservaParaLivro(Livro livro) {
        for (Reserva reserva : reservas) {
            if (reserva.getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDevedor(){
        for (Emprestimo emprestimo : emprestimosAtuais) {
            if (emprestimo.isAtrasado()) {
                return true;
            }
        }
        return false;
    }

    

    
}