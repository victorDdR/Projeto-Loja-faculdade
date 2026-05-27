ALTER TABLE categories
    ADD CONSTRAINT uq_category_name UNIQUE (category_name);

ALTER TABLE products
    ADD CONSTRAINT uq_product_name UNIQUE (product_name);