
var form = document.getElementById("studentForm");
var tableBody = document.getElementById("studentTableBody");


form.onsubmit = function(event)
 {
  event.preventDefault(); 

  getValues();
  addRow();
  clearForm();
};


var id, fname, lname, email;


function getValues()
 {
  id = document.getElementById("id").value;
  fname = document.getElementById("fname").value;
  lname = document.getElementById("lname").value;
  email = document.getElementById("email").value;
}


function addRow() 
{
  var row = document.createElement("tr");

  var cell1 = document.createElement("td");
  cell1.innerText = id;
  row.appendChild(cell1);

  var cell2 = document.createElement("td");
  cell2.innerText = fname;
  row.appendChild(cell2);

  var cell3 = document.createElement("td");
  cell3.innerText = lname;
  row.appendChild(cell3);

  var cell4 = document.createElement("td");
  cell4.innerText = email;
  row.appendChild(cell4);

  tableBody.appendChild(row);
}

function clearForm() 
{
  form.reset();
}