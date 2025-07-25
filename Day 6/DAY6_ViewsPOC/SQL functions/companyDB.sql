-- Company Database Setup

-- Create Database
DROP DATABASE IF EXISTS CompanyDB;
CREATE DATABASE CompanyDB;
USE CompanyDB;

-- Table: Jobs
CREATE TABLE Jobs (
    job_id INT PRIMARY KEY AUTO_INCREMENT,
    job_title VARCHAR(100) NOT NULL UNIQUE,
    min_salary DECIMAL(10, 2),
    max_salary DECIMAL(10, 2)
);

-- Table: Departments
CREATE TABLE Departments (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100) NOT NULL UNIQUE,
    location VARCHAR(100)
);

-- Table: Employees
CREATE TABLE Employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(20),
    hire_date DATE NOT NULL,
    job_id INT,
    salary DECIMAL(10, 2) NOT NULL,
    manager_id INT,
    department_id INT,
    FOREIGN KEY (job_id) REFERENCES Jobs(job_id),
    FOREIGN KEY (department_id) REFERENCES Departments(department_id),
    FOREIGN KEY (manager_id) REFERENCES Employees(employee_id)
);

-- Insert Data into Jobs
INSERT INTO Jobs (job_title, min_salary, max_salary) VALUES
('CEO', 150000.00, 300000.00),
('HR Manager', 70000.00, 120000.00),
('Software Engineer', 80000.00, 150000.00),
('Project Manager', 90000.00, 160000.00),
('Data Analyst', 60000.00, 110000.00),
('Marketing Specialist', 55000.00, 100000.00),
('Sales Representative', 50000.00, 95000.00),
('Accountant', 65000.00, 115000.00),
('HR Assistant', 45000.00, 70000.00),
('Intern', 30000.00, 45000.00);

-- Insert Data into Departments
INSERT INTO Departments (department_name, location) VALUES
('Executive', 'Headquarters'),
('Human Resources', 'Main Office'),
('Engineering', 'Tech Hub'),
('Sales', 'Sales Center'),
('Marketing', 'Main Office'),
('Finance', 'Headquarters');

-- Employee ID values for manual insertion (for simplicity in this example)
-- John Doe (CEO): employee_id 1
-- Jane Smith (HR Manager): employee_id 2
-- Robert Johnson (Project Manager): employee_id 3
-- Emily Davis (Sales Rep): employee_id 4

-- Insert Data into Employees
INSERT INTO Employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id) VALUES
(1, 'John', 'Doe', 'john.doe@company.com', '555-1001', '2010-01-15', 1, 250000.00, NULL, 1),
(2, 'Jane', 'Smith', 'jane.smith@company.com', '555-1002', '2012-03-20', 2, 95000.00, 1, 2),
(3, 'Robert', 'Johnson', 'robert.j@company.com', '555-1003', '2015-06-01', 4, 120000.00, 1, 3),
(4, 'Emily', 'Davis', 'emily.d@company.com', '555-1004', '2016-09-10', 7, 85000.00, 1, 4),
(5, 'Michael', 'Brown', 'michael.b@company.com', '555-1005', '2018-01-05', 3, 90000.00, 3, 3),
(6, 'Sarah', 'Miller', 'sarah.m@company.com', '555-1006', '2019-04-12', 5, 75000.00, 3, 3),
(7, 'David', 'Wilson', 'david.w@company.com', '555-1007', '2020-07-30', 6, 60000.00, 4, 5),
(8, 'Jessica', 'Moore', 'jessica.m@company.com', '555-1008', '2021-11-25', 9, 50000.00, 2, 2),
(9, 'Chris', 'Taylor', 'chris.t@company.com', '555-1009', '2022-02-14', 7, 58000.00, 4, 4),
(10, 'Laura', 'Anderson', 'laura.a@company.com', '555-1010', '2023-08-01', 10, 35000.00, 3, 3),
(11, 'Daniel', 'Clark', 'daniel.c@company.com', '555-1011', '2017-05-01', 8, 80000.00, 1, 6);