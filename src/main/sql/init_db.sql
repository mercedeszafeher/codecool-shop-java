-- Database name: codecoolshop


DROP TABLE IF EXISTS products;
CREATE TABLE products (
                          id serial NOT NULL,
                          name VARCHAR,
                          currency VARCHAR,
                          description VARCHAR,
                          category_id INTEGER,
                          supplier_id INTEGER,
                          image_name VARCHAR,
                          price MONEY
);

DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
                            id serial NOT NULL,
                            name VARCHAR,
                            department VARCHAR,
                            description VARCHAR
);

DROP TABLE IF EXISTS suppliers;
CREATE TABLE suppliers (
                           id serial NOT NULL,
                           name VARCHAR,
                           description VARCHAR
);

DROP TABLE IF EXISTS carts;
CREATE TABLE carts (
                       id serial NOT NULL,
                       user_id INTEGER,
                       cart_product_list_id INTEGER,
                       address VARCHAR,
                       payment_method VARCHAR
);

DROP TABLE IF EXISTS cart_product_list;
CREATE TABLE cart_product_list (
                                   cart_id INTEGER,
                                   product_id INTEGER
);