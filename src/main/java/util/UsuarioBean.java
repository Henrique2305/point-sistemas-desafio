package util;

import dao.UsuarioDAO;
import model.Endereco;
import model.Usuario;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;


@ManagedBean(name = "helloworld")
public class UsuarioBean implements Serializable {

    private Long id;

    private String nome;

    private String email;

    private String CPF;

    private Usuario usuario;

    private Endereco endereco;

    private String rua;

    private Integer numero;

    private String cidade;

    private String UF;

    private String complemento;

    private String CEP;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUF() {
        return UF;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getMessage() {
        return "Cadastro";
    }

    public String navigateIndex() {
        return "index.xhtml";
    }

    public String navigateCreate() {
        return "insert.xhtml";
    }

    public String navigateUpdate() {
        return "update.xhtml";
    }

    public void cleanBean() {
        this.id = null;

        this.nome = null;

        this.email = null;

        this.CPF = null;

        this.usuario = null;

        this.endereco = null;

        this.rua = null;

        this.numero = null;

        this.cidade = null;

        this.UF = null;

        this.complemento = null;

        this.CEP = null;
    }


    public String createUsuario() {
        try{
            Usuario usuarioModel  =  UsuarioValidation.transformBOModel(this);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.createUsuario(usuarioModel);
        }catch(Exception e){
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String deleteUsuario(Long id){

        String str = "index";

        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.deleteUsuario(id);
        }catch(Exception e){
        }

        return str;
    }

    public String  editUsuario() {
        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.getUsuarioById(this.getId());
            Usuario usuarioModel  =  UsuarioValidation.transformBOModelForUpdate(this, usuario);
            usuarioDAO.updateUsuario(usuarioModel);
            cleanBean();
        }catch(Exception e){
        }

        return "index.xhtml?faces-redirect=true";
    }

    public List<Usuario> getListaUsuarios() {
         UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.listUsuarios();
    }

}