document.getElementById("addBtn").addEventListener("click", function () {
    const input = document.getElementById("taskInput");
    ToDoModule.addTask(input.value);
    input.value = "";
});
