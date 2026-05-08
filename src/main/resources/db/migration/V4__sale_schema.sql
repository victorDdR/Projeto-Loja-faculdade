CREATE TABLE sales (
    sale_id BIGINT NOT NULL AUTO_INCREMENT,
    sale_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2)  NOT NULL,

    PRIMARY KEY (sale_id)
);

CREATE TABLE sale_items (
    item_id BIGINT NOT NULL AUTO_INCREMENT,
    sale_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    total_price DECIMAL(10,2) NOT NULL

    PRIMARY KEY (item_id),
    FOREIGN KEY (sale_id) REFERENCES sales(sale_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE INDEX idx_items_sale ON sale_items(sale_id);