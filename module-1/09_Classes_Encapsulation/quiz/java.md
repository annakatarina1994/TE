1. What are the principles of encapsulation? (Select all that apply.)

a. Bundling object state and behavior *
b. Managing internal logic and consistency *
c. Validating user input
d. Restricting direct access to internal properties *
e. Overloading methods

Correct:
a., b., d. These are the principles of encapsulation.

Wrong
c. While you can validate user input with a setter, this isn't a principle of encapsulation.
e. Overloading methods help make your code more readable and flexible, but that isn't a principle of encapsulation.

2. Given the following code, what's the setter for `lastname`?

```java
class Person {
    String lastname;
    ...
}
```

a.
```java
String setLastname(String lastname) {
    this.lastname = lastname;
    return lastname;
}
```
b.
```java
void setLastname() {
    lastname = lastname;
}
```
c.
```java
void lastnameSet(String lastname) {
    this.lastname = lastname;
}
```
d. *
```java
void setLastname(String lastName) {
    this.lastname = lastname;
}
```

Correct:
d. Setters always begin with `set` followed the name of the variable they're setting, take a single parameter with the same data type as the variable they set, and have a `void` return type.

Wrong:
a. `setLastname()` is a valid method, but setters always have a `void` return type.
b. `setLastname()` doesn't have a parameter, but setters always have a single parameter of the same type as the variable being set. Also, `lastname = lastname` assigns the instance variable back to itself.
c. `lastnameSet()` is a valid method, but `set` is a prefix, not a suffix.

3. What does it mean to define a property or method as `static`?

a. The property or method isn't available to external callers.
b. The property or method is encrypted.
c. The property or method belongs to the class, and not an instance. *
d. The property or method contains noise and nothing useful.

Correct:
c. Correct. A `static` property or method belongs to the class itself and not an instance.

Wrong:
a. To restrict access to a property or method, you define it as `private`.
b. It's not encrypted.
d. That's what static on the radio or TV is, but not related to `static` in code.

4. Which parts of a method declaration make up the method signature in Java? (Select all that apply.)

a. Modifiers
b. Return type
c. Method name *
d. Parameter list *

Correct:
c., d. The method name and the data types in the parameter list make up the method signature.

Wrong:
a., b. Java doesn't consider modifiers or the return type as parts of the method signature.

5. Which of the following statements are correct? (Select all that apply.)

a. A class is a blueprint that defines the *state* and *behaviors* of a data type. *
b. `String` is a primitive data type.
c. An object is an instance of a class. *
d. An object can reference multiple classes.

Correct:
a., c. Classes are blueprints that bring *state* (variables) and *behaviors* (methods) together, but they need to be *instantiated* into an object to be used.

Wrong:
b. `String` is a class, although it's commonly treated as if it was a primitive.
d. An object may be only one data type.

6. What access modifier hides methods and instance variables?

a. `hide`
b. `private` *
c. `final`
d. `protect`

Correct:
b. The `private` access modifier hides methods and instance variables, and prevents access outside the class itself.

Wrong:
a. `hide` isn't a valid access modifier in Java.
c. `final` is a keyword in Java which prevents a variable from being assigned a value more than once. It's not an *access modifier*.
d. `protect` isn't a valid access modifier.

7. What occurs when the following code compiles?

```java
class Greeter {
    ...
    public String happyBirthday(String name, int age) {
        return "Happy Birthday " + name + "! You are " + age + " years old.";
    }
    public String happyBirthday(int numberOfCandles, String message) {
        return message + "Wow! Your cake has " + numberOfCandles + " candles.";
    }
    ...
}
```

a. The two methods are *overloaded* by the Java compiler. *
b. The Java compiler throws an error saying they're duplicate methods because they have the same name, and both have `int` and `String` parameter types.
c. It won't compile since you can't concatenate `int` values, such as `age` or `numberOfCandles`, to a string.
d. It won't compile since the methods must use `this` to refer to the variables.

Correct:
a. The parameter types *and* their order are important in overloading methods. The two methods have `int` and `String` parameter types, but in different order, so they're overloaded.

Wrong:
b. The order of parameter types is significant. Since the two methods have the same name, but different parameter orders, the Java compiler treats them as overloads.
c. Java allows `int` values to be concatenated to strings using the `+` operator.
d. The variables aren't class properties, so `this` isn't required.

8. Given the following code, which is the correct getter for the derived property `fullname`?

```java
class Person {

    String firstname;
    String lastname;
    ...
}
```

a.
```java
String getFullname(String lastname, String firstname) {
    return lastname + ", " + firstname;
}
```
b.
```java
String fullname;    // Additional instance variable

String getFullname() {
    return this.fullname;
}
```
c. *
```java
String getFullname() {
    return this.lastname + ", " + this.firstname;
}
```
d.
```java
void getFullName() {
    String fullname = this.lastname + ", " + this.firstname;
    return;
}
```

Correct:
c. A well-formed getter begins with `get` followed by the name of the variable it's getting, has no parameters, and returns the data type of the variable it gets.

Wrong:
a. Getters typically don't have parameters. Additionally, this particular method doesn't use the instance variables `this.lastname` and `this.firstname` to derive the `fullname`.
b. Derived values are typically calculated using instance variables directly. Introducing the `fullname` variable in the code means extra care must be taken in code to ensure that it's in sync with the `this.lastname` and `this.firstname` instance variables. *Use instance variables directly to calculate derived values.*
d. Getters always return a data type. They're never `void`.

9. Java packages offer which of the following benefits? (Select all that apply.)

a. They prevent your type names from colliding with others. `your.Employee` can be distinguished from `their.Employee`. *
b. They reduce memory since all classes in a package are compiled at the same time.
c. They allow you to gather classes to logically relate them together. *
d. The Java compiler uses packages to optimize compilation which speeds up build-time.

Correct:
a., c. Packages exist in Java to avoid *namespace* collisions, and help document and explain how classes are logically related to one another.

Wrong:
b., d. While these sound plausible, packages don't reduce memory or speed up compilation.

10. Does Java allow an *instance* method to directly call a `static` method in the same class?

```java
class Greeter {
    static int numberOfGreetings = 0;

    static void trackGreetings() {
        numberOfGreetings++;
    }
    String greet(String message, String name) {
        trackGreetings();   // directly call static trackGreetings()
        return "Hello, " + name + ". " + message;
    }
}
```
a. It doesn't matter. Any method, regardless of whether it's *instance* or `static`, can call any other method within the same class.
b. It depends on whether the correct access modifiers are used since *instance* and `static` belong in different scopes. They need visibility to one another.
c. The *Rules of Method Signatures* permits *instance* methods to call `static` methods provided there is no `this`, as in `this.trackGreetings()`.
d. Since any instantiated object is of some type of class, any `static` methods of that class are automatically available to *instance* methods. *

Correct:
d. This is true. Instance methods can call `static` methods.

Wrong:
a. Instance methods can call `static` methods, but `static` methods can't call an instance method since they're not part of an instance.
b. Sounds almost reasonable, but `static` isn't an access modifier, and scope isn't the issue here.
c. This doesn't have anything to do with method signatures. Though it's correct that there should be no `this` since `this` refers to an instance, and the method is `static`, not an *instance* method.
