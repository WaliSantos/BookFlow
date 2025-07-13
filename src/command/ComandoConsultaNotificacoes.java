package command;

import models.Repositorio;
import models.usuarios.Usuario;

public class ComandoConsultaNotificacoes implements IComando {
    private String codigoUsuario;

    public ComandoConsultaNotificacoes(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    public void executar(){
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(codigoUsuario);
        
    }
}
