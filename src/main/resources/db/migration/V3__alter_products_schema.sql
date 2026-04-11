ALTER TABLE products
    ADD COLUMN category_id INT DEFAULT 6,
ADD CONSTRAINT fk_product_category
FOREIGN KEY (category_id) REFERENCES categories(category_id);