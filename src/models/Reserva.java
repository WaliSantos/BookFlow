package models;

import models.usuarios.Usuario;
import java.time.LocalDateTime;

public class Reserva {
    private Usuario usuario;
    private Livro livro;
    private LocalDateTime dataReserva;

    public Reserva(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        livro.adicionarReserva(this);
        this.dataReserva = LocalDateTime.now();
    }


    public Usuario getUsuario() {
        return usuario;
    }
    public Livro getLivro() {
        return livro;
    }   
    public LocalDateTime getDataReserva() {
        return dataReserva;
    }
}
