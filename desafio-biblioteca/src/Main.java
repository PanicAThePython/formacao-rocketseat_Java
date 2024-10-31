import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    public static void listarLivros(List<Livro> livrosDisponiveis){
        System.out.println("LIVROS DISPONÍVEIS");
        livrosDisponiveis.forEach(livro -> System.out.println(livro.toString()));
        System.out.println("------------------");
    }
    public static void main(String[] args) {
        boolean ligado = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindx! Qual o seu nome?");
        String nome = scanner.nextLine();
        System.out.println("Legal! E sua matricula?");
        Long matricula = Long.parseLong(scanner.nextLine());

        System.out.println(format("Olá, %s! O que desejas fazer?", nome));

        while (ligado){

            System.out.println("1 - visualizar livros disponíveis");
            System.out.println("2 - pegar livro emprestado");
            System.out.println("3 - encerrar atendimento");
            Integer acao = Integer.parseInt(scanner.nextLine());

            switch (acao){
                case 1:
                    listarLivros(biblioteca.getLivrosDisponiveis());
                    break;
                case 2:
                    System.out.println("Informe o id do livro que deseja: ");
                    Long idLivro = Long.parseLong(scanner.nextLine());
                    Cliente usuario = biblioteca.getCliente(matricula);
                    biblioteca.emprestarLivro(matricula, idLivro);
                    System.out.println("Livro emprestado com sucesso!");
                    listarLivros(biblioteca.getLivrosDisponiveis());
                    break;
                case 3:
                    System.out.println("Até a próxima!");
                    ligado = false;
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        }
    }
}