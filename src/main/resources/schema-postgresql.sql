CREATE TABLE IF NOT EXISTS pessoa (
     id SERIAL PRIMARY KEY,
     nome VARCHAR(123),
     email VARCHAR(123)
);

CREATE TABLE IF NOT EXISTS item (
     id SERIAL PRIMARY KEY,
     nome VARCHAR(123),
     descricao TEXT
);

CREATE TABLE IF NOT EXISTS pessoa_item (
     id SERIAL PRIMARY KEY,
     pessoa_id INT NOT NULL,
     item_id INT NOT NULL,

     FOREIGN KEY (pessoa_id) REFERENCES pessoa(id) ON DELETE CASCADE,
     FOREIGN KEY (item_id) REFERENCES item(id)
);