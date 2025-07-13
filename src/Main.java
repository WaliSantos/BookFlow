import command.LeitorComandos;
import models.*;
import models.usuarios.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repositorio repo = Repositorio.getInstancia();  
        LeitorComandos leitor = new LeitorComandos();
        Scanner scanner = new Scanner(System.in);

        // Usuários
        repo.adicionarUsuario(new AlunoGraduacao("João da Silva","123" ));
        repo.adicionarUsuario(new AlunoPos( "Luiz Fernando Rodrigues","456"));
        repo.adicionarUsuario(new AlunoGraduacao( "Pedro Paulo", "789"));
        repo.adicionarUsuario(new Professor("Carlos Lucena","100" ));

        // Livros

        Livro livro1 = new Livro("100", "Engenharia de Software", "Addison Wesley", "Ian Sommerville", "6ª", 2000);
        Livro livro2 = new Livro("101", "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", 2000);
        Livro livro3 = new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnell", "2ª", 2014);
        Livro livro4 = new Livro("201", "Agile Software Development", "Prentice Hall", "Robert Martin", "1ª", 2002);
       
        // Adicionando livros ao repositório
        repo.adicionarLivro(livro1);
        repo.adicionarLivro(livro2);
        repo.adicionarLivro(livro3);
        repo.adicionarLivro(livro4);

        // Exemplares
        Exemplar exemplar1 = new Exemplar("100", "01");
        Exemplar exemplar2 = new Exemplar("100", "02");
        Exemplar exemplar3 = new Exemplar("101", "03");
        Exemplar exemplar4 = new Exemplar("200", "04");
        Exemplar exemplar5 = new Exemplar("201", "05");

        // Adicionando exemplares 
        livro1.adicionarExemplar(exemplar1);
        livro1.adicionarExemplar(exemplar2);
        livro2.adicionarExemplar(exemplar3);
        livro3.adicionarExemplar(exemplar4);
        livro4.adicionarExemplar(exemplar5);
        
        System.out.println("Bem-vindo ao sistema de gerenciamento de biblioteca!");

        while (true) {
            System.out.print("> ");
            String linha = scanner.nextLine();
            if (linha.equalsIgnoreCase("sair")) 
            {
                System.out.println("Saindo do sistema...");
                scanner.close();
                break; 
            }
            leitor.processarLinha(linha);
        }


    }
}
