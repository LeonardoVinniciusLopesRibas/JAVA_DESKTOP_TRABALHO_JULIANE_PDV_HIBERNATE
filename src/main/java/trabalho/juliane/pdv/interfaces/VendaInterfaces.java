package trabalho.juliane.pdv.interfaces;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import trabalho.juliane.pdv.model.Venda;

public interface VendaInterfaces {
    Venda insertVenda(Venda venda, EntityManager em);
    ArrayList<Venda> selectAllVenda();
    Venda selectByIdVenda(int id);
    Venda updateVenda(Venda venda);
    Venda desactivated(Venda venda);
    Venda reativar(Venda venda);
}
