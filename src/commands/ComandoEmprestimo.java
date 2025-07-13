package src.commands;

import src.models.Livro;
import src.models.usuario.Usuario;
import src.models.usuario.Repositorio;
import src.strategies.emprestimo.ServicoEmprestimo;

public class ComandoEmprestimo implements IComando{
    private String codigoUsuario;
    private String codigoLivro;

    public comandoEmprestimo(String codigoUsuario, String codigoLivro) {
        this.codigoUsuario = codigoUsuario;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public void executar() {
        Repositorio rep = Repositorio.obterInstancia();

        Usuario u = rep.obterUsuarioPorCodigo(codigoUsuario);
        Livro l = rep.obterLivroPorCodigo(codigoLivro);

        new ServicoEmprestimo().realizarEmprestimo(u, l);
    }
    
}