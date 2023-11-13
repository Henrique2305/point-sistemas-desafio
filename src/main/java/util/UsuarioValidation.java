package util;

import model.Endereco;
import model.Usuario;

public class UsuarioValidation {

    public static Usuario transformBOModel(UsuarioBean bean) {

        Usuario usuario = new Usuario();
        Endereco endereco = new Endereco();

        endereco.setRua(bean.getRua());
        endereco.setNumero(bean.getNumero());
        endereco.setCidade(bean.getCidade());
        endereco.setUF(bean.getUF());
        endereco.setComplemento(bean.getComplemento());
        endereco.setCEP(bean.getCEP());

        usuario.setId(bean.getId());
        usuario.setNome(bean.getNome());
        usuario.setEmail(bean.getEmail());
        usuario.setCPF(bean.getCPF());
        usuario.setEndereco(endereco);

        return usuario;
    }

    public static Usuario transformBOModelForUpdate(UsuarioBean bean, Usuario usuario) {
        Endereco endereco = new Endereco();

        endereco.setId(usuario.getEndereco().getId());
        endereco.setRua(bean.getRua().isEmpty() ? usuario.getEndereco().getRua() : bean.getRua());
        endereco.setNumero(bean.getNumero() == null ? usuario.getEndereco().getNumero() : bean.getNumero());
        endereco.setCidade(bean.getCidade().isEmpty() ? usuario.getEndereco().getCidade() : bean.getCidade());
        endereco.setUF(bean.getUF().isEmpty() ? usuario.getEndereco().getUF() : bean.getUF());
        endereco.setComplemento(bean.getComplemento().isEmpty() ? usuario.getEndereco().getComplemento() : bean.getComplemento());
        endereco.setCEP(bean.getCEP().isEmpty() ? usuario.getEndereco().getCEP() : bean.getCEP());

        usuario.setId(bean.getId() == null ? usuario.getId() : bean.getId());
        usuario.setNome(bean.getNome().isEmpty() ? usuario.getNome() : bean.getNome());
        usuario.setEmail(bean.getEmail().isEmpty() ? usuario.getEmail() : bean.getEmail());
        usuario.setCPF(bean.getCPF().isEmpty() ? usuario.getCPF() : bean.getCPF());
        usuario.setEndereco(endereco);

        return usuario;
    }

    public static UsuarioBean transformModelBO(Usuario usuario) {

        UsuarioBean bo = new UsuarioBean();

       bo.setNome(usuario.getNome());
       bo.setEmail(usuario.getEmail());
       bo.setCPF(usuario.getCPF());

        return bo;
    }
}
