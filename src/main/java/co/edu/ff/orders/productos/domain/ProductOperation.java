package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.productos.exceptions.ProductException;
import co.edu.ff.orders.user.domain.UserCreated;

public interface ProductOperation {
    Product value();

    ProductException failure();

    Boolean isValid();
}