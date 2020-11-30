-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
        INSERT INTO actor (actor_id, first_name, last_name)
        VALUES (201, 'Hampton', 'Avenue');
        
        INSERT INTO actor(actor_id, first_name, last_name)
        VALUES (202, 'Lisa', 'Byway');

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
        INSERT INTO film (film_id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost)
        VALUES (1001, 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 6, 3.99, 198, 15.99);
        
        SELECT * FROM film;

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
        INSERT INTO film_actor(actor_id, film_id)
        VALUES(201, 1001);
        
        INSERT INTO film_actor(actor_id, film_id)
        VALUES (202, 1001);
        
        SELECT * FROM film_actor;

-- 4. Add Mathmagical to the category table.
        INSERT INTO category(category_id, name)
        VALUES (17, 'Mathmagical');

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
        INSERT INTO film_category(film_id, category_id)
        VALUES (1001, 17);
        
        INSERT INTO film_category(film_id, category_id)
        VALUES (274, 17);
        
        INSERT INTO film_category(film_id, category_id)
        VALUES (494, 17);
        
        INSERT INTO film_category(film_id, category_id)
        VALUES (714, 17);
        
        INSERT INTO film_category(film_id, category_id)
        VALUES (996, 17);
        
        SELECT * FROM film_category;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
      UPDATE film
        SET rating = 'G'
        WHERE film_id = 1001;  
        
      UPDATE film
        SET rating = 'G'
        WHERE film_id = 274;
        
      UPDATE film
        SET rating = 'G'
        WHERE film_id = 494;
        
      UPDATE film
        SET rating = 'G'
        WHERE film_id = 714;
        
      UPDATE film
        SET rating = 'G'
        WHERE film_id = 996;

-- 7. Add a copy of "Euclidean PI" to all the stores.
    INSERT INTO inventory(inventory_id, film_id, store_id)
    VALUES (5000, 1001, 1);
    
     INSERT INTO inventory(inventory_id, film_id, store_id)
    VALUES (5001, 1001, 2);
    
-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- < It did not succeed and it looks like it's due to the fact that other tables are already connected to
--        Euclidean PI (due to a foreign key constraint). For instance, the film_actor table still references the movie
--        so it can't just be removed at this point  >


-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <  It doesn't work for a similar reason as above, except this time, the category can't be deleted becase
--    it still has a reference in the film_category table  >


-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <  This time it worked and I *think* it's because we're deleting the primary key...   >
        DELETE FROM film_category
        WHERE category_id = 17;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <  Deleting Mathmagical from the category table worked and I imagine it's because we deleted the 
--      primary key for the Mathmagical category. However, deleting Euclidean PI from the film table
--      still doesn't work. I think it's because film_actor still relies on a foreign key from that movie  >
        DELETE FROM category
        WHERE name = 'Mathmagical';
        
        DELETE FROM film
        WHERE title = 'Euclidean PI';

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
    -- <  I think that if we just deleted the actor_id and film_id that's connecting the actors we added into Euclidean PI in the beginning, 
   --         we would be able to delete Euclidean PI from the film table. From what I tried below, I believe that worked.   >
   
        BEGIN TRANSACTION;
        DELETE FROM film_actor WHERE film_id = 1001;
        DELETE FROM film WHERE title = 'Eucliean PI';
        ROLLBACK;
