package co.edu.ff.orders.productos.domain;

import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.UserCreated;
import co.edu.ff.orders.user.domain.Username;

public class SqlProductRepository implements ProductRepository {


    @Override
    public ProductOperation insertOne(ProductOperationRequest productOperationRequest) {
        return null;
    }
}

    @Override
    public UserCreated createOne(Username username, Password password) {
        /*String SQL = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder(); // inicializada {}
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username.getValue());
            ps.setString(2, password.getValue());
            return ps;
        };
