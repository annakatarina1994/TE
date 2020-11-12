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

2. Which of the following is the correct way to declare a property in a C# class?

a. `public get set string { LastName }`
b. `public LastName { get string; set string; }`
c. `public string { get LastName; set { this.lastName = LastName } }`
d. `public string LastName { get; set; }` *

Correct:
d. Correct. A property is declared like a variable, with an access modifier (`public` or `private`), and a getter and setter often written in short-hand as `{ get; set; }`.

Wrong:
a., b., c. These examples don't show the correct syntax for declaring properties.

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

4. Which parts of a method declaration make up the method signature in C#? (Select all that apply.)

a. Method body
b. Method name *
c. Exception list
d. Parameter list *
e. Access modifier *
f. Number of overloads
g. Return type *

Correct:
b., d., e., g. The access modifier, return type, method name, and the data types in the parameter list make up the method signature.

Wrong:
a. The method body isn't part of the method signature.
c. Exception list only applies to Java, and isn't part of a method signature in Java either.
f. The number of overloads doesn't matter, but method signatures do help distinguish between overloaded methods.

5. Which of the following statements are correct? (Select all that apply.)

a. A class is a blueprint that defines the *state* and *behaviors* of a data type. *
b. `string` is a primitive data type.
c. An object is an instance of a class. *
d. An object can reference multiple classes.

Correct:
a., c. Classes are blueprints that bring *state* (variables) and *behaviors* (methods) together, but they need to be *instantiated* into an object to be used.

Wrong:
b. `string` is a class, although it's commonly treated as if it was a primitive.
d. An object may be only one data type.

6. What access modifier hides methods and instance variables?

a. `hide`
b. `private` *
c. `readonly`
d. `protect`

Correct:
b. The `private` access modifier hides methods and instance variables and prevents access outside the class itself.

Wrong:
a. `hide` isn't a valid access modifier in C#.
c. `readonly` is a keyword in C# which prevents a variable from being assigned a value more than once. It's not an *access modifier*.
d. `protect` isn't a valid access modifier.

7. What occurs when the following code compiles?

```csharp
class Greeter {
    ...
    public string HappyBirthday(string name, int age) {
        return "Happy Birthday " + name + "! You are " + age + " years old.";
    }
    public string HappyBirthday(int numberOfCandles, string message) {
        return message + "Wow! Your cake has " + numberOfCandles + " candles.";
    }
    ...
}
```

a. The two methods are *overloaded* by the C# compiler. *
b. The C# compiler throws an error saying they're duplicate methods because they have the same name, and both have `int` and `string` parameter types.
c. It won't compile since you can't concatenate `int` values, such as `age` or `numberOfCandles`, to a string.
d. It won't compile since the methods must use `this` to refer to the variables.

Correct:
a. The parameter types *and* their order are important in overloading methods. The two methods have `int` and `string` parameter types, but in different order, so they're overloaded.

Wrong:
b. The order of parameter types is significant. Since the two methods have the same name, but different parameter orders, the C# compiler treats them as overloads.
c. C# allows `int` values to be concatenated to strings using the `+` operator.
d. The variables aren't class properties, so `this` isn't required.

8. Given the following code, which is the correct code for returning the derived property `FullName`?

```csharp
class Person {

    public string FirstName { get; set; }
    public string LastName { get; set; }
    ...
}
```

a.
```csharp
public string GetFullName(string lastName, string firstName) {
    return lastName + ", " + firstName;
}
```
b.
```csharp
public string FullName { get; set; }
```
c. *
```csharp
public string FullName
{
    get
    {
        return this.LastName + ", " + this.FirstName;
    }
}
```
d.
```csharp
public string FullName
{
    get
    {
        this.FullName = this.LastName + ", " + this.FirstName;
    }
}
```

Correct:
c. A derived property is a property whose value depends on one or more properties. This property correctly returns a `string` composed of the `FirstName` and `LastName` properties.

Wrong:
a. This is a method that returns a `string` composed of the parameters passed to it, but not using the properties of the class.
b. Derived properties are typically calculated using other properties. This is a regular, non-derived property.
d. This code sets a `FullName` property, but it should return `this.LastName + ", " + this.FirstName` and not assign it to `FullName`.

9. C# namespaces offer which of the following benefits? (Select all that apply.)

a. They prevent your type names from colliding with others. `your.Employee` can be distinguished from `their.Employee`. *
b. They reduce memory since all classes in a package are compiled at the same time.
c. They allow you to gather classes to logically relate them together. *
d. The C# compiler uses namespaces to optimize compilation which speeds up build-time.

Correct:
a., c. Namespaces exist in C# to avoid *namespace* collisions, and help document and explain how classes are logically related to one another.

Wrong:
b., d. While these sound plausible, namespaces don't reduce memory or speed up compilation.

10. Does C# allow an *instance* method to directly call a `static` method in the same class?

```csharp
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
