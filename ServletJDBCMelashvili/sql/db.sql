CREATE DATABASE uni;

CREATE TABLE students(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);

SELECT * FROM students;