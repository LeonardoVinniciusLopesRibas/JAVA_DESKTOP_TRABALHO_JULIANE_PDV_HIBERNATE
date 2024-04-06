package trabalho.juliane.pdv.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import trabalho.juliane.pdv.model.Cliente;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-06T08:40:23", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, Double> valorTotalDesconto;
    public static volatile SingularAttribute<Venda, Double> valorTotal;
    public static volatile SingularAttribute<Venda, Integer> qtdItens;
    public static volatile SingularAttribute<Venda, Integer> id;

}