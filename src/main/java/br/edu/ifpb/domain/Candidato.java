package br.edu.ifpb.domain;

import br.edu.ifpb.domain.embeddables.Endereco;
import br.edu.ifpb.enums.Sexo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidato implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String nomeCompleto;
    @Enumerated
    @Column(nullable = false)
    private Sexo sexo;
    @Column(nullable = false)
    private String nacionalidade;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false, unique = true)
    private String telefone;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 30)
    private String senha;
    
    @EmbeddedId
    private Endereco endereco;

}