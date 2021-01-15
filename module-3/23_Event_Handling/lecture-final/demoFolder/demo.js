
//  do first without anonymous function

function returnEvens() {
    let numArray = [4, 5, 6, 7, 8, 10, 11, 21, 22];
    let answerArray = [];
    for (let i = 0; i < numArray.length; i++) {
        if (numArray[i] % 2 === 0) {
            answerArray.push(numArray[i]);
        }
    }
    return answerArray;
}

function returnEvensAgain() {
    let numArray = [4, 56, 67];
    let answerArray = numArray.filter(
        (number) => {
            return number % 2 === 0;  // return true or false
        });
    return answerArray;
}

function filterNums(number){
    return number % 2 === 0;
}
function returnEvensYetAgain(){
    let numArray = [4, 3, 56, 67];
    return numArray.filter(filterNums);  // give me the condition
        
    // return answerArray;
}

//what is we have anon function return every third element

function returnEveryThird(){
    let numArray = [4, 5, 6, 7, 8, 10, 11, 21, 22]; // 6, 10, 22
    let counter = 0;
    let answerArray = numArray.filter(
        (number) => {
            counter++;
            return counter % 3 === 0;  // return true or false
        }
    );
        return answerArray;
}
