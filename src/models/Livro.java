package src.models;

import java.util.ArrayList;
import java.util.List;
import src.observers.IObservadorLivro;

public class Livro {
    private String codigo;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;

    private List<IObservadorLivro> observadores = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Exemplar> exemplares = new ArrayList<>();

    public Livro(String codigo, String titulo, String autor, String editora, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
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

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
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

    public int obterQuantidadeExemplares() {
        return exemplares.size();
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
