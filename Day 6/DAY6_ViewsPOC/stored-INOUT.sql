CREATE DATABASE  StoredProcedure_basic;
USE StoredProcedure_basic;

CREATE TABLE IF NOT EXISTS Students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100),
    age INT,
    city VARCHAR(50)
);

INSERT INTO Students (student_name, age, city) VALUES
('Mayuri Phapale', 21, 'Pune'),
('Rohan Patil', 22, 'Mumbai'),
('Sneha Kulkarni', 23, 'Nashik');

select * from Students;

-- IN PARAMETER  (Get student details by ID)

DELIMITER //

CREATE PROCEDURE GetStudentById(IN sid INT)
BEGIN
    SELECT * FROM Students WHERE student_id = sid;
END //

DELIMITER ;

CALL GetStudentById(2);

-- OUT PARAMETER (Count total number of students)

DELIMITER //

CREATE PROCEDURE GetTotalStudentCount(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM Students;
END //

DELIMITER ;

CALL GetTotalStudentCount(@count);
SELECT @count AS Total_Students;

-- INOUT PARAMETER (Double the marks)

-- Create procedure using INOUT to modify value
DELIMITER //

CREATE PROCEDURE DoubleMarks(INOUT marks INT)
BEGIN
    SET marks = marks * 2;
END //

DELIMITER ;

SET @m = 40;
CALL DoubleMarks(@m);
SELECT @m AS Doubled_Marks;








