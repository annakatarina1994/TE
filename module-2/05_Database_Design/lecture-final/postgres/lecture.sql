-- DROP TABLE customer_purchase;
-- DROP TABLE customer;
-- DROP TABLE art;
-- DROP TABLE artist;



BEGIN TRANSACTION;

CREATE TABLE customer (
   customer_id serial NOT NULL,
   first_name varchar (45) NOT NULL,
   last_name varchar(45) NOT NULL,
   address varchar (100) NOT NULL,
   phone varchar(11) NULL,
   
   CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

CREATE TABLE art (
   art_id serial NOT NULL,
   artist_id int NOT NULL,
   title varchar(45) NOT NULL,
   
   CONSTRAINT pk_art PRIMARY KEY (art_id)
);

CREATE TABLE artist (
   artist_id serial NOT NULL,
   first_name varchar(45) NOT NULL,
   last_name varchar(45) NOT NULL,
   
   CONSTRAINT pk_artist PRIMARY KEY (artist_id)
);
   
CREATE TABLE customer_purchase (
   purchase_id serial NOT NULL,
   customer_id int NOT NULL,
   art_id int NOT NULL,
   purchase_date timestamp NOT NULL,
   price money NOT NULL,
      
   CONSTRAINT pk_customer_purchase PRIMARY KEY (purchase_id)
);

ALTER TABLE art
   ADD CONSTRAINT fk_art_artist FOREIGN KEY (artist_id) REFERENCES artist (artist_id);
   
ALTER TABLE customer_purchase 
   ADD CONSTRAINT fk_customer_purchase_customer 
   FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
   ADD CONSTRAINT fk_customer_purchase_art 
   FOREIGN KEY (art_id) REFERENCES  art (art_id);
   
COMMIT TRANSACTION;
   
   