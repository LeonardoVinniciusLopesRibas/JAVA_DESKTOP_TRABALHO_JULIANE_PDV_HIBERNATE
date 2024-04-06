package trabalho.juliane.pdv.interfaces;

import java.util.ArrayList;
import trabalho.juliane.pdv.model.Venda;

public interface VendaInterfaces {
    Venda insertVenda(Venda venda);
    ArrayList<Venda> selectAllVenda();
    Venda selectByIdVenda(int id);
    Venda updateVenda(Venda venda);
    Venda desactivated(Venda venda);
    Venda reativar(Venda venda);
}
