/**
 * Arguments parameter example
 */

 function addNumbers(num1, num2){
     return num1 + num2;
 }

 function addNumbers(num1, num2, num3){
     return num1 + num2 + num3;
 }

 // only second function works now because JS won't let you overload functions
 // You just have to have no parameters and use 'arguments' instead

 function addNumbers(){
     let sum = 0;
     for(let i = 0; i < arguments.length; i++){
        sum += arguments[i];
     }
     return sum;
 }

 // Example of hoisting

 function normalVar(){
     num = 5;
     console.log(num);
     var num;
 }

 function normalLet(){
     num = 5;
     console.log(num);
     let num;
 }

let globalNum = 5;
function addToGLocalNumber(){
    globalNum  += 5;
    console.log(globalNum);
}

function callAnotherFunction(){
    let newNum = 5;
    console.log(newNum);
}