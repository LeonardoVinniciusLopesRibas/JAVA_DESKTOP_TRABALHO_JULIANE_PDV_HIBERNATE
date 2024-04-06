package trabalho.juliane.pdv.interfaces;

import java.util.ArrayList;
import trabalho.juliane.pdv.model.Produto;

public interface ProdutoInterfaces {
    Produto insertProduto (Produto produto);
    ArrayList<Produto> selectAllProduto();
    Produto selectByIdProduto(int id);
    Produto updateProduto(Produto produto);
    Produto desactivated(Produto produto);
    Produto reativar(Produto produto);
}
