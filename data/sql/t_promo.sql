CREATE TABLE T_PROMO (
    id INTEGER NOT NULL,
    name VARCHAR(100) NOT NULL,
    desc_promo VARCHAR(500),
    date_start DATE NOT NULL,
    date_end DATE NOT NULL,
    PRIMARY KEY (id)
);

COMMIT;

INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (1, 'promo1', 'Sample description.', '2014-01-01', '2014-01-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (2, 'promo2', 'Sample description.', '2014-04-01', '2014-04-30');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (3, 'promo3', NULL, '2014-05-01', '2014-07-14');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (4, 'promo4', NULL, '2014-12-01', '2014-12-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (5, 'promo5', 'Sample description.', '2015-01-01', '2015-01-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (6, 'promo6', 'Sample description.', '2015-04-01', '2015-04-30');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (7, 'promo7', 'Sample description.', '2015-07-01', '2015-07-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (8, 'promo8', NULL, '2015-10-01', '2015-10-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (9, 'promo9', 'Sample description.', '2016-01-01', '2016-01-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (10, 'promo10', 'Sample description.', '2016-04-01', '2016-04-30');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (11, 'promo11', NULL, '2016-05-01', '2016-07-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (12, 'promo12', NULL, '2016-10-01', '2016-10-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (13, 'promo13', NULL, '2017-01-01', '2017-01-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (14, 'promo14', 'Sample description.', '2017-04-01', '2017-04-30');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (15, 'promo15', 'Sample description.', '2018-07-01', '2017-07-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (16, 'promo16', 'Sample description.', '2017-10-01', '2017-10-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (17, 'promo17', NULL, '2018-01-01', '2018-01-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (18, 'promo18', NULL, '2018-04-01', '2018-04-30');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (19, 'promo19', NULL, '2019-07-01', '2019-07-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (20, 'promo20', 'Sample description.', '2020-10-01', '2020-10-31');
INSERT INTO T_PROMO (id, name, desc_promo, date_start, date_end) VALUES (21, 'promo21', 'Sample description.', '2023-01-01', '2023-03-31');

COMMIT;