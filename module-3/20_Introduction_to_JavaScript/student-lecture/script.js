/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const DAYS_PER_WEEK = 7;
  console.log('There are ' + DAYS_PER_WEEK + ' days in the week.');

  // Declares a variable those value can be changed
  let daysPerMonth = 31;
  console.log('There are ' + daysPerMonth + ' days in January.');
  daysPerMonth = 28;
  console.log('There are ' + daysPerMonth + ' in February');

  // Declares a variable that will always be an array
  const WEEKDAYS = [
    'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'
  ]; 
  console.table(WEEKDAYS);
}


/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`);
  console.log(`x === y : ${x === y}`);
}

function arrayTesting(){
  let testScores = [86, 78, 99];
  console.table(testScores);
  testScores.push(55); // push adds to end; pop removes from end
  console.table(testScores);
  testScores.unshift(75); // unshift adds to beginning; shift removes from beginning
  console.table(testScores);

  if(testScores.includes(78)){
    console.log(`There is a 78 in position ` + testScores.indexOf(78));
  }

  console.log(testScores.join(':'));

  let sum = 0;
  for(i = 0; i < testScores.length; i++){
    sum += testScores[i];
  }
  console.log(sum);
  let avg = sum / testScores.length;
  console.log(avg.toFixed(2));
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x){
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ]
  };

  // Log the object
  console.table(person);

  // Log the first and last name
  console.log(person.firstName + ' ' + person.lastName);

  // change the age of the person
  person.age = 43;
  console.log(person.age);

  // Log each employee
  for (let i = 0; i < person.employees.length; i++){
    console.log(`Employee ${i + 1} is ${person.employees[i]}`);
  }

  console.log(person.toString());
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function add(num1, num2){
  return num1 + num2;
}

function add(num1, num2, num3){
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log('Math.PI : ' + Math.PI);
  console.log('Math.abs(-10) : ' + Math.abs(-10));
  console.log('Math.floor(1.99) : ' + Math.floor(1.99));
  console.log('Math.ceil(1.01) : ' + Math.ceil(1.01));
  console.log('Math.random() : ' + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {

}
