package main.java.com.formulario.backend_pais.dto;

public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private int idade;
    private String endereco;

    public AlunoResponseDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.sobrenome = aluno.getSobrenome();
        this.email = aluno.getEmail();
        this.idade = aluno.getIdade();
        this.endereco = aluno.getEndereco();

        
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

}