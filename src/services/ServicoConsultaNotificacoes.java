package services;

import models.usuarios.Usuario;

public class ServicoConsultaNotificacoes {
    public ServicoConsultaNotificacoes() {}
    public void realizarConsultaNotificacoes(Usuario usuario) {
        System.out.println("Total de notificações: " + usuario.getTotalNotificacoes());
    }
}
