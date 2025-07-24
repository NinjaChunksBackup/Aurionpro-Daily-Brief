show databases;

USE student_join_db;

show tables;

#Example 1: Log new students automatically

CREATE TABLE student_log (
  log_id INT AUTO_INCREMENT PRIMARY KEY,
  student_id INT,
  full_name VARCHAR(100),
  log_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

describe student_log;

DELIMITER $$

CREATE TRIGGER after_student_insert
AFTER INSERT ON students
FOR EACH ROW
BEGIN
  INSERT INTO student_log (student_id, full_name)
  VALUES (NEW.student_id, CONCAT(NEW.first_name, ' ', NEW.last_name));
END$$

DELIMITER ;

INSERT INTO students (first_name, last_name, email)
VALUES ('Priya', 'Mehra', 'priya@example.com');

SELECT * FROM student_log;

#Example 2: Log course title updates


CREATE TABLE course_update_log (
  course_id INT,
  old_title VARCHAR(100),
  new_title VARCHAR(100),
  changed_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER $$

CREATE TRIGGER after_course_update
AFTER UPDATE ON courses
FOR EACH ROW
BEGIN
  IF OLD.title != NEW.title THEN
    INSERT INTO course_update_log (course_id, old_title, new_title)
    VALUES (OLD.course_id, OLD.title, NEW.title);
  END IF;
END$$

DELIMITER ;


UPDATE courses
SET title = 'Advanced Algorithms'
WHERE course_id = 2;

SELECT * FROM course_update_log;

#When a student is deleted, save their name in a deleted_students table.

CREATE TABLE IF NOT EXISTS deleted_students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  student_id INT,
  full_name VARCHAR(100),
  deleted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


DELIMITER $$

CREATE TRIGGER after_student_delete
AFTER DELETE ON students
FOR EACH ROW
BEGIN
  INSERT INTO deleted_students (student_id, full_name)
  VALUES (OLD.student_id, CONCAT(OLD.first_name, ' ', OLD.last_name));
END$$

DELIMITER ;


INSERT INTO students (first_name, last_name, email)
VALUES ('Asha', 'Verma', 'asha@example.com');

SELECT * FROM students WHERE first_name = 'Asha';

DELETE FROM students WHERE student_id = 14;


SELECT * FROM deleted_students;






