DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS product_list_orders;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS ordersordersusers;


CREATE TABLE users (
						   id INT NOT NULL AUTO_INCREMENT,
						   username VARCHAR(200) NOT NULL,
						   password VARCHAR(200) NOT NULL,
						   PRIMARY KEY(id)
);

CREATE TABLE product_list_orders (
                              id INT NOT NULL AUTO_INCREMENT,
                              user_id INT,
                              PRIMARY KEY(id),
                              FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE product (
                           id INT NOT NULL AUTO_INCREMENT,
                           product_name VARCHAR(200) NOT NULL,
                           unit_price INT NOT NULL,
                           quantity INT NOT NULL,
                           created_date DATE,
                           id_product_list INT,
						   PRIMARY KEY(id),
                           FOREIGN KEY (id_product_list) REFERENCES product_list_orders(id)
);

CREATE TABLE orders (
                        id INT NOT NULL AUTO_INCREMENT,
                        name_client VARCHAR(200),
                        total_price DOUBLE NOT NULL,
                        created_date DATE,
                        id_product_list INT,
						PRIMARY KEY(id),
                        FOREIGN KEY (id_product_list) REFERENCES product_list_orders(id)
);
