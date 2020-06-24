package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.serialization.StringSerializable;
import com.google.common.base.Preconditions;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value(staticConstructor = "of")
public class Description implements StringSerializable {
    String value;

    private Description(String value){
        Preconditions.checkNotNull(value, "No puede ser nulo");
        Preconditions.checkArgument(StringUtils.isNoneBlank(value ),"No puede estar vacío");
        Preconditions.checkArgument(value.length() <= 280, "Puede tener máximo 100 caracteres");
        this.value = value;
    }

    @Override
    public String valueOf() {
        return value;
    }
}
