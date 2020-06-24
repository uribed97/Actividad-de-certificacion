package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.productos.exceptions.ProductException;

public class ProductOperationSuccess implements ProductOperation {

    Product product;

    @Override
    public Product value() {
        return null;
    }

    @Override
    public ProductException failure() {
        return null;
    }

    @Override
    public Boolean isValid() {
        return null;


    }
}
