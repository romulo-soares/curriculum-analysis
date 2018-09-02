package br.edu.ifpb.domain;

import br.edu.ifpb.domain.embeddables.Endereco;
import br.edu.ifpb.enums.TipoEmpresa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Empresa implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private byte[] foto;
    @Column(nullable = false)
    private String nomeFantasia;
    @Column(nullable = false, length = 18)
    private String cnpj;
    @Column(nullable = false)
    private String empresario;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String razaoSocial;
    @Enumerated
    @Column(nullable = false)
    private TipoEmpresa tipoEmpresa;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;

    @EmbeddedId
    private Endereco endereco;

    @OneToMany
    private List<Vaga> vagas;

    public Empresa() {
        this.vagas = new ArrayList<>();
    }

    public boolean addVaga(Vaga vaga) {
        return vagas.add(vaga);
    }

}
