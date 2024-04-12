package trabalho.juliane.pdv.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import trabalho.juliane.pdv.interfaces.VendaInterfaces;
import trabalho.juliane.pdv.model.Venda;

public class VendaDao implements VendaInterfaces {

    private EntityManager em;

    public VendaDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Venda insertVenda(Venda venda, EntityManager em) {

        try {
            EntityTransaction entTrans = em.getTransaction();
            entTrans.begin();
            em.persist(venda);
            entTrans.commit();
            System.out.println("Venda feita com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return venda;
    }

    @Override
    public ArrayList<Venda> selectAllVenda() {

        ArrayList<Venda> vendas = null;

        try {
            TypedQuery<Venda> query = em.createQuery("SELECT v FROM venda v", Venda.class);
            vendas = (ArrayList<Venda>) query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Venda");
        }
        return vendas;
    }

    @Override
    public Venda selectByIdVenda(int id) {
        Venda venda = null;
        try {
            venda = em.find(Venda.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar venda");
        }
        return venda;
    }

    public int getLastInsertedId() {
        int lastId = -1;
        try {
            Query query = em.createQuery("SELECT MAX(v.id) FROM Venda v");
            Object result = query.getSingleResult();
            if (result != null) {
                lastId = (int) result;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o último ID de venda: " + e.getMessage());
        }
        return lastId;
    }

    @Override
    public Venda updateVenda(Venda venda) {
        try {
            em.getTransaction().begin();
            venda = em.merge(venda);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Venda");
        }
        return venda;
    }

    @Override
    public Venda desactivated(Venda venda) {
        try {
            em.getTransaction().begin();
            venda.setAtivo(false);
            venda = em.merge(venda);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Venda desativada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar venda: " + e.getMessage());
        }
        return venda;
    }

    @Override
    public Venda reativar(Venda venda) {

        try {
            em.getTransaction().begin();
            venda.setAtivo(true);
            venda = em.merge(venda);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Venda reativado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao reativar venda");
        }
        return venda;
    }

}
