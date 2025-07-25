-- Types of Functions in MySQL

-- 1. Scalar Functions
--    * String Functions
--    * Numeric/Mathematical Functions
--    * Date and Time Functions
--    * Conversion Functions
--    * Conditional Functions
--    * Information Functions

-- 2. Aggregate Functions (Group Functions)
--    * COUNT()
--    * SUM()
--    * AVG()
--    * MIN()
--    * MAX()
--    * GROUP_CONCAT()
--    * VAR_SAMP() / VAR_POP()
--    * STDDEV_SAMP() / STDDEV_POP()
--    * BIT_AND() / BIT_OR() / BIT_XOR()

-- 3. Window Functions
--    * Ranking Functions
--    * Value Functions
--    * Aggregate Window Functions

-- 4. User-Defined Functions (UDFs)
--    * Scalar UDFs
--    * Table-Valued Functions (as Stored Functions that return a table)

-- 5. Spatial Analysis Functions

-- 6. JSON Functions



-- Scalar Functions in CompanyDB

-- Scalar functions operate on individual values and return a single value for each row.
USE companydb;
-- ---
-- 1. String Functions
-- These functions are used to manipulate text data (strings).

-- String Function Examples:

SELECT
    first_name,
    LENGTH(first_name) AS name_length
FROM
    Employees;

SELECT
    UPPER(first_name) AS upper_first_name,
    LOWER(last_name) AS lower_last_name
FROM
    Employees;

SELECT
    department_name,
    SUBSTRING(department_name, 1, 3) AS department_prefix
FROM
    Departments;

SELECT
    CONCAT(first_name, ' ', last_name) AS full_name
FROM
    Employees;

-- Explanation for LENGTH(): This function counts how many characters are in a text string.
-- Explanation for UPPER() and LOWER(): UPPER() changes all letters in a text to capital letters. LOWER() changes all letters to small letters.
-- Explanation for SUBSTRING(): This function pulls out a specific part of a text string. You tell it where to start (the first character is position 1) and how many characters to take. (MID() works the same way).
-- Explanation for CONCAT(): This function joins two or more text pieces together to form one longer string.

-- Other String Functions and their purpose:
-- LEFT(string, length): Gets characters from the beginning of a string.
-- RIGHT(string, length): Gets characters from the end of a string.
-- CONCAT_WS(separator, string1, string2, ...): Joins strings with a specific character (separator) in between, skipping any empty ones.
-- TRIM(): Removes extra spaces (or other characters) from the beginning and end of a string.
-- LTRIM(): Removes spaces (or characters) from the left side of a string.
-- RTRIM(): Removes spaces (or characters) from the right side of a string.
-- REPLACE(string, old_string, new_string): Swaps out all occurrences of one part of a string for another.
-- INSTR(string, substring) / LOCATE(substring, string): Finds where a smaller piece of text (substring) starts within a larger string.
-- LPAD(string, length, pad_string): Adds characters to the left side of a string until it reaches a certain total length.
-- RPAD(string, length, pad_string): Adds characters to the right side of a string until it reaches a certain total length.

-- ---
-- 2. Numeric/Mathematical Functions
-- These functions perform calculations on numbers.

-- Numeric/Mathematical Function Examples:

SELECT
    employee_id,
    salary,
    ABS(salary) AS absolute_salary
FROM
    Employees;

SELECT
    first_name,
    salary,
    ROUND(salary, 0) AS rounded_salary
FROM
    Employees;

SELECT
    first_name,
    salary,
    salary / 10.5 AS calculated_bonus,
    CEILING(salary / 10.5) AS bonus_rounded_up,
    FLOOR(salary / 10.5) AS bonus_rounded_down
FROM
    Employees;

SELECT
    first_name,
    salary,
    POWER(1.05, 2) AS growth_factor,
    salary * POWER(1.05, 2) AS projected_salary
FROM
    Employees;

