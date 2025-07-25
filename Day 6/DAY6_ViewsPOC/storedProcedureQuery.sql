-- 1. Create a new database
CREATE DATABASE Student_storeprocedure;

-- 2. Use the database
USE Student_storeprocedure;

-- 3. Create the Students table
CREATE TABLE Students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100),
    age INT,
    city VARCHAR(50)
);

-- 4. Insert sample data
INSERT INTO Students (student_name, age, city) VALUES 
('Rohan Patil', 20, 'Mumbai'),
('Sneha Kulkarni', 21, 'Pune'),
('Amit Desai', 22, 'Nashik'),
('Pooja Mehta', 19, 'Mumbai'),
('Rahul Sharma', 23, 'Pune'),
('Neha Joshi', 22, 'Delhi');

SELECT * FROM Students WHERE city = 'mumbai';

--  Create the stored procedure to get students by city
DELIMITER //

CREATE PROCEDURE GetStudentsByCity(IN cityName VARCHAR(50))
BEGIN
    SELECT * FROM Students WHERE city = cityName;
END //

DELIMITER ;

CALL GetStudentsByCity('Mumbai');
-- CALL GetStudentsByCity('Mumbai');
 CALL GetStudentsByCity('Pune');

-- 1 Write a query to call the stored procedure and display students from Pune.

DELIMITER // 

CREATE procedure displayStuds1( IN cityName  VARCHAR(50))
	BEGIN 
		SELECT  student_name , city from Students where city =cityName;
	END //
DELIMITER ;

call displayStuds1('delhi');


-- 2 Write a query to fetch students whose city is Delhi using the stored procedure.

DELIMITER // 

CREATE procedure display( IN cityName  VARCHAR(50))
	BEGIN 
		SELECT  student_name , city from Students where city =cityName;
	END //
DELIMITER ;

call display('delhi');

-- 3   Write a stored procedure to count how many students live in Mumbai..

DELIMITER //
CREATE PROCEDURE TOTALCOUNT1(OUT TOTAL INT , IN cityName VARCHAR(50))
BEGIN 
	SELECT count(*) into TOTAL from Students where city =cityName;
END //

DELIMITER ;
call TOTALCOUNT1(@count , 'Mumbai');
select @count as mum_count;
select * from Students;

-- 4 Modify the GetStudentsByCity procedure to return only student names and ages.

DELIMITER //
CREATE PROCEDURE GETNAMEANDAGE1(IN cityname VARCHAR(50))
BEGIN 
	 SELECT student_name , age ,city from Students where city = cityname;
END //

delimiter ;

call GETNAMEANDAGE1('pune');

-- 5 Add marks column and return students with marks > 75

ALTER TABLE Students ADD marks INT;

-- Procedure
DELIMITER //

CREATE PROCEDURE GetHighScoringStudents()
BEGIN
    SELECT * FROM Students WHERE marks > 75;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE UpdateStudentMarks(
    IN sid INT,
    IN newMarks INT
)
BEGIN
    UPDATE Students 
    SET marks = newMarks 
    WHERE student_id = sid;
END //

DELIMITER ;

select * from Students;


CALL UpdateStudentMarks(2, 38);
CALL UpdateStudentMarks(3, 88);
CALL UpdateStudentMarks(4, 58);
CALL UpdateStudentMarks(5, 48);
CALL UpdateStudentMarks(6, 78);


-- ✅ Call:
CALL GetHighScoringStudents();








