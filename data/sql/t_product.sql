CREATE TABLE T_PRODUCT (
    id INTEGER NOT NULL,
    category_id INTEGER,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(16,2) NOT NULL,
    desc_product VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (category_id)
        REFERENCES T_CATEGORY(id)
        ON DELETE SET NULL
);

COMMIT;

INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (1, 1, 'cg1', 59.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (2, 1, 'cg2', 79.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (3, 1, 'cg3', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (4, 1, 'cg4', 119.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (5, 1, 'cg5', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (6, 1, 'cg6', 200, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (7, 1, 'cg7', 59.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (8, 1, 'cg8', 79.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (9, 1, 'cg9', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (10, 1, 'cg10', 119.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (11, 1, 'cg11', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (12, 1, 'cg12', 59.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (13, 1, 'cg13', 79.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (14, 1, 'cg14', 49.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (15, 1, 'cg15', 119.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (16, 1, 'cg16', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (17, 1, 'cg17', 59.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (18, 1, 'cg18', 79.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (19, 1, 'cg19', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (20, 1, 'cg20', 119.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (21, 1, 'cg21', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (22, 1, 'cg22', 59.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (23, 1, 'cg23', 79.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (24, 1, 'cg24', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (25, 1, 'cg25', 119.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (26, 1, 'cg26', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (27, 1, 'cg27', 59.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (28, 1, 'cg28', 79.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (29, 1, 'cg29', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (30, 1, 'cg30', 119.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (31, 1, 'cg31', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (32, 1, 'cg32', 59.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (33, 1, 'cg33', 79.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (34, 1, 'cg34', 59.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (35, 1, 'cg35', 79.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (36, 1, 'cg36', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (37, 1, 'cg37', 119.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (38, 1, 'cg38', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (39, 2, 'ctrl1', 199.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (40, 2, 'ctrl2', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (41, 2, 'ctrl3', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (42, 2, 'ctrl4', 199.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (43, 2, 'ctrl5', 79.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (44, 2, 'ctrl6', 79.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (45, 2, 'ctrl7', 79.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (46, 2, 'ctrl8', 59.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (47, 2, 'ctrl9', 59.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (48, 2, 'ctrl10', 59.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (49, 2, 'ctrl11', 59.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (50, 3, 'graph1', 1299.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (51, 3, 'graph2', 1459, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (52, 3, 'graph3', 2599, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (53, 3, 'graph4', 4899, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (54, 3, 'graph5', 1249, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (55, 3, 'graph6', 899, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (56, 4, 'chr1', 1399, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (57, 4, 'chr2', 669, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (58, 4, 'chr3', 799, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (59, 4, 'chr4', 1699, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (60, 4, 'chr5', 1199, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (61, 5, 'bk1', 69.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (62, 5, 'bk2', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (63, 5, 'bk3', 32.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (64, 5, 'bk4', 69.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (65, 5, 'bk5', 49.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (66, 5, 'bk6', 32.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (67, 5, 'bk7', 69.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (68, 5, 'bk8', 69.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (69, 5, 'bk9', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (70, 5, 'bk10', 32.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (71, 5, 'bk11', 69.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (72, 5, 'bk12', 69.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (73, 5, 'bk13', 49.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (74, 5, 'bk14', 69.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (75, 5, 'bk15', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (76, 5, 'bk16', 32.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (77, 6, 'sha1', 299.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (78, 6, 'sha2', 599.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (79, 6, 'sha3', 129.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (80, 6, 'sha4', 149.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (81, 6, 'sha5', 69.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (82, 6, 'sha6', 69.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (83, 6, 'sha7', 49.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (84, 6, 'sha8', 69.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (85, 6, 'sha9', 49.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (86, 6, 'sha10', 32.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (87, 6, 'sha11', 299.99, 'Sample description.');
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (88, 7, 'spkr1', 599.99, NULL);
INSERT INTO T_PRODUCT (id, category_id, name, price, desc_product) VALUES (89, 7, 'spkr2', 499.99, 'Sample description.');

COMMIT;