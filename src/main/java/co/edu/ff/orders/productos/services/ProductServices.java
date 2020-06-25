package co.edu.ff.orders.productos.services;

import co.edu.ff.orders.productos.domain.*;
import co.edu.ff.orders.productos.exceptions.ProductDoesNotExists;
import co.edu.ff.orders.user.domain.*;
import co.edu.ff.orders.user.exceptions.UserAlreadyExistsException;
import co.edu.ff.orders.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class ProductServices {

    private final ProductRepository repository;

    @Autowired
    public ProductServices(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductOperation insertOne(ProductOperationRequest productOperationRequest) {
        Optional<Product> product = repository.findByName(productOperationRequest.getName());
        if(product.isPresent()){
            UserAlreadyExistsException exception = UserAlreadyExistsException.of(username); // TODO
            return ProductOperationFailure.of(exception);
        } else {
            Product createdProduct = repository.insertOne(productOperationRequest);
            return ProductOperationSuccess.of(createdProduct);
        }

    }

    public ProductOperation findById(Long id) {

        Optional<Product> product = repository.findById(id);
        if(product.isPresent()){
            return ProductOperationSuccess.of(product);
        } else {
            return ProductOperationFailure.of(new ProductDoesNotExists(id));
        }
    }
}
