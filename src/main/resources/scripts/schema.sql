CREATE TABLE PRODUCTS
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre               VARCHAR NOT NULL,
    descripcion        VARCHAR NOT NULL,
    precio_base         DECIMAL NOT NULL,
    tasa_de_impuestos           DECIMAL NOT NULL,
    estado             VARCHAR NOT NULL,
    cantidad_de_inventario INT     NOT NULL
);

create table users
(
    username varchar_ignorecase(50) not null primary key,
    password varchar(500)           not null,
    enabled  boolean                not null
);

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities(username, authority);

CREATE TABLE PRODUCTS
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre               VARCHAR NOT NULL,
    descripcion        VARCHAR NOT NULL,
    precio_base         DECIMAL NOT NULL,
    tasa_de_impuestos           DECIMAL NOT NULL,
    estado             VARCHAR NOT NULL,
    cantidad_de_inventario INT     NOT NULL
);