-- Explanation for ABS(): This gives you the positive version of a number.
-- Explanation for ROUND(): This function makes a number "rounder" to a specific number of decimal places.
-- Explanation for CEILING() and FLOOR(): CEILING() (or CEIL()) always rounds a number *up* to the nearest whole number. FLOOR() always rounds a number *down* to the nearest whole number.
-- Explanation for POWER(): This function calculates a number raised to a certain power. (POW() works the same way).

-- Other Numeric/Mathematical Functions and their purpose:
-- TRUNCATE(number, decimals): Cuts off a number at a specific decimal point, without rounding.
-- SQRT(number): Calculates the square root of a number.
-- MOD(dividend, divisor): Gives you the remainder after dividing one number by another.
-- RAND(): Generates a completely random number between 0 and 1.

-- ---
-- 3. Date and Time Functions
-- These functions help you work with dates and times.

-- Date and Time Function Examples:

SELECT
    NOW() AS current_datetime,
    CURDATE() AS current_date_only;

SELECT
    first_name,
    last_name,
    hire_date,
    YEAR(hire_date) AS hire_year,
    MONTH(hire_date) AS hire_month,
    DAY(hire_date) AS hire_day
FROM
    Employees;

SELECT
    first_name,
    last_name,
    hire_date,
    DATEDIFF(CURDATE(), hire_date) AS days_worked
FROM
    Employees;

SELECT
    first_name,
    hire_date,
    DATE_ADD(hire_date, INTERVAL 3 MONTH) AS hired_3_months_later,
    DATE_SUB(hire_date, INTERVAL 1 YEAR) AS hired_1_year_earlier
FROM
    Employees;

-- Explanation for NOW() and CURDATE(): NOW() tells you the exact date and time right now. CURDATE() gives you just the current date. (CURRENT_TIMESTAMP() and CURRENT_DATE() are identical).
-- Explanation for YEAR(), MONTH(), DAY(): These functions extract specific parts from a date (year, month number, day of the month).
-- Explanation for DATEDIFF(): This calculates how many days are between two dates (date1 minus date2).
-- Explanation for DATE_ADD() and DATE_SUB(): DATE_ADD() adds a specific amount of time to a date. DATE_SUB() subtracts a specific amount of time from a date.

-- Other Date and Time Functions and their purpose:
-- CURTIME() / CURRENT_TIME(): Returns the current time only.
-- HOUR() / MINUTE() / SECOND(): Extracts the hour, minute, or second from a time value.
-- TIMEDIFF(): Calculates the difference between two time values.
-- DATE_FORMAT(date, format_string): Changes how a date is displayed into a specific text format (e.g., 'July 24, 2025').
-- STR_TO_DATE(string, format_string): Converts a text string into a proper date value, telling MySQL what format the text is in.
-- DAYNAME(date): Gives the name of the day of the week (e.g., 'Thursday').
-- MONTHNAME(date): Gives the name of the month (e.g., 'July').
-- WEEK(date) / WEEKOFYEAR(date): Returns the week number within the year.
-- LAST_DAY(date): Returns the last day of the month for a given date.
-- TIMESTAMPDIFF(unit, datetime_expr1, datetime_expr2): Calculates the difference between two date/time values in a specified unit (e.g., 'YEAR', 'MONTH', 'HOUR').

-- ---
-- 4. Conversion Functions
-- These functions change data from one type to another (e.g., number to text, text to number).

-- Conversion Function Examples:

SELECT
    employee_id,
    CAST(employee_id AS CHAR) AS employee_id_as_string,
    LENGTH(CAST(employee_id AS CHAR)) AS string_length
FROM
    Employees;

SELECT
    first_name,
    salary,
    CONVERT(salary, DECIMAL(10, 0)) AS salary_as_whole_number
FROM
    Employees;

-- Explanation for CAST(): This function explicitly changes a value from one data type to another.
-- Explanation for CONVERT(): This function is very similar to CAST() and also changes a value's data type.

-- ---
-- 5. Conditional Functions
-- These functions let you apply "if-then-else" logic within your queries.

