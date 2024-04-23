package ps2.restapidb;

import javax.persistence.*;

@Entity
@Table(name="hospedes")

public class Hospede {
    @Id@GeneratedValue
    private long id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;

    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
    public String getEmail() {
        return email;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getNome() {
        return nome;
    }
}
