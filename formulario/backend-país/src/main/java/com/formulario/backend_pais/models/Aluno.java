package main.java.com.formulario.backend_pais.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 50, message = "Nome deve ter entre 2 e 50 caracteres")
    private String nome;
    
    @NotBlank(message = "Sobrenome é obrigatório")
    @Size(min = 2, max = 100, message = "Sobrenome deve ter entre 2 e 100 caracteres")
    private String sobrenome;
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Column(unique = true)
    private String email;
    
    @Min(value = 1, message = "Idade deve ser maior que 0")
    @Max(value = 120, message = "Idade deve ser menor que 120")
    private int idade;
    
    @NotBlank(message = "Endereço é obrigatório")
    @Size(max = 200, message = "Endereço deve ter no máximo 200 caracteres")
    private String endereco;
    
    // Construtores
    public Aluno() {}
    
    public Aluno(String nome, String sobrenome, String email, int idade, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idade = idade;
        this.endereco = endereco;
    }
    
    // Getters e Setters
    // ... (implementar todos os getters e setters)
}