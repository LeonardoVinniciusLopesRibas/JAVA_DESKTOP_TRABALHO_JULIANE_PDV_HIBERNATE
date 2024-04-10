package trabalho.juliane.pdv.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import trabalho.juliane.pdv.interfaces.ProdutoInterfaces;
import trabalho.juliane.pdv.model.Produto;

public class ProdutoDao implements ProdutoInterfaces{
    
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Produto insertProduto(Produto produto) {

        try{
            EntityTransaction entTrans = em.getTransaction();
            entTrans.begin();
            em.persist(produto);
            entTrans.commit();
            em.close();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return produto;
    }

    @Override
    public ArrayList<Produto> selectAllProduto() {

        ArrayList<Produto> produtos = null;
        try {
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
            produtos = (ArrayList<Produto>) query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar todos os itens de venda: " + e.getMessage());
            System.out.println(e.getMessage());
        }
        return produtos;

    }

    @Override
    public Produto selectByIdProduto(int id) {

        Produto produto = null;
        try {
            produto = em.find(Produto.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o item de venda pelo ID: " + e.getMessage());
        }
        return produto;
    }
    
    public Produto selectByCodigoRapidoProduto(String codigorapido){
        Produto produto = null;
        try{
            produto = em.find(Produto.class, codigorapido);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar o produto pelo codigo rapido"+e.getMessage());
        }
        return produto;
    }

    @Override
    public Produto updateProduto(Produto produto) {
        
        try {
            em.getTransaction().begin();
            produto = em.merge(produto);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o item de venda: " + e.getMessage());
        }
        return produto;
    }

    @Override
    public Produto desactivated(Produto produto) {

        try {
            em.getTransaction().begin();
            produto.setAtivo(false);
            produto = em.merge(produto);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Produto desativado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar o item de venda: " + e.getMessage());
        }
        return produto;
    }

    @Override
    public Produto reativar(Produto produto) {

        try {
            em.getTransaction().begin();
            produto.setAtivo(true);
            produto = em.merge(produto);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Produto reativado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar o item de venda: " + e.getMessage());

        }
        return produto;
    }
    
    
    
}
