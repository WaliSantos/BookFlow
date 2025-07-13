package command;

public class ComandoRegistrarObservador implements IComando {
    private String codigoLivro;
    private String codigoUsuario;
    

    public ComandoRegistrarObservador( String codigoUsuario, String codigoLivro){
        this.codigoLivro = codigoLivro;
        this.codigoUsuario = codigoUsuario; 
    }

    public void executar(){
        
    }
}

