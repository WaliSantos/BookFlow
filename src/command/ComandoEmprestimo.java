package command;
import models.Livro;
import models.usuarios.Usuario;
import services.ServicoEmprestimo;
import models.Repositorio;

public class ComandoEmprestimo implements IComando {
    private String codigoLivro;
    private String codigoUsuario;

    public ComandoEmprestimo( String codigoUsuario, String codigoLivro){
        this.codigoLivro = codigoLivro;
        this.codigoUsuario = codigoUsuario; 
    }
    @Override
    public void executar() {
        Repositorio repo = Repositorio.getInstancia();

        Livro livro = repo.obterLivroPorCodigo(codigoLivro);
        Usuario usuario = repo.obterUsuarioPorCodigo(codigoUsuario);

        new ServicoEmprestimo().realizarEmprestimo(usuario, livro);

    }

}
