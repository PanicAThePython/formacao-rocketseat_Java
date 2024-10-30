public class Livro {
    String nome;
    String autorNome;
    String editora;
    Integer anoLancamento;
    boolean disponivel;
    String identificador;

    public Livro(String nome, String autorNome, String editora, Integer anoLancamento) {
        this.nome = nome;
        this.autorNome = autorNome;
        this.editora = editora;
        this.anoLancamento = anoLancamento;
        this.disponivel = true;
        this.identificador = nome + "_" + autorNome;
    }

    @Override
    public String toString() {
        return "Livro: " + nome +
                ", escrito por " + autorNome +
                ", da editora " + editora +
                ", lançado em " + anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
}
