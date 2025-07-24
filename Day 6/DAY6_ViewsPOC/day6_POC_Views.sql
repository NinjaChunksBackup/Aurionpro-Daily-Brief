
-- create database poc_views;

-- use poc_views;

-- Syntax of Creating a View

-- CREATE VIEW view_name AS
-- SELECT column1, column2, ...
-- FROM table_name
-- WHERE condition;

-- SELECT * FROM view_name;


-- Rules to Update Views in SQL:
-- Certain conditions need to be satisfied to update a view. If any of these conditions are not met, the view can not be updated.

-- The SELECT statement which is used to create the view should not include GROUP BY clause or ORDER BY clause.
-- The SELECT statement should not have the DISTINCT keyword.
-- The View should have all NOT NULL values.
-- The view should not be created using nested queries or complex queries.
-- The view should be created from a single table. If the view is created using multiple tables then we will not be allowed to update the view.



CREATE TABLE Employees (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    DeptID INT,
    Salary INT
);


INSERT INTO Employees (EmpID, Name, DeptID, Salary) VALUES
-- (101, 'Alice', 1, 50000),
-- (102, 'Bob', 2, 70000),
-- (103, 'Charlie', 2, 60000),
-- (104, 'Diana', 3, 75000),
-- (105, 'Eva', 1, 55000),
(106, 'Prnaav', 3, 90000);





CREATE TABLE Departments (
    DeptID INT PRIMARY KEY,
    DeptName VARCHAR(50)
);


INSERT INTO Departments (DeptID, DeptName) VALUES
(1, 'HR'),
(2, 'IT'),
(3, 'Finance');


select * from Employees;

select * from Departments ;



-- 1 .  Create Views


-- This view can be updated because:
-- based on a single table
-- No JOIN, GROUP BY, or DISTINCT

CREATE VIEW HighSalaryEmployees AS
SELECT EmpID, Name, Salary
FROM Employees
WHERE Salary > 60000;

SELECT * FROM HighSalaryEmployees;



-- 2 Join view (not updatable)


CREATE VIEW EmployeeDetails AS
SELECT e.EmpID, e.Name, d.DeptName, e.Salary
FROM Employees e
JOIN Departments d ON e.DeptID = d.DeptID;

SELECT * FROM EmployeeDetails;







--  trying to uodate views

 -- 1)  
 
 UPDATE HighSalaryEmployees
SET Salary = 75000
WHERE EmpID = 102;


select * from HighSalaryEmployees;

select * from Employees;




-- 2)



UPDATE EmployeeDetails
SET Salary = 99999
WHERE EmpID = 102;

SELECT * FROM EmployeeDetails;


-- Error: view is not updatable due to join




--   ---- View with JOIN (multi-table)
-- non updatable  since AVG(Salary) derived column — you can't trace it back to specific rows to modify.



CREATE VIEW DepartmentAverageSalary AS
SELECT DeptID, AVG(Salary) AS AvgSalary
FROM Employees
GROUP BY DeptID;


select * from  DepartmentAverageSalary;


UPDATE DepartmentAverageSalary
SET AvgSalary = 85000
WHERE DeptID = 3;






-- --------------------------------------------------------
--  View with DISTINCT  

CREATE VIEW DistinctSalaries AS
SELECT DISTINCT Salary FROM Employees;

select * from DistinctSalaries;

-- not guaranteed to match unique rows in the base table, so cant update


UPDATE DistinctSalaries
SET Salary = 99999
WHERE Salary = 90000;



-- ----------------------------

-- create a view using UNION:

CREATE VIEW HighLowEarners AS
SELECT EmpID, Name, Salary
FROM Employees
WHERE Salary > 80000

UNION

SELECT EmpID, Name, Salary
FROM Employees
WHERE Salary < 60000;


select * from HighLowEarners ;

-- error 

UPDATE HighLowEarners
SET Salary = 85000
WHERE EmpID = 105;

