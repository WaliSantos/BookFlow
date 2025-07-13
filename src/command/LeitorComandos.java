package command;

import java.util.*;
import java.util.function.Function;

public class LeitorComandos {
    private final Map<String, Function<String[], IComando>> comandosRegistrados = new HashMap<>();

    public LeitorComandos(){
        registrarComandos();
    }
    private void registrarComandos() {
        comandosRegistrados.put("emp", partes -> new ComandoEmprestimo(partes[1], partes[2]));
        comandosRegistrados.put("res", partes -> new ComandoReserva(partes[1], partes[2]));
        comandosRegistrados.put("dev", partes -> new ComandoDevolucao(partes[1], partes[2]));
        comandosRegistrados.put("obs", partes -> new ComandoRegistrarObservador(partes[1], partes[2]));
        comandosRegistrados.put("liv", partes -> new ComandoConsultaLivro(partes[1]));
        comandosRegistrados.put("usu", partes -> new ComandoConsultaUsuario(partes[1]));
        comandosRegistrados.put("ntf", partes -> new ComandoConsultaNotificacoes(partes[1]));
        comandosRegistrados.put("sai", partes -> () -> System.exit(0)); // comando inline
    }

    public void processarLinha(String linha) {
        String[] partes = linha.trim().split("\\s+");
        String cmd = partes[0];

        Function<String[], IComando> fabricaComando = comandosRegistrados.get(cmd);

        if (fabricaComando != null) {
            IComando comando = fabricaComando.apply(partes);
            comando.executar();
        } else {
            System.out.println("Comando inválido: " + cmd);
        }
    }
}
