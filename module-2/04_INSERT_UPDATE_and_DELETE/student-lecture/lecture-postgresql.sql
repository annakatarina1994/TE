-- INSERT

-- 1. Add Klingon as a spoken language in the USA
        SELECT * FROM countrylanguage WHERE countrycode = 'USA';
        
        INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
        VALUES ('USA', 'Klingon', false, 0.01);
        
        SELECT * FROM countrylanguage WHERE countrycode = 'USA';

-- 2. Add Klingon as a spoken language in Great Britain
      SELECT * FROM countrylanguage WHERE countrycode = 'GBR'; 
      
      INSERT INTO countrylanguage(countrycode, language, isofficial, percentage)
      VALUES ('GBR', 'Klingon', false, 0.003); 
      
      SELECT * FROM countrylanguage WHERE countrycode = 'GBR'; 


-- UPDATE

-- 1. Update the capital of the USA to Houston
      SELECT * FROM country WHERE name = 'United States';
      SELECT * FROM city WHERE name = 'Houston';
      
      UPDATE country
        SET capital = 3796  --relies on information from first two statements
        WHERE code = 'USA';
        
        SELECT * FROM country WHERE name = 'United States';

-- 2. Update the capital of the USA to Washington DC and the head of state
        SELECT * FROM city WHERE name = 'Washington';
        
        UPDATE country
        SET capital = city.id,
        headofstate = 'Bob for President'
        FROM city
        WHERE city.name = 'Washington' AND city.countrycode = 'USA';
        
        SELECT * FROM country WHERE name = 'United States';


-- DELETE

-- 1. Delete English as a spoken language in the USA
        SELECT * FROM countrylanguage WHERE countrycode = 'USA';
        
        DELETE FROM countrylanguage
        WHERE language = 'English' AND countrycode = 'USA';
        
        SELECT * FROM countrylanguage WHERE countrycode = 'USA';

-- 2. Delete all occurrences of the Klingon language 
        SELECT * FROM countrylanguage WHERE language = 'Klingon';
        
        DELETE FROM countrylanguage
        WHERE language = 'Klingon';
        
        SELECT * FROM countrylanguage WHERE language = 'Klingon';


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
        INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
        VALUES ('USA', 'Elvish', false, 0.02);

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
        INSERT INTO countrylanguage(countrycode, language, isofficial, percentage)
        VALUES ('ZZZ', 'English', false, 50);

-- 3. Try deleting the country USA. What happens?
        DELETE FROM country WHERE code = 'USA';

-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
        INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
        VALUES ('USA', 'English', true, 86.2);
        
        

-- 2. Try again. What happens?
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
        VALUES ('USA', 'English', true, 86.2);

-- 3. Let's relocate the USA to the continent - 'Outer Space'
UPDATE country
        SET continent = 'Outer Space'
        WHERE code = 'USA';

-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.
BEGIN TRANSACTION;
DELETE FROM countrylanguage;
SELECT * FROM countrylanguage;
ROLLBACK; --safety catch -- you can see if it worked but it won't actually go into effect if you have this at the end
          -- if you wanted it to actually take effect, you could instead type COMMIT;

-- 2. Try updating all of the cities to be in the USA and roll it back


-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.