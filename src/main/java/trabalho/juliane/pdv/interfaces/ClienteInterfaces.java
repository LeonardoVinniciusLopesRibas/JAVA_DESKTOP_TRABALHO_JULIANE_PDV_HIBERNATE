package trabalho.juliane.pdv.interfaces;

import java.util.ArrayList;
import trabalho.juliane.pdv.model.Cliente;

public interface ClienteInterfaces {
    Cliente insertCliente(Cliente cliente);
    ArrayList<Cliente> selectAllCliente();
    Cliente selectByIdCliente(int id);
    Cliente updateCliente(Cliente cliente);
    Cliente desactivated(Cliente cliente);
    Cliente reativar(Cliente cliente);
    
}
