package command;

import models.Livro;
import models.Repositorio;

public class ComandoConsultaLivro implements IComando {
    private String codigoLivro;

    public ComandoConsultaLivro(  String codigoLivro){
        this.codigoLivro = codigoLivro;
      
    }

    public void executar(){
        Repositorio repositorio = Repositorio.getInstancia();

        Livro livro = repositorio.obterLivroPorCodigo(codigoLivro);

    }
}

