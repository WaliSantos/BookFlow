package src.models;

import src.models.usuarios.Usuario;

public class Reserva {
    private Usuario usuario;
    private Livro livro;
    private String dataReserva;

    public Reserva(Usuario usuario, Livro livro, String dataReserva) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataReserva = dataReserva;
    }


    public Usuario getUsuario() {
        return usuario;
    }
    public Livro getLivro() {
        return livro;
    }   
    public String getDataReserva() {
        return dataReserva;
    }
}
