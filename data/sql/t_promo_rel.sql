CREATE TABLE T_PROMO_REL (
    promo_id INTEGER NOT NULL,
    product_id INTEGER,
    category_id INTEGER,
    rate_discount DECIMAL(5,4) NOT NULL,
    CONSTRAINT PK_PROMO_REL UNIQUE (promo_id, product_id, category_id),
    FOREIGN KEY (promo_id)
        REFERENCES T_PROMO(id)
        ON DELETE CASCADE,
    FOREIGN KEY (product_id)
        REFERENCES T_PRODUCT(id)
        ON DELETE RESTRICT,
    FOREIGN KEY (category_id)
        REFERENCES T_CATEGORY(id)
        ON DELETE RESTRICT
);

COMMIT;

INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (1, NULL, 1, 0.1);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (2, 10, NULL, 0.05);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (2, 3, NULL, 0.05);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (2, 5, NULL, 0.05);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (2, 53, NULL, 0.05);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (2, 51, NULL, 0.05);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (3, NULL, 7, 0.1);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (3, NULL, 2, 0.1);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (3, NULL, 4, 0.1);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (4, NULL, 7, 0.5);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (5, NULL, 6, 0.75);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (5, NULL, 1, 0.75);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (6, NULL, 3, 0.3);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (7, 51, NULL, 0.6);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (7, 66, NULL, 0.6);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (7, 35, NULL, 0.6);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (7, 88, NULL, 0.6);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (8, NULL, 3, 0.25);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (8, NULL, 6, 0.25);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (9, NULL, 3, 0.15);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (10, NULL, 2, 0.2);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (11, NULL, 5, 0.4);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (11, NULL, 3, 0.4);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (12, NULL, 3, 0.6);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (12, NULL, 1, 0.6);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (13, NULL, 3, 0.7);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (14, NULL, 6, 0.2);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (14, NULL, 2, 0.2);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (15, NULL, 5, 0.4);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (15, NULL, 3, 0.4);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (15, NULL, 7, 0.4);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (15, NULL, 5, 0.4);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (16, NULL, 1, 0.2);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (16, NULL, 6, 0.2);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (16, NULL, 3, 0.2);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (17, NULL, 2, 0.15);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (18, NULL, 2, 0.05);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (18, NULL, 7, 0.05);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (18, NULL, 4, 0.05);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (18, NULL, 3, 0.05);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (19, NULL, 3, 0.1);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (19, NULL, 2, 0.1);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (19, NULL, 5, 0.1);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (20, NULL, 3, 0.8);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (20, NULL, 2, 0.8);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (20, NULL, 1, 0.8);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (21, 63, NULL, 0.65);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (21, 43, NULL, 0.65);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (21, 18, NULL, 0.65);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (21, 73, NULL, 0.65);
INSERT INTO T_PROMO_REL(promo_id, product_id, category_id, rate_discount) VALUES (21, 80, NULL, 0.65);

COMMIT;