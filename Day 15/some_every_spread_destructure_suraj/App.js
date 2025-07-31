
// // every -returns true if every element of array gives true for some function else returns false
// // arr.every (some function defination or name)

// let bool = [1,2,3,4].every((el) => (el%2 == 0));
// console.log(bool);

// let bool2 = [2,4].every((el) => (el%2 == 0));
// console.log(bool2);




// // some -returns true if some elements of array give true for some function else return false

// let bool3 = [2,4].some((el) => (el%2 != 0));
// console.log(bool3);

// let bool4 = [2,4,3].some((el) => (el%2 == 0));
// console.log(bool4);





// //default parameter

// function sum2(a,b=2){
//     console.log(a+b);
    
// }
// sum2(5); // 7 b=2 default
// sum2(5,4); // 9 b = 4 ovveride

// function sum3(b=2,a){
//     console.log(a+b);
    
// }
// sum3(3) // error a is not defined so use default parameter at last in function declaration(a,b=2)






// // spread - expands an iterable into multiple values

// Math.min(1,2,3,4,5,6);


// let arr = [1,2,3,4,5,6,0];

// // Math.min(arr[0],arr[1],);

// console.log(Math.min(...arr));

// console.log(arr);
// console.log(1,2,3);

// console.log(...arr);

// console.log("suraj");
// console.log(..."suraj");

// let arr2 = [1,2,3,4,5,6,0];
// let newArr = [...arr2];

// let even = [2,4,6];
// let odd = [1,3,5];

// let all = [...even,...odd];

// console.log(all);

// // object
// const data = {
//     email : "suraj@gmail.com",
//     pass : "abcd"
// };


// const dataCopy = {...data,id:23};
// console.log(dataCopy);

// let nums = [1,2,3,4];
// let obj1 = {...nums};
// console.log(obj1);

// let obj2 = {..."suraj"};
// console.log(obj2);


//rest allows a function to take an indefinite number of arg and bundle them in an array




// Math.min(1,2,3,4,5,6);


// function temp(...args){
//     for (let i = 0; i < args.length; i++) {
//         console.log("you gave us ",args[i]);
        
        
//     }
//     console.log(args.length);
    
// }
// temp(3,4,5,6,6,7);

// function sum6(...args){
//     return args.reduce((acc,el) => (acc+el));
// }

//destructuring

// let participant = ["suraj","viraj","sahil"];
// let winner = participant[0];
// let second = participant[1];
// let third = participant[2];

// let [winner,second,third] = participant;

// let participant = ["suraj","viraj","sahil","asfs","sfsf","sfsf"];
// let [winner,second,third,...others] = participant;
