const form = document.getElementById("userForm");
const tbody = document.getElementById("tableBody");

form.addEventListener("submit", function(event) {
  event.preventDefault();


  const id = document.getElementById("userId").value;
  const firstName = document.getElementById("firstName").value;
  const lastName = document.getElementById("lastName").value;
  const email = document.getElementById("email").value;

  const newRow = document.createElement("tr");

  const idCell = document.createElement("td");
  idCell.textContent = id;

  const firstNameCell = document.createElement("td");
  firstNameCell.textContent = firstName;

  const lastNameCell = document.createElement("td");
  lastNameCell.textContent = lastName;

  const emailCell = document.createElement("td");
  emailCell.textContent = email;

  
  newRow.appendChild(idCell);
  newRow.appendChild(firstNameCell);
  newRow.appendChild(lastNameCell);
  newRow.appendChild(emailCell);


  tbody.appendChild(newRow);


  form.reset();
});
