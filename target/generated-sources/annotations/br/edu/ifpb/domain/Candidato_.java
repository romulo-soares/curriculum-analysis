package br.edu.ifpb.domain;

import br.edu.ifpb.enums.Sexo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-02T08:35:09")
@StaticMetamodel(Candidato.class)
public class Candidato_ { 

    public static volatile SingularAttribute<Candidato, Integer> idade;
    public static volatile SingularAttribute<Candidato, String> senha;
    public static volatile SingularAttribute<Candidato, String> telefone;
    public static volatile SingularAttribute<Candidato, Integer> id;
    public static volatile SingularAttribute<Candidato, Sexo> sexo;
    public static volatile SingularAttribute<Candidato, String> nacionalidade;
    public static volatile SingularAttribute<Candidato, String> email;
    public static volatile SingularAttribute<Candidato, String> nomeCompleto;

}