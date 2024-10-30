import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    static List<Livro> livros = new ArrayList<>();
    static List<Leitor> leitores = new ArrayList<>();

    public static void main(String[] args) {
        inicializarSistema();
        listarLivros(getLivrosDisponiveis());
        emprestarLivro(123456, "Mansão Gallant");
        listarLivros(getLivrosDisponiveis());
        emprestarLivro(678901, "Percy Jackson e o Ladrão de Raios");
        emprestarLivro(678901, "Percy Jackson e o Mar de Monstros");
        emprestarLivro(678901, "Percy Jackson e a Maldição do Titã");
        listarLivros(getLivrosDisponiveis());
    }

    public static void inicializarSistema(){
        Livro addieLarue = new Livro("A vida invisível de Addie LaRue",
                "V. E. Schwab", "Galera", 2020);
        Livro gallant = new Livro("Mansão Gallant",
                "V. E. Schwab", "Galera", 2022);
        Livro percy1 = new Livro("Percy Jackson e o Ladrão de Raios",
                "Rick Riordan", "Intriseca", 2005);
        Livro percy2 = new Livro("Percy Jackson e o Mar de Monstros",
                "Rick Riordan", "Intriseca", 2006);
        Livro percy3 = new Livro("Percy Jackson e a Maldição do Titã",
                "Rick Riordan", "Intriseca", 2007);
        Livro percy4 = new Livro("Percy Jackson e a Batalha do Labirinto",
                "Rick Riordan", "Intriseca", 2008);
        Livro percy5 = new Livro("Percy Jackson e o Último Olimpiano",
                "Rick Riordan", "Intriseca", 2009);

        livros.add(addieLarue);
        livros.add(gallant);
        livros.add(percy1);
        livros.add(percy2);
        livros.add(percy3);
        livros.add(percy4);
        livros.add(percy5);

        Leitor leitor1 = new Leitor(123456, "João");
        Leitor leitor2 = new Leitor(678901, "Maria");

        leitores.add(leitor1);
        leitores.add(leitor2);
    }

    public static List<Livro> getLivrosDisponiveis(){
        return livros.stream().filter(livro -> livro.disponivel).toList();
    }

    public static Livro getLivro(String nomeLivro){
        return livros.stream().filter(livro -> livro.nome.equalsIgnoreCase(nomeLivro)).toList().get(0);
    }

    public static Leitor getLeitor(Integer matricula){
        return (Leitor) leitores.stream().filter(leitor -> leitor.matricula.equals(matricula)).toList().get(0);
    }

    public static void emprestarLivro(Integer matriculaLeitor, String nomeLivro){
        Livro livroAEmprestar = getLivro(nomeLivro);
        Leitor leitor = getLeitor(matriculaLeitor);
        leitor.setLivrosAlugados(livroAEmprestar);
        livroAEmprestar.setDisponivel(false);
    }

    public static void listarLivros(List<Livro> livrosDisponiveis){
        System.out.println("LIVROS DISPONÍVEIS");
        livrosDisponiveis.forEach(livro -> System.out.println(livro.toString()));
        System.out.println("------------------");
    }
}