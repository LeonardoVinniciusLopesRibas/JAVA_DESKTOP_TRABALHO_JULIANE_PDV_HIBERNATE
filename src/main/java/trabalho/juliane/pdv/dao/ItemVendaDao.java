package trabalho.juliane.pdv.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import trabalho.juliane.pdv.interfaces.ItemVendaInterfaces;
import trabalho.juliane.pdv.model.ItemVenda;

public class ItemVendaDao implements ItemVendaInterfaces {

    private EntityManager em;

    public ItemVendaDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public ItemVenda insertItemVenda(ItemVenda itemVenda, EntityManager em) {
    try {
        EntityTransaction entTrans = em.getTransaction();
        entTrans.begin();
        em.persist(itemVenda);
        entTrans.commit();
        System.out.println("Item de venda inserido com sucesso");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return itemVenda;
}

    @Override
    public ArrayList<ItemVenda> selectAllItemVenda() {
        ArrayList<ItemVenda> itensVenda = null;
        try {
            TypedQuery<ItemVenda> query = em.createQuery("SELECT iv FROM ItemVenda iv", ItemVenda.class);
            itensVenda = (ArrayList<ItemVenda>) query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar todos os itens de venda: " + e.getMessage());
        }
        return itensVenda;
    }

    @Override
    public ItemVenda selectByIdItemVenda(int id) {
        ItemVenda itemVenda = null;
        try {
            itemVenda = em.find(ItemVenda.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o item de venda pelo ID: " + e.getMessage());
        }
        return itemVenda;

    }

    @Override
    public ItemVenda updateItemVenda(ItemVenda itemVenda) {
        try {
            em.getTransaction().begin();
            itemVenda = em.merge(itemVenda);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o item de venda: " + e.getMessage());
        }
        return itemVenda;

    }

    @Override
    public ItemVenda desactivated(ItemVenda itemVenda) {
        try {
            em.getTransaction().begin();
            itemVenda.setAtivo(false);
            itemVenda = em.merge(itemVenda);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar o item de venda: " + e.getMessage());
        }
        return itemVenda;

    }

    @Override
    public ItemVenda reativar(ItemVenda itemVenda) {
        try {
            em.getTransaction().begin();
            itemVenda.setAtivo(true);
            itemVenda = em.merge(itemVenda);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao reativar o item de venda: " + e.getMessage());
        }
        return itemVenda;
    }

}
