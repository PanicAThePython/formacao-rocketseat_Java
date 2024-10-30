import java.util.ArrayList;
import java.util.List;

public class Leitor {
    Integer matricula;
    String nome;
    List<Livro> livrosAlugados = new ArrayList<>();

    public Leitor(Integer matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLivrosAlugados(Livro livro){
        this.livrosAlugados.add(livro);
    }

    public void removeLivrosAlugados(String id){
        Livro devolverLivro = (Livro) livrosAlugados.stream().filter(livro -> livro.identificador.equals(id));
        livrosAlugados.remove(devolverLivro);
    }
}