-- Conditional Function Examples:

SELECT
    first_name,
    last_name,
    salary,
    CASE
        WHEN salary > 100000 THEN 'High Earner'
        WHEN salary >= 60000 THEN 'Mid Earner'
        ELSE 'Junior Staff'
    END AS salary_category
FROM
    Employees;

SELECT
    first_name,
    last_name,
    hire_date,
    IF(hire_date > '2020-01-01', 'New Hire', 'Experienced') AS employee_status
FROM
    Employees;

SELECT
    first_name,
    last_name,
    manager_id,
    IFNULL(manager_id, 'No Manager') AS actual_manager_id
FROM
    Employees;

SELECT
    first_name,
    last_name,
    phone_number,
    COALESCE(phone_number, 'N/A', 'Contact HR') AS primary_contact_number
FROM
    Employees;

-- Explanation for CASE: This is a powerful way to define different results based on different conditions (WHEN...THEN...ELSE...END).
-- Explanation for IF(): This is a simpler conditional function for when you only have two possible outcomes (IF(condition, value_if_true, value_if_false)).
-- Explanation for IFNULL(): This function checks if a value is NULL. If it is, it replaces it with a value you provide.
-- Explanation for COALESCE(): This function goes through a list of values and returns the *first one that is not NULL*.

-- Other Conditional Functions and their purpose:
-- NULLIF(expr1, expr2): Returns NULL if expr1 and expr2 are equal; otherwise, returns expr1.

-- ---
-- 6. Information Functions
-- These functions provide details about your MySQL database, your user session, or the server itself.

-- Information Function Examples:

SELECT DATABASE() AS current_database_name;

SELECT USER() AS current_sql_user;

SELECT VERSION() AS mysql_server_version;

-- Explanation for DATABASE(): This function tells you the name of the database you are currently connected to. (SCHEMA() is identical).
-- Explanation for USER(): This function shows you the username and host that you are currently logged into MySQL with. (CURRENT_USER() is identical).
-- Explanation for VERSION(): This function tells you the exact version number of the MySQL server software.




-- Aggregate Functions in CompanyDB

-- Aggregate functions perform a calculation on a set of rows and return a single summary value.
-- They are commonly used with the GROUP BY clause to group rows that have the same values
-- in specified columns into a set of summary rows.

-- ---
-- Aggregate Function Examples:

-- Example 1: COUNT()
-- Question: How many employees are there in total?
SELECT
    COUNT(employee_id) AS total_employees
FROM
    Employees;

-- Question: How many employees are in each department?
SELECT
    d.department_name,
    COUNT(e.employee_id) AS num_employees
FROM
    Employees e
JOIN
    Departments d ON e.department_id = d.department_id
GROUP BY
    d.department_name;

-- Explanation for COUNT(): This function counts rows. COUNT(column_name) counts non-NULL values in that column. COUNT(*) counts all rows.
-- When used with GROUP BY, it counts rows within each group, giving you a count per category (e.g., per department).

-- Example 2: SUM()
-- Question: What is the total salary paid across all employees?
SELECT
    SUM(salary) AS total_company_salary
FROM
    Employees;

-- Question: What is the total salary paid in each department?
SELECT
    d.department_name,
    SUM(e.salary) AS total_department_salary
FROM
    Employees e
JOIN
    Departments d ON e.department_id = d.department_id
GROUP BY
    d.department_name;

-- Explanation for SUM(): This function adds up all the numeric values in a specified column.
-- When used with GROUP BY, it calculates the sum for each distinct group.

-- Example 3: AVG()
-- Question: What is the average salary of all employees?
SELECT
    AVG(salary) AS average_company_salary
FROM
    Employees;

-- Question: What is the average salary for each job title?
SELECT
    j.job_title,
    AVG(e.salary) AS average_job_salary
FROM
    Employees e
JOIN
    Jobs j ON e.job_id = j.job_id
GROUP BY
    j.job_title;

