package dao;

import model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class UsuarioDAO {

    public void createUsuario(Usuario usuario) throws Exception{
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Erro ao criar o usuário");
        } finally {
            session.flush();
            session.close();
        }
    }

    public Usuario getUsuarioById(Long id) {
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            usuario = (Usuario) session.get(Usuario.class, id);
        } finally {
            session.close();
        }
        return usuario;
    }


    public void deleteUsuario(Long id) throws Exception{
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Usuario usuario = (Usuario) session.load(Usuario.class, new Long(id));
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Erro ao excluir usuário");
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<Usuario> listUsuarios() {
        List<Usuario> usuarios = null;
        Transaction transaction = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            usuarios = session.createNativeQuery("SELECT * FROM usuario", Usuario.class).list();

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return usuarios;
    }

    public void updateUsuario(Usuario usuario) throws Exception{
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(usuario);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Erro ao atualizar usuário. ID do usuário: " + usuario.getId(), e);
        } finally {
            session.flush();
            session.close();
        }
    }


}
