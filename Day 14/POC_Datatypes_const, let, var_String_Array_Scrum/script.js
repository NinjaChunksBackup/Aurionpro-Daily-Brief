//alert
alert("Hello! This is a JavaScript alert box.");


//DATA TYPES

 // 1. String
let name = "Alice";
console.log("String:", name); 

// 2. Number
let age = 30;
let height = 5.9;
console.log("Number:", age, height); 

// 3. Boolean
let isStudent = true;
console.log("Boolean:", isStudent); 

// 4. Undefined
let score;
console.log("Undefined:", score); 

// 5. Null
let selectedItem = null;
console.log("Null:", selectedItem); 

// 6. BigInt
let bigNumber = 1234567890123456789012345678901234567890n;
console.log("BigInt:", bigNumber);

// 7. Symbol
let id = Symbol("id");
console.log("Symbol:", id);

// 8. Object
let person = 
{
  firstName: "John",
  lastName: "Doe",
  age: 25
};
console.log("Object:", person);

// Array (a special object)
let fruits = ["apple", "banana", "cherry"];
console.log("Array:", fruits);

// Function (also a type of object)
function greet() 
{
  return "Hello!";
}
console.log("Function:", greet());

// ----------- var -----------
var x = 10;
console.log("var x =", x); 

var x = 20; 
console.log("var x after re-declare =", x); 

// ----------- let -----------
let y = 15;
console.log("let y =", y); 

y = 25; 
console.log("let y after update =", y); 

//let y = 30;                            //can't re-declare in the same scope

// ----------- const -----------
const z = 50;
console.log("const z =", z); 

//z = 60;                   // can't update a const
//const z = 70;             //can't re-declare a const

// Block Scope Example
{
  var a = 1;
  let b = 2;
  const c = 3;
}

console.log("var a outside block =", a); 
//console.log("let b =", b); 
//console.log("const c =", c); 

//------STRING------

// Regular Strings
let firstName = "John";
let lastName = 'Doe';
let quote = "It's a great day!";
console.log("Regular string:", quote);

// Template String (Template Literal)
let age1 = 25;
let greeting = `Hello, my name is ${firstName} ${lastName} and I am ${age1} years old.`;
console.log("Template string:", greeting);

// Multiline Template String
let multiline = `This is line one.
This is line two.
This is line three.`;
console.log("Multiline template string:\n", multiline);

// String Methods
let text = "  JavaScript is Fun!  ";

console.log("Original:", text);
console.log("Length:", text.length);
console.log("Uppercase:", text.toUpperCase());
console.log("Lowercase:", text.toLowerCase());
console.log("Char at 5:", text.charAt(5));
console.log("Includes 'Script':", text.includes("Script"));
console.log("Index of 'Fun':", text.indexOf("Fun"));
console.log("Slice (5, 15):", text.slice(5, 15));
console.log("Replace 'Fun' with 'Awesome':", text.replace("Fun", "Awesome"));
console.log("Trimmed:", text.trim());



//--aRRAY

// Creating an array
let fruits1 = ["apple", "banana", "cherry"];
console.log("Original array:", fruits1);

// length
console.log("Length:", fruits.length);

// push - add at end
fruits.push("orange");
console.log("After push:", fruits);

// pop - remove from end
fruits.pop();
console.log("After pop:", fruits);

// unshift - add at beginning
fruits.unshift("mango");
console.log("After unshift:", fruits);

// shift - remove from beginning
fruits.shift();
console.log("After shift:", fruits);

// indexOf
console.log("Index of 'banana':", fruits.indexOf("banana"));

// includes
console.log("Includes 'cherry'?", fruits.includes("cherry"));

// slice (doesn't modify original)
let sliced = fruits.slice(0, 2);
console.log("Slice (0,2):", sliced);

// splice (modifies original)
fruits.splice(1, 1);
console.log("After splice:", fruits);

// join
let joined = fruits.join(" | ");
console.log("Joined:", joined);

// sort
let numbers = [5, 2, 8, 1];
numbers.sort((a, b) => a - b); 
console.log("Sorted numbers:", numbers);

// reverse
numbers.reverse();
console.log("Reversed numbers:", numbers);

// forEach
console.log("Using forEach:");
fruits.forEach((fruit, index) => 
{
  console.log(`${index}: ${fruit}`);
});

// map
let upperFruits = fruits.map(fruit => fruit.toUpperCase());
console.log("Mapped to uppercase:", upperFruits);

