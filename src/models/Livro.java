package models;

import java.util.ArrayList;
import java.util.List;

import observers.IObservadorLivro;
import models.usuarios.Usuario;

public class Livro {
    private String codigo;
    private String titulo;
    private String autor;
    private String editora;
    private String edicao;
    private int anoPublicacao;

    private List<IObservadorLivro> observadores;
    private List<Reserva> reservas;
    private List<Exemplar> exemplares;

    public Livro(String codigo, String titulo, String editora , String autor, String edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.observadores = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.exemplares = new ArrayList<>();
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
    public String getEdicao() {
        return edicao;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public void adicionarObservador(IObservadorLivro observador) {
        observadores.add(observador);
    }
    public void removerObservador(IObservadorLivro observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (IObservadorLivro obs : observadores) {
            obs.notificar(this);
        }
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        if (reservas.size() > 2) {
            for (IObservadorLivro obs : observadores) {
                obs.notificar(this);
            }
        }
    }

    public void removerReserva(Livro livro) {
        for (Reserva reserva : reservas) { 
            if (reserva.getLivro().equals(this)) {
                reservas.remove(reserva);
                break;
            }
        }
    }
    public void remorverReservaUsuario(Usuario usuario) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                reservas.remove(reserva);
                break;
            }
        }
    }
    public boolean temReserva() {
        for (Reserva reserva : reservas) {
            if (reserva.getLivro().equals(this)) {
                return true;
            }
        }
        return false;
    }
    public Usuario getPrimeiroUsuarioReserva() {
        if (reservas.isEmpty()) {
            return null; 
        }
        return reservas.get(0).getUsuario();
    }


    
    public List<Exemplar> getExemplares() {
        return exemplares;
    }
    
    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public void removerExemplar(Exemplar exemplar) {
        exemplares.remove(exemplar);
    }
    public boolean temExemplarEmprestado() {
        for (Exemplar exemplar : exemplares) {
            if (!exemplar.isDisponivel()) {
                return true;
            }
        }
        return false;
    }
 
    public Exemplar obterExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                return exemplar;
            }
        }
        return null; 
    }
    
}
