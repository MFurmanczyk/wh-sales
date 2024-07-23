CREATE DATABASE db_ecommerce_t;

CREATE ROLE 'ecommerce_admin'@'localhost';
CREATE ROLE 'dwh_developer'@'localhost';

GRANT ALL ON db_ecommerce_t.* TO 'ecommerce_admin'@'localhost' WITH GRANT OPTION;
GRANT SELECT ON db_ecommerce_t.* TO 'dwh_developer'@'localhost';

CREATE USER 'admin'@'localhost' IDENTIFIED BY '*******' /*place your password here*/ DEFAULT ROLE 'ecommerce_admin'@'localhost';
CREATE USER 'spark_etl'@'localhost' IDENTIFIED BY '*******' /*place your password here*/ DEFAULT ROLE 'dwh_developer'@'localhost';