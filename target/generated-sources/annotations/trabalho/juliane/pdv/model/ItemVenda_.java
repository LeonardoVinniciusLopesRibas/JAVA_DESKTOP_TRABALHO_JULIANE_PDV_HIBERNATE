package trabalho.juliane.pdv.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import trabalho.juliane.pdv.model.Produto;
import trabalho.juliane.pdv.model.Venda;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-06T08:40:23", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, Venda> venda;
    public static volatile SingularAttribute<ItemVenda, Produto> produto;
    public static volatile SingularAttribute<ItemVenda, Integer> id;
    public static volatile SingularAttribute<ItemVenda, Double> quantidade;

}