-- Explanation for AVG(): This function calculates the average (mean) of all numeric values in a column.
-- When used with GROUP BY, it computes the average for each group.

-- Example 4: MIN()
-- Question: What is the lowest salary among all employees?
SELECT
    MIN(salary) AS lowest_salary
FROM
    Employees;

-- Question: What is the minimum salary in each department?
SELECT
    d.department_name,
    MIN(e.salary) AS min_department_salary
FROM
    Employees e
JOIN
    Departments d ON e.department_id = d.department_id
GROUP BY
    d.department_name;

-- Explanation for MIN(): This function finds the smallest (minimum) value in a specified column.
-- When used with GROUP BY, it finds the minimum value for each group.

-- Example 5: MAX()
-- Question: What is the highest salary among all employees?
SELECT
    MAX(salary) AS highest_salary
FROM
    Employees;

-- Question: What is the maximum salary in each department?
SELECT
    d.department_name,
    MAX(e.salary) AS max_department_salary
FROM
    Employees e
JOIN
    Departments d ON e.department_id = d.department_id
GROUP BY
    d.department_name;

-- Explanation for MAX(): This function finds the largest (maximum) value in a specified column.
-- When used with GROUP BY, it finds the maximum value for each group.

-- Example 6: GROUP_CONCAT()
-- Question: For each department, list the names of all employees working in it, separated by commas.
SELECT
    d.department_name,
    GROUP_CONCAT(e.first_name, ' ', e.last_name ORDER BY e.first_name SEPARATOR ', ') AS employees_in_department
FROM
    Employees e
JOIN
    Departments d ON e.department_id = d.department_id
GROUP BY
    d.department_name;

-- Explanation for GROUP_CONCAT(): This is a powerful MySQL-specific aggregate function that concatenates (joins) strings from multiple rows within a group into a single string.
-- You can specify an ORDER BY clause within it to sort the concatenated items, and a SEPARATOR to define what goes between them.

-- ---
-- Other Aggregate Functions and their purpose:
-- VAR_SAMP(): Calculates the sample variance of a set of numbers.
-- VAR_POP(): Calculates the population variance of a set of numbers.
-- STDDEV_SAMP(): Calculates the sample standard deviation of a set of numbers.
-- STDDEV_POP(): Calculates the population standard deviation of a set of numbers.
-- BIT_AND(): Performs a bitwise AND operation on all bits in a column within a group.
-- BIT_OR(): Performs a bitwise OR operation on all bits in a column within a group.
-- BIT_XOR(): Performs a bitwise XOR (exclusive OR) operation on all bits in a column within a group.






-- Window Functions in CompanyDB

-- Window functions perform calculations across a set of table rows that are related to the current row.
-- The key difference from aggregate functions is that window functions *do not collapse rows*.
-- They return a value for each row, but that value is calculated based on a "window" (a defined set) of rows.
-- The `OVER()` clause is central to all window functions, defining this "window".
--    - `PARTITION BY`: Divides the rows into groups (like GROUP BY), and the function operates independently within each partition.
--    - `ORDER BY`: Sorts the rows within each partition, which is crucial for functions like ROW_NUMBER, LAG, LEAD, and running totals.

-- ---
-- Window Function Examples:

-- Example 1: ROW_NUMBER()
-- Question: Assign a unique sequential number to each employee within their respective department, based on their hire date.
SELECT
    e.first_name,
    e.last_name,
    d.department_name,
    e.hire_date,
    ROW_NUMBER() OVER (PARTITION BY d.department_id ORDER BY e.hire_date) AS employee_rank_in_dept
FROM
    Employees e
JOIN
    Departments d ON e.department_id = d.department_id;

-- Explanation for ROW_NUMBER(): This function assigns a unique, sequential integer (1, 2, 3, ...) to each row within a defined group (partition), based on a specified order.
-- Here, it numbers employees starting from 1 for each department, ordered by who was hired first.

