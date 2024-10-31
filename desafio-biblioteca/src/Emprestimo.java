public class Emprestimo {
    Long idLivro;
    Long idCliente;
    boolean ativo;

    public Emprestimo(Long idLivro, Long idCliente, boolean ativo) {
        this.idLivro = idLivro;
        this.idCliente = idCliente;
        this.ativo = ativo;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
