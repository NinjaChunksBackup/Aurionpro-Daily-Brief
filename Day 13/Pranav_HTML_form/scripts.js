function addDetails(){

    const studentIdInput = document.getElementById('student_id'); 
    const firstNameInput = document.getElementById('fname');
    const lastNameInput = document.getElementById('lname');
    const emailInput = document.getElementById('email');

    const studentId = studentIdInput.value; 
    const firstName = firstNameInput.value;
    const lastName = lastNameInput.value;
    const email = emailInput.value;


    const tbodyRef = document.querySelector("tbody");

    newHtml = ``; 

    newHtml += ` <tr>
        <td>${studentId}</td>
        <td>${firstName}</td>
        <td>${lastName}</td>
        <td>${email}</td>
        </tr> `;

    tbodyRef.innerHTML += newHtml;

    studentIdInput.value = '';
    firstNameInput.value = '';
    lastNameInput.value = '';
    emailInput.value = '';

}