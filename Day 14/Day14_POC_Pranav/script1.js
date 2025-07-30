// functions 



function greet(name){
    console.log("welcome "+name);
}

greet("pranav");


// // funtion to fimd factorial of a number 

function fact(number){

    let fact=1;
    
    for(let i=1;i<=number;i++){
        fact=fact*i;

    }
    console.log("factorial of "+number+ " is "+fact);
}


fact(5);





// // function expression

// // we store thenfinion ij a variable , n call it using hat variable
// //rule = default parameter must be the last argument in the funtion .]


// const newGreetings  = function(firstname , lastname="batki"){

//     console.log("welcome back "+firstname+" "+lastname);
// }

// newGreetings("pranav");





// /// arrow function

// const addNumber = (num1 , num2)=> num1 + num2 ;
// console.log(addNumber(10,20));


// ///// call back function

// // all async are callback functions


// const demoGreet = function(callback){
//     console.log("hello world");
//     callback(20);
// }



// const tempFunc =  function(value){
//     console.log("inside callback  : "+value);

// }


// demoGreet(tempFunc);



// /////////

// let students = ['Durgesh','Mayuri','Pranav','Sujit', 'Sanskruti'];
 
// const ulRef=document.querySelector("ul");
// console.log(ulRef);
 
// html=``;
 
// students.forEach((student,index)=>
// {
//     html+=`<li>${index+1} : ${student}</li>`
//     console.log(index+" : "+student);
// });
 
// console.log(html); // checkin gif the refrence is being getting corretlu
 
// ulRef.innerHTML=html;




// console.log("hello");

// function addNum(num1 , num2){
//     return num1+num2;
// }


// let x = addNum(3,2);
// console.log("Sum is :"+x);


// let y = addNum;
// console.log(y);



// //  to accept mutiple arguments


// function sumAll(...numbers) 
// {
//   let total = 0;
//   numbers.forEach(n => total += n);
//   return total;
// }

// console.log(sumAll(1, 2, 3, 4)); 


// // //function expression
// const multiply = function(x, y) {
//   return x * y;
// };

// console.log(multiply(3, 5));



// // fucntion epressipns used where behavior may change dynamicall7 / unexpectedly


// function calculate(a, b, operation) {
//   return operation(a, b);
// }


// const add = function(x, y) {
//   return x + y;
// };

// const subtract = function(x, y) {
//   return x - y;
// };

// const multiply = function(x, y) {
//   return x * y;
// };

// const divide = function(x, y) {
//   return y !== 0 ? x / y : "Cannot divide by zero";
// };


// console.log(calculate(10, 5, add));      
// console.log(calculate(10, 5, subtract)); 
// console.log(calculate(10, 5, multiply)); 
// console.log(calculate(10, 0, divide));   



// ////////////////////////
// function myFunc(theObject) {
//   theObject.make = "Toyota";
// }

// const myCar = {
//   make: "Honda",
//   model: "Accord",
//   year: 1998,
// };

// console.log(myCar.make); 
// myFunc(myCar);
// console.log(myCar.make);














































// normal funtion


// function placeOrder(order) {
//   console.log("Placing order for:", order);


//   setTimeout(function () {
//     console.log("Order completed for:", order);

//   }, 2000);


// }

// //regular function — runs immediately, not passed as callback
// function notifyUser(order) {
//   console.log("Notification: Your " + order + " is ready for pickup!");
// }


// placeOrder("Burger");
// notifyUser("Burger");  








/// using callabck

function placeOrder(order, callback) {
  console.log("Placing order for:", order);


  setTimeout(function () {
    console.log("Order completed for:", order);
    
    callback(order);   // notifyUser(order)

  }, 2000);

}

// callback funtion
function notifyUser(order) {
  console.log("Notification: Your " + order + " is ready for pickup!");
}

//  with callback
placeOrder("Burger", notifyUser);







const fruits = ["Apple", "Banana", "Mango"];




fruits.forEach(function(fruit) {
  console.log("I like", fruit);
});





//arrow function 
fruits.forEach( (fruit) =>console.log("I like", fruit ) ) ;