//chaining
const ages = [12, 25, 30, 10, 18, 21];


ages
  .filter(age => age > 18)   
  .map(age => age * 2)           
  .forEach(age => console.log(age)); 



const names = ["Alice", "Bob", "Alex", "Charlie"];

names
  .filter(name => name.startsWith("A"))  
  .map(name => name.toUpperCase())       
  .forEach(name => console.log(name));  






// Date object


const dateObj = new Date();           
console.log("Date:", dateObj);

// Timestamp (milliseconds)

const timestamp = Date.now();         
console.log("Timestamp:", timestamp);

// Convert timestamp to date

const newDate = new Date(timestamp);
console.log("Converted Date:", newDate);





//Date-fns

import { format, addDays, differenceInDays, isBefore } from "https://cdn.jsdelivr.net/npm/date-fns@3.6.0/+esm";

document.getElementById("run").addEventListener("click", () => 
  {
  const output = document.getElementById("output");

  const today = new Date();
  const futureDate = addDays(today, 10);
  const formatted = format(today, 'yyyy-MM-dd');
  const futureFormatted = format(futureDate, 'do MMMM yyyy');

  const date1 = new Date('2025-07-01');
  const date2 = new Date('2025-07-30');
  const diff = differenceInDays(date2, date1);
  const before = isBefore(date1, date2);

  output.innerHTML = `
    <strong>Today:</strong> ${formatted}<br>
    <strong>+10 Days:</strong> ${futureFormatted}<br>
    <strong>Days between July 1 and July 30, 2025:</strong> ${diff} days<br>
    <strong>Is July 1 before July 30?</strong> ${before ? 'Yes' : 'No'}<br>
  `;
});
