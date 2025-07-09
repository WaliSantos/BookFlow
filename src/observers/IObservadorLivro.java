package src.observers;

import src.models.Livro;

public interface IObservadorLivro {

    void notificar(Livro livro);
}