-- Example 2: RANK() and DENSE_RANK()
-- Question: Rank employees within each department by their salary (highest salary gets rank 1). Show the difference between RANK and DENSE_RANK for ties.
SELECT
    e.first_name,
    e.last_name,
    d.department_name,
    e.salary,
    RANK() OVER (PARTITION BY d.department_id ORDER BY e.salary DESC) AS salary_rank_with_gaps,
    DENSE_RANK() OVER (PARTITION BY d.department_id ORDER BY e.salary DESC) AS salary_dense_rank_no_gaps
FROM
    Employees e
JOIN
    Departments d ON e.department_id = d.department_id;

-- Explanation for RANK(): Assigns a rank to each row within its partition. If there are ties (same salary), they get the same rank, and then the next rank skips numbers (creates gaps).
-- Explanation for DENSE_RANK(): Similar to RANK, but if there are ties, they get the same rank, and the next rank does *not* skip numbers (no gaps). It's "dense."


-- Example 5: Aggregate Function as a Window Function (SUM() OVER())
-- Question: For each employee, show their salary and a running total of salaries for employees hired before or on their hire date within their department.
SELECT
    e.first_name,
    e.last_name,
    d.department_name,
    e.hire_date,
    e.salary,
    SUM(e.salary) OVER (PARTITION BY d.department_id ORDER BY e.hire_date) AS running_total_dept_salary
FROM
    Employees e
JOIN
    Departments d ON e.department_id = d.department_id;

-- Explanation for SUM() OVER(): When an aggregate function like SUM() is used with an OVER() clause, it becomes a window function.
-- It calculates the sum not for the entire group (like a regular aggregate), but for a "window" of rows related to the current row.
-- Here, `(PARTITION BY d.department_id ORDER BY e.hire_date)` means: "for each department, sum up salaries for all employees from the beginning of that department's hire dates up to the current employee's hire date." This creates a running total.

-- Example 6: Aggregate Function as a Window Function (AVG() OVER())
-- Question: For each employee, show their salary and the average salary of *all* employees in their department.
SELECT
    e.first_name,
    e.last_name,
    d.department_name,
    e.salary,
    AVG(e.salary) OVER (PARTITION BY d.department_id) AS avg_department_salary
FROM
    Employees e
JOIN
    Departments d ON e.department_id = d.department_id;

-- Explanation for AVG() OVER(): When AVG() is used as a window function *without* an ORDER BY clause in the OVER() part (only PARTITION BY), it calculates the average for the entire partition.
-- This allows you to show an individual employee's salary alongside the average for their entire department, on every row, without having to group the data and lose individual employee details.

-- ---
-- Other Window Functions and their purpose:
-- NTILE(n): Divides the rows in a partition into 'n' groups and assigns a group number (from 1 to 'n') to each row. Useful for bucketing data into percentiles or quantiles.
-- FIRST_VALUE(column): Returns the value of the 'column' from the first row in the current window frame.
-- LAST_VALUE(column): Returns the value of the 'column' from the last row in the current window frame.
-- NTH_VALUE(column, n): Returns the value of the 'column' from the nth row in the current window frame.
-- PERCENT_RANK(): Calculates the relative rank of a row within its partition, as a percentage.
-- CUME_DIST(): Calculates the cumulative distribution of a value within its partition.




-- User-Defined Functions (UDFs) in CompanyDB

-- User-Defined Functions (UDFs) are custom functions created by users to encapsulate
-- specific logic that can be reused in SQL queries. They promote modularity and simplify complex SQL.

-- ---
-- 1. Scalar User-Defined Function (UDF) Example

-- Problem: Create a function that calculates an employee's potential annual bonus,
--          which is 10% of their salary.

