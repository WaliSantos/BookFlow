package observers;

import models.Livro;

public interface IObservadorLivro {

    void notificar(Livro livro);
}