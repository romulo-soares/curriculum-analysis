package br.edu.ifpb.domain;

import br.edu.ifpb.enums.Origem;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Atitude implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String atitude;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Origem origem;
    
    public Atitude(String atitude, Origem origem){
        this.atitude = atitude;
        this.origem = origem;
    }
            
}