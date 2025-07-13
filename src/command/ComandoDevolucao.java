package command;

public class ComandoDevolucao implements IComando {
    private String codigoLivro;
    private String codigoUsuario;
    

    public ComandoDevolucao( String codigoUsuario, String codigoLivro){
        this.codigoLivro = codigoLivro;
        this.codigoUsuario = codigoUsuario; 
    }

    public void executar(){
        
    }
}

