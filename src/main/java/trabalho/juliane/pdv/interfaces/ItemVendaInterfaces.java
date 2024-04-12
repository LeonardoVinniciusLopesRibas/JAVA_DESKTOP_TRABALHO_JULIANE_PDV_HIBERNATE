package trabalho.juliane.pdv.interfaces;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import trabalho.juliane.pdv.model.ItemVenda;

public interface ItemVendaInterfaces {
    ItemVenda insertItemVenda(ItemVenda itemVenda, EntityManager em);
    ArrayList<ItemVenda> selectAllItemVenda();
    ItemVenda selectByIdItemVenda(int id);
    ItemVenda updateItemVenda(ItemVenda itemVenda);
    ItemVenda desactivated(ItemVenda itemVenda);
    ItemVenda reativar(ItemVenda itemVenda);
}
