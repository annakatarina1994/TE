/**
 * Arguments parameter example
 */

 function addNumbers(num1, num2){
     return num1 + num2;
 }

 /*  If you send in 2 numbers, you get back NaN (JS does not allow overloading of functions)
*    If you send in 2 words, JS concatenates those words and adds the value of num3 ('undefined') to the end
 */

 function addNumbers(num1, num2, num3){
     return num1 + num2 + num3;
 }

 function addNumbers(){
     let sum = 0;
     for (let i = 0; i < arguments.length; i++){
        sum += arguments[i];
     }
     return sum;
 }

 /**
  * Example of hoisting -- doesn't crash because var will hoist the variable to the top of the function
  */
 function normalVar(){
     num = 5;
     console.log(num);
     var num;
 }
/**
 * Let will not hoist and will throw an Uncaught Reference error
 */
 function normalLet(){
     num = 5;
     console.log(num);
     let num;
 }

 globalNum = 5;
 function addToGlobalNumber(){
     globalNum += 15;
     console.log(globalNum);
 }

 function callAnotherFunction(){
     newNum = 5;
     console.log(newNum);
     callFunction();
 }

 function callFunction(){
     console.log(newNum);
 }
 /*
 * CHALLENGE
 * Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */
// function getSumOfSubArrayValues(nestedArray = []){
//     // if (typeof nestedArray === 'undefined'){
//     //     return 0;
//     // }
//     return nestedArray.reduce( 
//         (grandTotal, element) => {
//             const sum = element.reduce(
//                 (subTotal, n) => {
//                     return subTotal + n;
//                 }, 0
//             );
//             return grandTotal + sum;
//         }, 0
//     );

// }

// function getSumOfSubArrayValues(xArray = 0){  
//     if (xArray.length > 0) {
//        let newArray = xArray.flat();  // .flat flattens the inner array to a single dimensional array
//        return newArray.reduce((a,b) => a+b);
//     } return 0;
// }

function getSumOfSubArrayValues(arrayValues = []){
    let grandTotal = 0;
    for (let i = 0; i < arrayValues.length; i++){
        for (let j = 0 ; j < arrayValues[i].length; j++){
            grandTotal += arrayValues[i][j];  // add up each individual element
        }
    }
    return grandTotal;
}