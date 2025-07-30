//  js objects literals - used to store keyed collections and complex entities
//       property => (Key,Value) pair
//       Objects are collection of properties

//    let delhi = {
//     latitude : "28.7041 N",
//     longitude : "77.1025 E"
        
//    };

//    const student = {
//     name : "suraj",
//     age : 23,
//     marks : 8.7,
//     city: "murbad"
//    };

//       const student2 = {
//     name : "suraj",
//     age : 23,
//     marks : 8.7,
//     city: "murbad"
//    };

// let delhi2 = {
//     latitude : "Hello 28.7041 N",
//     longitude : "77.1025 E"

//    };

//Get Values

// let student = {
//     name : "suraj",
//     marks : 8.7
// };

// obj["key"]
// obj.key

// console.log(student["name"]);
// console.log(student.name);

// let prop = "name";
// console.log(student.prop);
// console.log(student[prop]);

//js automatically converts object keys to strings
// even if we made the number as a key the number will be converted to string

// let obj = {
//     1 : "a",
//     null : "b",
//     undefined : "c",
//     true :"d"
// };

// console.log(obj[1]);
// //obj.1 - error
// //obj.null - b
// //obj.undefined - c
// //obj.true - d

// // add / update value

//       const student = {
//     name : "suraj",
//     age : 23,
//     marks : 8.7,
//     city: "murbad"
//    };

//     console.log(student);

//     //update
//    student.city = "thane";
//    console.log(student);

//    //update
//    console.log(student.gender);
//     student.gender = "Male";
//     console.log(student);


//     //update with diff datatype
// student.marks = 'A';
// console.log(student);

// student.marks = [88,99,90];
// console.log(student);
// console.log(student.marks[0]);

// // delete

//    console.log(student);
// delete student.city;
//    console.log(student);



//OBJECTS OF OBJECTS

// const classInfo = {
//   suraj: {
//     city: "mumbai",
//     marks: 8.7,
//   },
//   viraj: {
//     city: "shahapur",
//     marks: 8.7,
//   },
//   sahil: {
//     city: "bhandup",
//     marks: 8.7,
//   }
// };

// console.log(classInfo);
// console.log(classInfo.suraj);
// console.log(classInfo.viraj);
// console.log(classInfo.sahil);

// console.log(classInfo.suraj.marks); // view add delete update










// //Array of Objects

// const classInfo = [
//   {
//     name: "suraj",
//     city: "mumbai",
//     marks: 8.7,
//   },
//   {
//      name: "viraj",
//     city: "shahapur",
//      marks: 8.7,
//   },
//   {
//      name: "sahil",
//     city: "bhandup",
//      marks: 8.7,
//   }
// ];

// console.log(classInfo);

// console.log(classInfo[0].name); //crud





// //Math Object  - js - collection of mathematical prop and methods
// console.log(Math);
// //properties

// Math.E //2.718281828459045
// Math.PI //3.141592653589793

// console.log(Math.E);
// console.log(Math.PI);


// //Methods
// console.log(Math.abs(-2));
// console.log(Math.pow(2,4));
// console.log(Math.floor(5.5));
// console.log(Math.ceil(5.5));
// console.log(Math.random());  // 0 ---- 1(exclusive)

// let num = Math.random(); // 0 - 0.999

//  num = num * 10;  // 0 - 9.9999
//  num = num + 1;    // 1 - 10.999

//  Math.floor(num); // 1 - 10


// console.log(Math.floor((Math.random()*10) + 1))



// //this

// const student = {
//     name : "suraj",
//     age : 22,
//     math : 90,
//     phy : 89,
//     eng : 90,
//     getAvg(){
//         console.log(this);
//         let avg = (this.eng + this.phy + this.math)/3;
//         console.log(`${this.name} get avg marks = ${avg}`);
//     }
// };

// function f(){
//     console.log(this);
// };





