package command;

public class ComandoReserva implements IComando {
    private String codigoLivro;
    private String codigoUsuario;
    

    public ComandoReserva( String codigoUsuario, String codigoLivro){
        this.codigoLivro = codigoLivro;
        this.codigoUsuario = codigoUsuario; 
    }

    public void executar(){
        
    }
}
