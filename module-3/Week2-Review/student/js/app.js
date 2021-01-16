const NUMBER_OF_PROBLEMS = 10;
let currentProblemNumber = 1;
let score = 0;
let problemSet = [];

function generateProblemSet() {
    for (let i = 0; i < NUMBER_OF_PROBLEMS; i++) {
        let left = getRandomNumber(10, 83);  // we want to multiplication probs for single digit numbers
        let right = getRandomNumber(10, 83);
        let correctAnswer = left * right;
        let answers = shuffleArray([correctAnswer, getRandomNumber(82, correctAnswer), getRandomNumber(82, correctAnswer), getRandomNumber(82, correctAnswer)]);
        let object = {
            leftSide: left,
            rightSide: right,
            answer: correctAnswer,
            answerArray: answers
        };
        problemSet.push(object);
    }
}

function displayProblem() {
    const expression = document.querySelector('.expression');
    expression.innerText = problemSet[currentProblemNumber - 1].leftSide + '*'
        + problemSet[currentProblemNumber - 1].rightSide;
}

function displayAnswers() {
    const answers = document.getElementById('answers');
    const answerList = answers.querySelectorAll('li');
    let answerLoop = problemSet[currentProblemNumber - 1].answerArray;
    // answerLoop = [12, 45, 62, 3]
    for (let i = 0; i < answerLoop.length; i++) {
        answerList[i].innerText = answerLoop[i];
    }
}

function compareAnswer(li) {
    
        //if they get a correct answer do this
        if (li.innerText == problemSet[currentProblemNumber - 1].answer) {
            score++;
            updateScore();
        }
        if (currentProblemNumber < NUMBER_OF_PROBLEMS) {
        // regardless of correct answer or not, do this 
        // advance the currentProblemNumber
        currentProblemNumber++;
        updateProblemNumber();
    } else {
        // toggle the showHide class
        toggleShowHide();
    }
}

function toggleShowHide(){
    const elements = document.querySelectorAll('.show-hide');
    elements.forEach((element) => {
        element.classList.toggle('hidden', currentProblemNumber === NUMBER_OF_PROBLEMS);
    })
}

function updateProblemNumber() {
    document.querySelector('.currentProblem').innerText = currentProblemNumber;
}

function updateScore() {
    const update = document.querySelector('.currentScore');
    update.innerText = score;
}

function getRandomNumber(max, answer) {
    let randNum = Math.floor(Math.random() * Math.floor(max));
    while(randNum === answer){
        randNum = Math.floor(Math.random() * Math.floor(max));
    }
    return randNum;
}

function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
}

function resetAll() {
    // if user has done at least one problem, we need to reset everything
    if (currentProblemNumber > 1) {
        problemSet = [];
        currentProblemNumber = 1;
        updateProblemNumber();
        score = 0;
        updateScore();
    }
    generateProblemSet();
    displayProblem();
    displayAnswers();
}

document.addEventListener('DOMContentLoaded', () => {
    generateProblemSet();

    const answerli = document.querySelectorAll('#answers ul li');
    answerli.forEach((element) => {
        element.addEventListener('click', (event) => {
            compareAnswer(event.target);
            displayProblem();
            displayAnswers();
        });
    });

    document.getElementById('btnStartOver').addEventListener('click', () => {
        resetAll();
        toggleShowHide();
    });

    displayProblem();
    displayAnswers();
});