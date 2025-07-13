package command;

import models.Livro;
import models.Repositorio;
import models.usuarios.Usuario;
import services.ServicoDevolucao;

public class ComandoDevolucao implements IComando {
    private String codigoLivro;
    private String codigoUsuario;
    

    public ComandoDevolucao( String codigoUsuario, String codigoLivro){
        this.codigoLivro = codigoLivro;
        this.codigoUsuario = codigoUsuario; 
    }

    public void executar(){
        Repositorio repo = Repositorio.getInstancia();

        Livro livro = repo.obterLivroPorCodigo(codigoLivro);
        Usuario usuario = repo.obterUsuarioPorCodigo(codigoUsuario);

        new ServicoDevolucao().realizarDevolucao(usuario, livro);
    }
}

