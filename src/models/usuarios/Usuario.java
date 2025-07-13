package models.usuarios;

import strategies.emprestimo.IRegraEmprestimo;
import models.Emprestimo;
import models.Reserva;
import observers.IObservadorLivro;
import models.Livro;
import models.Exemplar;

import java.util.ArrayList;
import java.util.List;
public class Usuario {
    private String nome;
    private String codigo;
    protected IRegraEmprestimo regraEmprestimo;

    private List<Emprestimo> emprestimosAtuais;
    private List<Emprestimo> EmprestimoPassados;
    private List<Reserva> reservas;

    public Usuario(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.emprestimosAtuais = new ArrayList<>();
        this.EmprestimoPassados = new ArrayList<>();
        this.reservas = new ArrayList<>();
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

    public Emprestimo buscarEmprestimoDoLivro(Livro livro) {
        for (Emprestimo emprestimo : emprestimosAtuais) {
            if (emprestimo.getExemplar().getLivro().equals(livro)) {
                return emprestimo;
            }
        }
        return null;
    }
    public boolean temEmprestimoDeLivro(Livro livro) {
        for (Emprestimo emprestimo : emprestimosAtuais) {
            System.out.println("Usuário tem o livro: " + emprestimo.getExemplar().getLivro().getCodigo());
            if (emprestimo.getExemplar().getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public IRegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }

    public void adicionarEmprestimoAtual(Emprestimo emprestimo) {
        emprestimosAtuais.add(emprestimo);
    }
    public void removerEmprestimoAtual(Exemplar exemplar) {
        for (Emprestimo emprestimo : emprestimosAtuais) {
            if (emprestimo.getExemplar().equals(exemplar)) {
                emprestimosAtuais.remove(emprestimo);
                break;
            }
        }
      
    }
    public void adicionarEmprestimoPassado(Emprestimo emprestimo) {
        EmprestimoPassados.add(emprestimo);
        
    }
    public void removerEmprestimoPassado(Emprestimo emprestimo) { 
        EmprestimoPassados.remove(emprestimo);
    }
    public List<Reserva> getReservas(){
        return reservas;
    }
    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
       
    }

    public void removerReserva(Livro livro) {
        for (Reserva reserva : reservas) {
            if (reserva.getLivro().equals(livro)) {
                reservas.remove(reserva);
                break;
            }   
        }
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

    public boolean podeSerObservador() {
        return false;
    }
    public IObservadorLivro comoObservadorLivro() {
        return null; 
    }

    

    
}