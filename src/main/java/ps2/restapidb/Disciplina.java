package ps2.restapidb;

public class Disciplina {
    private long id;
    private String nome;
    private int cargaHoraria;

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public String getNome() {
        return nome;
    }
}
