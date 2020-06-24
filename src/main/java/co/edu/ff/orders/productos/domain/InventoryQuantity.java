package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.serialization.NumberSerializable;
import com.google.common.base.Preconditions;
import lombok.Value;

@Value(staticConstructor = "of")
public class InventoryQuantity implements NumberSerializable {
    public static InventoryQuantity fromNumber(Number number) {
        return new InventoryQuantity(number.intValue());
    }


    Integer value;

    private InventoryQuantity(Integer value) {
        Preconditions.checkNotNull(value, "Cantidad en inventario No puede ser nulo");
        Preconditions.checkArgument(value > 0, "Cantidad en inventario No puede ser inferior a 0");
        this.value = value;
    }

    @Override
    public Integer valueOf() {
        return value;
    }
}