-- Step 1: Create the Scalar Function
-- (Note: MySQL functions always return a single scalar value.
-- If you need to return a table, you'd typically use a Stored Procedure.)

DELIMITER //

CREATE FUNCTION CalculateAnnualBonus (employee_salary DECIMAL(10, 2))
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
    RETURN employee_salary * 0.10; -- 10% of salary
END //

DELIMITER ;

-- Explanation for Scalar UDF Creation:
-- DELIMITER // ... DELIMITER ;: This changes the statement delimiter from ';' to '//'
--   so that MySQL treats the entire CREATE FUNCTION block as a single command.
-- CREATE FUNCTION CalculateAnnualBonus (employee_salary DECIMAL(10, 2)): Defines a function named 'CalculateAnnualBonus'
--   that takes one input, 'employee_salary', which is a DECIMAL number.
-- RETURNS DECIMAL(10, 2): Specifies that the function will return a DECIMAL number.
-- DETERMINISTIC: This keyword (or one of its alternatives like NO SQL) is required in MySQL.
--   It basically means the function will always return the same result for the same input values.
-- BEGIN ... END: Contains the actual code (logic) of the function.
-- RETURN employee_salary * 0.10;: The calculation to be performed and returned.

-- Step 2: Use the Scalar Function in a Query
-- Question: Display each employee's first name, salary, and their calculated annual bonus.
SELECT
    first_name,
    salary,
    CalculateAnnualBonus(salary) AS annual_bonus
FROM
    Employees;

-- Explanation for Scalar UDF Usage:
-- Once created, a Scalar UDF can be called just like a built-in function in your SELECT, WHERE, or other clauses.
-- It processes each row individually, returning one bonus value per employee based on their salary.

-- ---
-- 2. Table-Valued "Function" (Demonstrated with a Stored Procedure) Example

-- MySQL's CREATE FUNCTION statement is strictly for scalar-valued functions.
-- To return a result set (like a "table"), you typically use a STORED PROCEDURE.

-- Problem: Create a stored procedure that returns all employees for a given department name.

-- Step 1: Create the Stored Procedure
DELIMITER //

CREATE PROCEDURE GetEmployeesByDepartment (IN dept_name_param VARCHAR(100))
BEGIN
    SELECT
        e.employee_id,
        e.first_name,
        e.last_name,
        e.email,
        e.hire_date,
        e.salary,
        j.job_title,
        d.department_name
    FROM
        Employees e
    JOIN
        Departments d ON e.department_id = d.department_id
    JOIN
        Jobs j ON e.job_id = j.job_id
    WHERE
        d.department_name = dept_name_param;
END //

DELIMITER ;

-- Explanation for Stored Procedure Creation:
-- CREATE PROCEDURE GetEmployeesByDepartment (IN dept_name_param VARCHAR(100)): Defines a procedure named 'GetEmployeesByDepartment'
--   that takes one input parameter 'dept_name_param'. 'IN' means it's an input parameter.
-- BEGIN ... END: Contains the SQL statements that the procedure will execute.
-- SELECT ... WHERE d.department_name = dept_name_param: This is the query that generates the result set (the "table").

-- Step 2: Call the Stored Procedure
-- Question: Get all employees from the 'Engineering' department.
CALL GetEmployeesByDepartment('Engineering');

-- Question: Get all employees from the 'Sales' department.
CALL GetEmployeesByDepartment('Sales');

-- Explanation for Stored Procedure Usage:
-- You execute a stored procedure using the `CALL` statement, followed by the procedure name and any required parameters.
-- The procedure then runs its internal query and returns the results as a temporary table-like output.

-- ---
-- Other Considerations for User-Defined Functions (UDFs) and Stored Procedures:
-- - Reusability: Once created, both functions and procedures can be called multiple times by different queries or applications.
-- - Modularity: They help break down complex tasks into smaller, manageable, and named units.
-- - Performance: For complex logic, sometimes a well-designed UDF or procedure can be optimized by the database server.
-- - Security: You can grant specific users permission to execute functions/procedures without giving them direct access to the underlying tables.
-- - Limitations (for MySQL Functions vs. Procedures):
--   - MySQL `FUNCTIONS` must return a single scalar value. They cannot perform DML (INSERT, UPDATE, DELETE) or DDL (CREATE, DROP) operations. They can be used in SELECT, WHERE, HAVING, ORDER BY clauses.
--   - MySQL `PROCEDURES` can return result sets, perform DML/DDL operations, and can be much more complex. They are executed using `CALL`.
-- - Dropping (Deleting) Functions/Procedures:
--   - DROP FUNCTION IF EXISTS CalculateAnnualBonus;
--   - DROP PROCEDURE IF EXISTS GetEmployeesByDepartment;


-- Spatial functions

-- Spatial functions are used to work with geographical and geometric data.
-- They require specific spatial data types (like POINT, LINESTRING, POLYGON) in your tables.
-

  -- Other Spatial Analysis Functions and their purpose:
-- ST_GeomFromText(wkt_string, srid): Converts a text representation (Well-Known Text) of a geometry into a spatial object.
-- ST_AsText(geometry): Converts a spatial object back into its text representation.
-- ST_Intersects(g1, g2): Returns true if two geometries intersect (overlap or touch).
-- ST_Union(g1, g2): Returns a new geometry that is the spatial union of two geometries (combines them).
-- ST_Buffer(geometry, distance): Creates a buffer (area) around a geometry at a specified distance.
-- ST_Centroid(polygon): Returns the geometric center (centroid) of a polygon.
-- ST_Length(linestring): Returns the length of a LINESTRING geometry.
-- ST_Within(g1, g2): Returns true if the first geometry is spatially within the second geometry.
-- ST_Envelope(geometry): Returns the minimum bounding rectangle (MBR) for a geometry.




-- JSON Functions in CompanyDB (Conceptual Examples)

-- JSON functions are used to manipulate and query JSON (JavaScript Object Notation) data,
-- often stored in columns with the JSON data type.

-- ---
-- JSON Function Examples:

-- Example 1: JSON_EXTRACT() and Shorthand Operators (-> and ->>)
-- Question: From a JSON string representing employee preferences, extract specific details like favorite color or the first hobby.
-- (Let's imagine an 'employee_preferences' JSON column.);
SELECT
    JSON_EXTRACT('{"name": "Alice", "preferences": {"color": "Blue", "hobbies": ["reading", "hiking"]}}', '$.preferences.color') AS favorite_color_extract,
    '{"name": "Bob", "preferences": {"color": "Green", "hobbies": ["gaming", "coding"]}}' -> '$.preferences.hobbies[0]' AS first_hobby_shorthand,
    '{"product": "Laptop", "price": "1200.50"}' ->> '$.price' AS unquoted_price_shorthand;

-- Explanation for JSON_EXTRACT(): This function extracts a specific value from a JSON document using a path expression (like a path in a file system).
-- '$.key' means a top-level key. '$.parent.child' means a child key within a parent. '$.array[index]' accesses elements in a JSON array (0-indexed).
-- Explanation for -> (Shorthand for JSON_EXTRACT()): This operator is a shorter, more readable way to use JSON_EXTRACT().
-- Explanation for ->> (Shorthand for JSON_UNQUOTE(JSON_EXTRACT())): This operator not only extracts the value but also automatically removes any surrounding quotes if the value is a string, returning it as a plain string.

-- Example 2: JSON_OBJECT()
-- Question: Create a JSON object to store manager contact details.
SELECT
    JSON_OBJECT(
        'manager_id', 1,
        'name', 'John Doe',
        'contact_email', 'john.doe@company.com',
        'office', 'Headquarters'
    ) AS manager_json_object;

-- Explanation for JSON_OBJECT(): This function constructs a JSON object from a list of key-value pairs.
-- You provide the key and then its corresponding value, repeating for all pairs you want in the object.

-- Example 3: JSON_ARRAY()
-- Question: Create a JSON array of employee IDs or job titles.
SELECT
    JSON_ARRAY(
        (SELECT employee_id FROM Employees WHERE first_name = 'John'),
        (SELECT employee_id FROM Employees WHERE first_name = 'Jane'),
        (SELECT employee_id FROM Employees WHERE first_name = 'Robert')
    ) AS specific_employee_ids_array;

SELECT
    JSON_ARRAY('Software Engineer', 'Data Analyst', 'Project Manager') AS common_job_titles;

-- Explanation for JSON_ARRAY(): This function constructs a JSON array from a list of values.
-- You just list the values you want to include in the array.

-- Example 4: JSON_CONTAINS()
-- Question: Check if a JSON array of skills contains a specific skill, or if a JSON object contains a specific key-value pair.
SELECT
    JSON_CONTAINS('["Java", "Python", "SQL"]', '"Python"') AS has_python_skill,
    JSON_CONTAINS('{"role": "dev", "level": "senior"}', '{"level": "junior"}') AS is_junior_level;

-- Explanation for JSON_CONTAINS(): This function checks if a JSON document (or a path within it) contains a specific value.
-- It returns 1 (true) if the value is found, 0 (false) otherwise.

-- Example 5: JSON_INSERT(), JSON_REPLACE(), JSON_SET()
-- Question: Modify a JSON document by inserting a new field, replacing an existing one, or setting/updating one.
SELECT
    JSON_INSERT('{"name": "Alice", "age": 30}', '$.city', 'New York') AS json_after_insert,
    JSON_REPLACE('{"name": "Bob", "age": 25}', '$.age', 26) AS json_after_replace,
    JSON_SET('{"name": "Charlie", "country": "USA"}', '$.city', 'London', '$.country', 'UK') AS json_after_set;

-- Explanation for JSON_INSERT(): Inserts a value at a specified path. If the path already exists, the value is *not* inserted.
-- Explanation for JSON_REPLACE(): Replaces an existing value at a specified path. If the path does not exist, no operation is performed.
-- Explanation for JSON_SET(): Inserts or updates a value at a specified path. If the path exists, it updates; if not, it inserts. This is the most versatile for modification.

-- Example 6: JSON_UNQUOTE()
-- Question: Extract a string value from JSON and remove the surrounding quotes. (Often used with JSON_EXTRACT).
SELECT
    JSON_EXTRACT('{"city": "Paris"}', '$.city') AS quoted_city,
    JSON_UNQUOTE(JSON_EXTRACT('{"city": "Paris"}', '$.city')) AS unquoted_city;
    -- Note: '->>' operator is a shorthand for JSON_UNQUOTE(JSON_EXTRACT()).

-- Explanation for JSON_UNQUOTE(): This function removes the outer double quotes from a JSON string value.
-- This is useful when you've extracted a string that still has the JSON formatting quotes around it and you want the plain text.

-- ---
-- Other JSON Functions and their purpose:
-- JSON_ARRAY_APPEND(json_doc, path, val, ...): Appends a value to the end of an array at the given path.
-- JSON_ARRAY_INSERT(json_doc, path, val, ...): Inserts a value into an array at a specific position.
-- JSON_MERGE_PATCH(json_doc1, json_doc2): Merges JSON objects. Later keys win if there are conflicts.
-- JSON_MERGE_PRESERVE(json_doc1, json_doc2): Merges JSON objects/arrays. Preserves all values, turning scalars into arrays if necessary.
-- JSON_REMOVE(json_doc, path, ...): Removes elements from a JSON document at specified paths.
-- JSON_SEARCH(json_doc, one_or_all, search_str, [escape_char,] path,...): Searches for a string within a JSON document and returns the path(s) where it's found.
-- JSON_VALID(json_text): Returns 1 if the string is valid JSON, 0 otherwise.
-- JSON_DEPTH(json_doc): Returns the maximum depth of a JSON document.
-- JSON_LENGTH(json_doc, path): Returns the length of a JSON array or object.
-- JSON_TYPE(json_val): Returns the type of a JSON value (e.g., 'OBJECT', 'ARRAY', 'STRING', 'NUMBER').