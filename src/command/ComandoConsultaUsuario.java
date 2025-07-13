package command;

import models.Repositorio;
import models.usuarios.Usuario;
import services.ServicoConsultaUsuario;

public class ComandoConsultaUsuario implements IComando {
    private String codigoUsuario;

    public ComandoConsultaUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    public void executar(){
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(codigoUsuario);
        
        new ServicoConsultaUsuario().realizarConsultaUsuario(usuario);
    }
}
