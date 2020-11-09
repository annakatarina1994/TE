1. Select the ways a `List` differs from an array: (select all that apply)

    a. A `List`'s length doesn't need to be declared. *
    b. You can add different data types to a `List`.
    c. Elements can be easily added to and removed from the middle of a `List`. *
    d. You can't access a `List` element at a particular index.
    e. You use a different method to retrieve the number of elements in a `List`. *

    Correct:
        a. A `List` grows and shrinks as it's needed, unlike an array that has a fixed length.
        c. `List`s have methods that you can use to add and remove elements from the middle of a `List`, unlike arrays.
        e. `List`s have a different method for retrieving the number of elements.
    Wrong:
        b. Like arrays, `List`s are bound to the data type it was declared with.
        d. You can access a `List` element at a particular index.

2. What does the `<T>` indicate when used like `List<T>`?

    a. It means that it's a collection.
    b. The `List` can only hold a datatype called `T`.
    c. You need to specify a datatype in place of `T`. *
    d. Nothing. It's a typo.

    Correct:
        c. The `T` is a placeholder for a datatype to be specified by the developer. The datatype goes in the brackets `<>`.
    Wrong:
        a. The package of the `List` class indicates that it's a collection.
        b. That could be possible, but a developer probably wouldn't use `T` as it isn't a very descriptive name.
        d. It's not a typo.

3. Given the `List` declaration below, how do you write a for-each loop to iterate through its elements?

    ```java
    List<Integer> scores = new ArrayList<Integer>(Arrays.asList(80, 94, 81, 75, 91, 98, 84));
    ```

    a. `for (each score in scores)`
    b. `for (Integer score : scores)` *
    c. `for (score in scores)`
    d. `for (scores => score)`

    Correct:
        b. This is the correct syntax for a for-each loop.
    Wrong:
        a, c, d. This isn't the correct syntax for a for-each loop.

4. What method do you use to get the number of elements in a `List`?

    a. `.length()`
    b. `.amount()`
    c. `.size()` *
    d. `.count()`

    Correct:
        c. This is the correct method.
    Wrong:
        a. `length` is the *attribute* used for arrays.
        b, d. These aren't valid methods.

5. Given a `List<String>`, what does the following line of code do?

    ```java
    myList.add(1, "My Text");
    ```

    a. Adds "My Text" as the first item in `myList`.
    b. Adds "My Text" as the second item in `myList`. *
    c. Adds the values `1` and `"My Text"` to `myList`.
    d. Overwrites the element at that position in `myList`.

    Correct:
        b. This is correct. The `1` indicates the zero-based index of where to insert the item.
    Wrong:
        a. The `1` indicates the zero-based index of where to insert the item. This line inserts it as the second item.
        c. You can't add two values to a `List` in one line.
        d. The element isn't overwritten.

6. Given the `List` declaration below, how do you access the *third* item?

    ```java
    List<String> animals = new ArrayList<String>(Arrays.asList("Dog", "Cat", "Fish", "Bear"));
    ```

    a. `animals.get(2)` *
    b. `animals.get(3)`
    c. `animals.get("Fish")`
    d. `animals[2]`

    Correct:
        a. Correct. `List`s are zero-based indexes like arrays, so you use the `.get()` method.
    Wrong:
        b. This retrieves the fourth item because `List`s are zero-based indexes like arrays.
        c. You can't retrieve a `List` item by its value.
        d. This isn't valid syntax to retrieve a value from a `List`. This only works on arrays.
