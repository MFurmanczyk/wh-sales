CREATE TABLE T_CATEGORY (
    id INTEGER NOT NULL,
    name VARCHAR(100) NOT NULL,
    desc_category VARCHAR(500),
    type_liquidity INTEGER(1) ZEROFILL NOT NULL, /* 1 - high,  2 - medium, 3 - low, 0 - unknown*/
    PRIMARY KEY (id)
);

COMMIT;

INSERT INTO T_CATEGORY (id, name, desc_category, type_liquidity) VALUES (1, 'Computer Games', 'Sample description.', 1);
INSERT INTO T_CATEGORY (id, name, desc_category, type_liquidity) VALUES (2, 'Game Controllers', 'Sample description.', 2);
INSERT INTO T_CATEGORY (id, name, desc_category, type_liquidity) VALUES (3, 'Graphics Cards', NULL, 1);
INSERT INTO T_CATEGORY (id, name, desc_category, type_liquidity) VALUES (4, 'Gaming Chairs', NULL, 3);
INSERT INTO T_CATEGORY (id, name, desc_category, type_liquidity) VALUES (5, 'Books', NULL, 2);
INSERT INTO T_CATEGORY (id, name, desc_category, type_liquidity) VALUES (6, 'Smart Home', 'Sample description.', 2);
INSERT INTO T_CATEGORY (id, name, desc_category, type_liquidity) VALUES (7, 'Speakers', NULL, 0);

COMMIT;