package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.serialization.NumberSerializable;
import com.google.common.base.Preconditions;
import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class BasePrice implements NumberSerializable {
    public static BasePrice fromNumber(Number number) {
        return new BasePrice(BigDecimal.valueOf(number.doubleValue()));
    }

    BigDecimal value;

    private BasePrice(BigDecimal value) {
        Preconditions.checkNotNull(value, "Precio Base No puede ser nulo");
        Preconditions.checkArgument(value.compareTo(BigDecimal.ZERO) >= 0, "Precio Base No puede ser inferior a 0");
        this.value = value;
    }

    @Override
    public BigDecimal valueOf() {
        return value;
    }
}