package co.edu.ff.orders.productos.exceptions;

import co.edu.ff.orders.productos.domain.Description;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class ProductDoesNotExists extends ProductException {

    long productId;

  public ProductDoesNotExists(long productId) {
      super("El producto con ID: " + productId + " no existe");
      this.productId = productId;
    }


}
