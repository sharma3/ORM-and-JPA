CREATE TABLE COMBOS (ID BIGINT AUTO_INCREMENT NOT NULL, ADDINGDATE DATETIME, COMBO_AVAILIBILITY VARCHAR(255), COMBO_ITEMS VARCHAR(255), COMBO_NAME VARCHAR(255), COMBO_PRICE VARCHAR(255), SAVING VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE COMPANY (ID BIGINT AUTO_INCREMENT NOT NULL, ADDINGDATE DATETIME, NAME VARCHAR(255), PRODUCTNAME VARCHAR(255), PRODUCTTYPE VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE CUSTOMER (ID BIGINT AUTO_INCREMENT NOT NULL, ADDINGDATE DATETIME, BIRTHDATE DATETIME, EMAIL VARCHAR(255), FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), MEMBERREF_ID VARCHAR(255), PASSWORD VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE MARKETINGTREE (ID BIGINT AUTO_INCREMENT NOT NULL, ADDINGDATE DATETIME, PRIMARY KEY (ID))
CREATE TABLE MEMBERS (ID BIGINT AUTO_INCREMENT NOT NULL, ADDINGDATE DATETIME, ADMIN_MEMBER TINYINT(1) default 0, BIRTHDATE DATETIME, EMAIL VARCHAR(255), FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), PASSWORD VARCHAR(255), REFERANCE_CODE VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PRODUCTS (ID BIGINT AUTO_INCREMENT NOT NULL, ADDINGDATE DATETIME, PRODUCT_AVAILIBILITY VARCHAR(255), PRODUCT_NAME VARCHAR(255), PRODUCT_PRICE VARCHAR(255), PRODUCT_WEIGHT VARCHAR(255), PRIMARY KEY (ID))
