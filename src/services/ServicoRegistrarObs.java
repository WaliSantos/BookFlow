package services;

import models.usuarios.*;
import observers.IObservadorLivro;
import models.Livro;

public class ServicoRegistrarObs {
    public ServicoRegistrarObs() {
    }

    public boolean realizarRegistro(Usuario usuario, Livro livro) {
        IObservadorLivro observador = usuario.comoObservadorLivro();
        if (observador != null) {
            livro.adicionarObservador(observador);
            System.out.println("Registro realizado com sucesso.");
            return true;
        } else {
            System.out.println("Apenas professores podem ser registrados como observadores.");
            return false;
        }
    }
}
