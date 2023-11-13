package util;

import model.Usuario;
import org.primefaces.model.SelectableDataModel;
//import org.primefaces.model.data.ListDataModel;

import javax.faces.model.ListDataModel;
import java.util.List;

public class UsuarioDataModel extends ListDataModel<Usuario> implements SelectableDataModel<Usuario> {

    public UsuarioDataModel() {
    }

    public UsuarioDataModel(List<Usuario> data) {
        super(data);
    }

    @Override
    public Object getRowKey(Usuario usuario) {
        return usuario.getId(); // Substitua 'getId()' pelo método que retorna a chave primária de Usuario
    }

    @Override
    public Usuario getRowData(String rowKey) {
        List<Usuario> usuarios = (List<Usuario>) getWrappedData();
        for (Usuario usuario : usuarios) {
            if (usuario.getId().toString().equals(rowKey)) { // Substitua 'getId()' pelo método que retorna a chave primária de Usuario
                return usuario;
            }
        }
        return null;
    }
}

