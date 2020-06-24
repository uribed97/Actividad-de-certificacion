package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.serialization.NumberSerializable;
import com.google.common.base.Preconditions;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductId implements NumberSerializable {
    public static ProductId fromNumber(Number number) {
        return new ProductId(number.longValue());
    }

    Long value;

    private ProductId(Long value) {
        Preconditions.checkNotNull(value, "value No puede estar nulo");
        Preconditions.checkArgument(value >= 1, "value Debe ser superior a 1");
        this.value = value;
    }

    @Override
    public Number valueOf() {
        return value;
    }
}
