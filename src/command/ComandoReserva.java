package command;

import models.Livro;
import models.Repositorio;
import models.usuarios.Usuario;
import services.ServicoReserva;

public class ComandoReserva implements IComando {
    private String codigoLivro;
    private String codigoUsuario;
    

    public ComandoReserva( String codigoUsuario, String codigoLivro){
        this.codigoLivro = codigoLivro;
        this.codigoUsuario = codigoUsuario; 
    }

    public void executar(){
        Repositorio repo = Repositorio.getInstancia();

        Livro livro = repo.obterLivroPorCodigo(codigoLivro);
        Usuario usuario = repo.obterUsuarioPorCodigo(codigoUsuario);

        new ServicoReserva().reservarLivro(usuario, livro);
    }
}
