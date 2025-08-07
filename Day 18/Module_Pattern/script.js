
const ToDoModule = (function () 
{
    let tasks = []; 

    // Private render function
    function renderTasks() {
        const list = document.getElementById("taskList");
        list.innerHTML = "";

        tasks.forEach((task, index) => 
            {
            const li = document.createElement("li");
            li.textContent = task;

            const span = document.createElement("span");
            span.textContent = "❌";
            span.classList.add("remove-btn");
            span.onclick = () => removeTask(index);

            li.appendChild(span);
            list.appendChild(li);
        });
    }


    function removeTask(index) 
    {
        tasks.splice(index, 1);
        renderTasks();
    }

    
    
    return {
        addTask: function (task) 
        {
            if (task.trim() !== "") 
                {
                tasks.push(task);
                renderTasks();
            } else 
                {
                alert("Please enter a valid task.");
            }
        }
    };
})();
