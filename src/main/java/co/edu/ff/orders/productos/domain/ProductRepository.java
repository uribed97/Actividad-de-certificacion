package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.UserCreated;
import co.edu.ff.orders.user.domain.Username;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository {
    Product insertOne(ProductOperationRequest productOperationRequest);


    Optional<Product> findById(Long id);

    Optional<Product> findByName(Name name);

    //Optional<UserCreated> findByUsername(Username username);
}

