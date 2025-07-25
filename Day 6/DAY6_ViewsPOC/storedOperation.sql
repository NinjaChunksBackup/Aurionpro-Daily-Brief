CREATE DATABASE  StoredProcedureOperations;
USE StoredProcedureOperations;

-- Create Students table
CREATE table Students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100),
    age INT,
    city VARCHAR(50)
);


-- INSERT 

DELIMITER //

CREATE PROCEDURE InsertStudent(
    IN name VARCHAR(100),
    IN age INT,
    IN city VARCHAR(50)
)
BEGIN
    INSERT INTO Students (student_name, age, city)
    VALUES (name, age, city);
END //

DELIMITER ;
CALL InsertStudent('Mayuri Phapale', 21, 'Pune');
CALL InsertStudent('Rohan Patil', 22, 'Mumbai');
CALL InsertStudent('Sneha Kulkarni', 23, 'Nashik');
CALL InsertStudent('Amit Desai', 20, 'Delhi');
CALL InsertStudent('Pooja Mehta', 24, 'Pune');


select * from Students;

-- SELECT 

DELIMITER //

CREATE PROCEDURE GetAllStudents()
BEGIN
    SELECT * FROM Students;
END //

DELIMITER ;

CALL GetAllStudents();

-- UPDATE

DELIMITER //

CREATE PROCEDURE UpdateStudentAge(
    IN sid INT,
    IN newAge INT
)
BEGIN
    UPDATE Students
    SET age = newAge
    WHERE student_id = sid;
END //

DELIMITER ;

CALL UpdateStudentAge(2, 25);
CALL GetAllStudents();

-- DELETE

DELIMITER //

CREATE PROCEDURE DeleteStudentById(
    IN sid INT
)
BEGIN
    DELETE FROM Students
    WHERE student_id = sid;
END //

DELIMITER ;

CALL DeleteStudentById(2);
CALL GetAllStudents();







