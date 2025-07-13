package command;

import models.Repositorio;
import models.usuarios.Usuario;

public class ComandoConsultaUsuario implements IComando {
    private String codigoUsuario;

    public ComandoConsultaUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    public void executar(){
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(codigoUsuario);
        
    }
}
