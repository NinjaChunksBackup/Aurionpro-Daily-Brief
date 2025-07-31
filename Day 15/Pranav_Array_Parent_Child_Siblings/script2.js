const list = document.getElementById("fruit-list");


console.log(list.children);
console.log("first child element :"+list.firstElementChild.outerHTML);      
console.log("last child element :"+list.lastElementChild.innerHTML);       


// console.log("parent elemnt :"+list.parentElement.outerHTML);    


console.log(list.previousElementSibling); 


const bananaItem = list.children[1];      

console.log(bananaItem.nextElementSibling); 
console.log(bananaItem.previousElementSibling.outerHTML); 


  bananaItem.textContent = "Green Banana";

  bananaItem.nextElementSibling.style.color = "green";



  
list.removeChild(list.firstElementChild);


const newItem = document.createElement("li");
newItem.textContent = "Orange";

list.appendChild(newItem);





 // Insert before or after a specific item

const oranges = list.lastElementChild;
console.log("curent lst item is :"+oranges.outerHTML);

 const cherryItem = document.createElement("li");
cherryItem.textContent = "cherries";

list.insertBefore(cherryItem, oranges);











// //Arrays
const numbers = [1, 2, 3, 4, 5];

const evens = numbers.filter(num => num % 2 === 0);

console.log("even numbers "+evens); 




const prices = [100, 200, 300];
const gstPrices = prices.map(p => p * 1.18);

console.log(gstPrices); // [118, 236, 354]




const nums = [10, 20, 30];
const total = nums.reduce(    (acc, curr) => acc + curr  ,      0);

console.log(total); // 60




const users = [
  { id: 1, name: "Bob" },
  { id: 2, name: "Alice" }
];

const user = users.find(u => u.name === "Alice");

console.log(user); 




const scores = [30, 100, 5, 20];
// scores.sort((a, b) => a - b);  // ascending
// console.log(scores); // 
scores.sort();
console.log("sorted array"+scores)






















const person = {
  name: "Alice",
  age: 25,
  greet: function() {
    console.log("Hello " + this.name);
  }
};

console.log(person);


person.greet();


person.city = "Mumbai";



delete person.age;


console.log(person);