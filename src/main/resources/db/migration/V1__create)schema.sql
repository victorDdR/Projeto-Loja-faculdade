SET FOREIGN_KEY_CHECKS = 0;

-- =========================
-- usuarios
-- =========================
CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
    );

-- =========================
-- produtos
-- =========================
CREATE TABLE IF NOT EXISTS produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    estoque INT NOT NULL,
    categoria VARCHAR(50),
    ativo TINYINT(1) DEFAULT 1
    );

-- =========================
-- pedidos
-- =========================
CREATE TABLE IF NOT EXISTS pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) DEFAULT 'pendente',

    CONSTRAINT fk_pedidos_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES usuarios(id_usuario)
    );

-- =========================
-- itens_pedido
-- =========================
CREATE TABLE IF NOT EXISTS itens_pedido (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_itens_pedido_pedido
    FOREIGN KEY (id_pedido)
    REFERENCES pedidos(id_pedido),
    CONSTRAINT fk_itens_pedido_produto
    FOREIGN KEY (id_produto)
    REFERENCES produtos(id_produto)
    );

SET FOREIGN_KEY_CHECKS = 1;