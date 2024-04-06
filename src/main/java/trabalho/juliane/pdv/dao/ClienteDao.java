package trabalho.juliane.pdv.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import trabalho.juliane.pdv.interfaces.ClienteInterfaces;
import trabalho.juliane.pdv.model.Cliente;

public class ClienteDao implements ClienteInterfaces {

    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Cliente insertCliente(Cliente cliente) {
        try {
            EntityTransaction entTrans = em.getTransaction();
            entTrans.begin();
            em.persist(cliente);
            entTrans.commit();
            em.close();
            JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> selectAllCliente() {
        ArrayList<Cliente> clientes = null;
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM cliente c", Cliente.class);
            clientes = (ArrayList<Cliente>) query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public Cliente selectByIdCliente(int id) {

        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por ID: " + e.getMessage());
        }
        return cliente;

    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        try {
            em.getTransaction().begin();
            cliente = em.merge(cliente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + e.getMessage());
        }
        return cliente;
    }

    @Override
    public Cliente desactivated(Cliente cliente) {
        try {
            em.getTransaction().begin();
            cliente.setAtivo(false);
            cliente = em.merge(cliente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Cliente desativado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar cliente: " + e.getMessage());
        }
        return cliente;
    }

    @Override
    public Cliente reativar(Cliente cliente) {
        try {
            em.getTransaction().begin();
            cliente.setAtivo(true);
            cliente = em.merge(cliente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Cliente reativado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao reativar cliente: " + e.getMessage());
        }
        return cliente;

    }

}
