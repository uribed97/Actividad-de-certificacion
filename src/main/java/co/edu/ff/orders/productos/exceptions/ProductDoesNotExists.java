package co.edu.ff.orders.productos.exceptions;

import co.edu.ff.orders.productos.domain.Description;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class ProductDoesNotExists extends ProductException {

    Description description;

  public ProductDoesNotExists(Description descripcion) {
      super("El producto no existe");
      this.description = description;
    }


}
