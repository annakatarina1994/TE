1. A `Map` is:
    a. An unordered collection of objects that have unique values.
    b. An ordered collection that has indexes and acts much like an array.
    c. An unordered collection of key-value pairs. *
    d. An ordered collection whose size can't change.

    Correct:
        c. This is the correct description of a `Map`.
    Wrong:
        a. This describes a `HashSet`.
        b. This describes a `List`.
        d. This describes an array.

2. True or false: the key and value of a `Map` must be the same data type.

    a. True
    b. False *

    Correct/Wrong:
        The key and value can be different data types.

3. Given the `Map` declaration below, how do you write a for-each loop to iterate through its elements?

    ```java
    Map<String, Integer> petAges = new HashMap<String, Integer>();
    petAges.put("Mo", 14);
    petAges.put("Quill", 12);
    petAges.put("Tuxedo", 8);
    ```

    a. `for (Map.Entry<String, Integer> petAge : petAges)`
    b. `for (Map.Entry<String, Integer> petAge : petAges.entrySet())` *
    c. `for (Map.Entry<String, Integer> petAge in petAges)`
    d. `for (petAges.entrySet() => Map.Entry<String, Integer> petAge)`

    Correct:
        b. This is the correct syntax for a for-each loop.
    Wrong:
        a, c, d. This isn't the correct syntax for a for-each loop.

4. What happens when the following code executes?

    ```java
    Map<String, Integer> animalNumberLegs = new HashMap<String, Integer>();
    animalNumberLegs.put("Dog", 4);
    animalNumberLegs.put("Fish", 0);
    animalNumberLegs.put("Bear", 2);
    animalNumberLegs.put("Bear", 4);
    ```

    a. The value for "Bear" is overwritten with `4`. *
    b. A second "Bear" is added, with a value of `4`.
    c. A compiler error occurs because the syntax is invalid.
    d. The value of bear increases by 4 and now equals 6.

    Correct:
        a. Correct. The element is overwritten.
    Wrong:
        b. Keys must be unique in `Map`s. A second "Bear" can't be added.
        c. This is valid syntax. The element is overwritten.
        d. Adding the same value doesn't increase the value.

5. Given the following code, how do you access the key and value of `testScore`?

    ```java
    Map<String, Integer> testScores = new HashMap<String, Integer>();
    testScores.put("Alice", 98);
    testScores.put("Bob", 87);
    testScores.put("Charlie", 77);

    for (Map.Entry<String, Integer> testScore : testScores.entrySet()) {
        System.out.println("Key: " + /*fill in code*/);
        System.out.println("Value: " + /*fill in code*/);
    }
    ```

    a. `testScore[0]` and `testScore[1]`
    b. `testScore.getKey()` and `testScore.getValue()` *
    c. `testScore[key]` and `testScore[value]`
    d. `testScore.key` and `testScore.value`

    Correct:
        b. This is the correct syntax for accessing the key and value of a `Map.Entry`.
    Wrong:
        a, c, d. The syntax is invalid.

6. How do you determine if the key "Dave" exists in the `Map` below?

    ```java
    Map<String, String> people = new HashMap<String, String>();
    ```

    a. `people.getKey("Dave")`
    b. `people.hasKey("Dave")`
    c. `people.keyExists("Dave")`
    d. `people.containsKey("Dave")` *

    Correct:
        d. This is the correct method and way to check for a key's existence.
    Wrong:
        a. This method doesn't exist on the `Map` object, but it is used to get the key from a `Map.Entry` in a for-each loop.
        b., c., These aren't valid methods.
