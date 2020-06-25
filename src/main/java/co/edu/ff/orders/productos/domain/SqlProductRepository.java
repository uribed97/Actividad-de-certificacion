package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.UserCreated;
import co.edu.ff.orders.user.domain.Username;
import co.edu.ff.orders.user.exceptions.UserAlreadyExistsException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SqlProductRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;


    public SqlProductRepository(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
    }

    private final RowMapper<Product> rowMapper = (resultSet, i) -> { // TODO
        Long id1 = resultSet.getLong("ID");
        Username username = Username.of(resultSet.getString("USERNAME"));
        Password password = Password.of(resultSet.getString("PASSWORD"));
        return Product.of(username, password, id1);
    };

    @Override
    public Product insertOne(ProductOperationRequest productOperationRequest) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("NOMBRE", productOperationRequest.name.valueOf());
        parameters.put("DESCRIPTION", productOperationRequest.description.valueOf());
        parameters.put("PRECIO_BASE", productOperationRequest.basePrice.valueOf());
        parameters.put("TASA_DE_IMPUESTOS", productOperationRequest.taxRate.valueOf());
        parameters.put("ESTADO", productOperationRequest.productStatus.toString());
        parameters.put("CANTIDAD_DE_INVENTARIO", productOperationRequest.inventoryQuantity.valueOf());

        Number number = simpleJdbcInsert.executeAndReturnKey(parameters);
        long id = number.longValue();


        return Product.of(id, productOperationRequest.name,
                productOperationRequest.description,
                productOperationRequest.basePrice,
                productOperationRequest.taxRate,
                productOperationRequest.productStatus,
                productOperationRequest.inventoryQuantity);

    }

    @Override
    public Optional<Product> findById(Long id) {
        String SQL = "SELECT ID, USERNAME, PASSWORD FROM USERS WHERE ID = ?"; // TODO
        Object[] objects = {id};

        try {
            Product product = jdbcTemplate.queryForObject(SQL, objects, rowMapper);
            return Optional.ofNullable(product);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public Optional<Product> findByName(Name name) { // TODO
        return null;
    }

}