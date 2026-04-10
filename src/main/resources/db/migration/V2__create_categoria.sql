CREATE TABLE categories (
   category_id INT NOT NULL AUTO_INCREMENT,
   category_name VARCHAR(100) NOT NULL,
   deleted BOOLEAN NOT NULL DEFAULT FALSE,
   PRIMARY KEY (id),
   UNIQUE (nome),
   INDEX idx_nome (nome)
);