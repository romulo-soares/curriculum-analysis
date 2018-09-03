package br.edu.ifpb.controller;

import br.edu.ifpb.abstraction.EmpresaService;
import br.edu.ifpb.domain.Empresa;
import br.edu.ifpb.domain.embeddables.Endereco;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;
import lombok.Data;

@Named
@RequestScoped
@Data
public class EmpresaController {
    
    private Part foto;
    private Empresa empresa;
    private Endereco endereco;

    @EJB
    private EmpresaService empresaService;

    @PostConstruct
    public void initObjects() {
        this.empresa = new Empresa();
        this.endereco = new Endereco();
    }

    public String save() throws IOException {
        if (empresaService.isRegistered(empresa.getEmail())) {
            mensagemErro("Cadastro Empresa", "Já existe uma empresa "
                    + "cadastrada com o e-mail informado!");
            return null;
        } else {
            byte[] arrayFoto = new byte[(int) foto.getSize()];
            foto.getInputStream().read(arrayFoto);
            empresa.setFoto(arrayFoto);
            
            
            empresa.setEndereco(endereco);
            empresaService.save(empresa);
            return "login.xhtml";
        }
    }

    public void mensagemErro(String titlePag, String content) {
        FacesMessage mensagemDeErro = new FacesMessage(content);
        mensagemDeErro.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(titlePag, mensagemDeErro);
    }

    public List<Enum> optionsTipoEmpresa() {
        return empresaService.getOptionsTipoEmpresa();
    }
}