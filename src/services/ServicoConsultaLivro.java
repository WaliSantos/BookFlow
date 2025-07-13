package services;


import models.Livro;
import models.Exemplar;
import models.Reserva;
import models.usuarios.Usuario;

import java.util.List;

public class ServicoConsultaLivro {
    public ServicoConsultaLivro() {
    }

    public boolean realizarConsultaLivro( Livro livro) {
     // (i) título
    String titulo = livro.getTitulo();
    System.out.println("Livro: " + titulo);
    
    // (ii) reservas
    List<Reserva> reservas = livro.getReservas();
    int qtdReservas = reservas.size();
    System.out.println("Quantidade de reservas: " + qtdReservas);

    if (qtdReservas > 0) {
        for (Reserva reserva : reservas) {
            System.out.println("Usuário: " + reserva.getUsuario().getNome());
        }
    }

    // (iii) exemplares
    List<Exemplar> exemplares = livro.getExemplares();
    for (Exemplar exemplar : exemplares) {
        String status = exemplar.isDisponivel() ? "Disponível" : "Emprestado";
        System.out.println("Exemplar: " + exemplar.getNumeroExemplar() + " - Status: " + status);
    }

    System.out.println("Consulta do Livro realizada com sucesso.");
    return true;
    }
}

