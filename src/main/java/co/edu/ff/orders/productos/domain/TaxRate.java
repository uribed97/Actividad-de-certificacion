package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.serialization.NumberSerializable;
import com.google.common.base.Preconditions;
import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class TaxRate implements NumberSerializable {
    public static TaxRate fromNumber(Number number) {
        return new TaxRate(BigDecimal.valueOf(number.doubleValue()));
    }


    BigDecimal value;

    private TaxRate(BigDecimal value) {
        Preconditions.checkNotNull(value, "Tasa de impuestos No puede ser nulo");
        Preconditions.checkArgument(value.compareTo(BigDecimal.ZERO) >= 0, "Tasa de impuestos No puede ser inferior a 0");
        Preconditions.checkArgument(value.compareTo(BigDecimal.ONE) <= 0, "Tasa de impuestos No puede ser superior a 1");
        this.value = value;
    }

    @Override
    public BigDecimal valueOf() {
        return value;
    }
}
