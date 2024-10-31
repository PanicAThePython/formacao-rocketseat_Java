import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Cliente> leitores = new ArrayList<>();

    public Biblioteca() {
        Autor veschwab = new Autor(1L, "V. E. Schwab", LocalDate.of(1987, 7, 7));
        Autor rickriordan = new Autor(2L, "Rick Riordan", LocalDate.of(1964, 6, 5));
        autores.add(veschwab);
        autores.add(rickriordan);

        Livro addieLarue = new Livro(1L, "A vida invisível de Addie LaRue",
                autores.get(0), LocalDate.of(2024, 10, 30), LocalDate.of(2024, 10, 30));
        Livro gallant = new Livro(2L, "Mansão Gallant",
                autores.get(0), LocalDate.of(2024, 10, 30), LocalDate.of(2024, 10, 30));

        Livro percy1 = new Livro(3L, "Percy Jackson e o Ladrão de Raios",
                autores.get(1), LocalDate.of(2024, 10, 30), LocalDate.of(2024, 10, 30));
        Livro percy2 = new Livro(4L, "Percy Jackson e o Mar de Monstros",
                autores.get(1), LocalDate.of(2024, 10, 30), LocalDate.of(2024, 10, 30));
        Livro percy3 = new Livro(5L, "Percy Jackson e a Maldição do Titã",
                autores.get(1), LocalDate.of(2024, 10, 30), LocalDate.of(2024, 10, 30));
        Livro percy4 = new Livro(6L, "Percy Jackson e a Batalha do Labirinto",
                autores.get(1), LocalDate.of(2024, 10, 30), LocalDate.of(2024, 10, 30));
        Livro percy5 = new Livro(7L, "Percy Jackson e o Último Olimpiano",
                autores.get(1), LocalDate.of(2024, 10, 30), LocalDate.of(2024, 10, 30));

        livros.add(addieLarue);
        livros.add(gallant);
        livros.add(percy1);
        livros.add(percy2);
        livros.add(percy3);
        livros.add(percy4);
        livros.add(percy5);

        Cliente leitor1 = new Cliente(123456L, "João", "joao@gmail.com");
        Cliente leitor2 = new Cliente(678901L, "Maria", "maria@gmail.com");

        leitores.add(leitor1);
        leitores.add(leitor2);
    }
    public List<Livro> getLivrosDisponiveis(){
        return livros.stream().filter(livro -> livro.disponivel).toList();
    }

    public Livro getLivro(Long idLivro){
        return livros.stream().filter(livro -> livro.id.equals(idLivro)).toList().get(0);
    }

    public Cliente getCliente(Long matricula){
        return (Cliente) leitores.stream().filter(leitor -> leitor.id.equals(matricula)).toList().get(0);
    }

    public void setEmprestimos(Long idLivro, Long idLeitor){
        emprestimos.add(new Emprestimo(idLivro, idLeitor, true));
    }
    public void emprestarLivro(Long matriculaLeitor, Long idLivro){
        Livro livroAEmprestar = getLivro(idLivro);
        Cliente leitor = getCliente(matriculaLeitor);
        setEmprestimos(livroAEmprestar.getId(), leitor.getId());
        livroAEmprestar.setDisponivel(false);
    }
}
