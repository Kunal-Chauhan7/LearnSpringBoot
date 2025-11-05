CREATE DATABASE IF NOT EXISTS employee_directory;
use employee_directory;
--
-- comment is like this
--

DROP TABLE IF EXISTS employee;

CREATE TABLE employee(
	id int NOT NULL auto_increment,
    first_name varchar(45) not null,
    last_name varchar(45) default null,
    email varchar(45) default null,
    PRIMARY KEY(id)
) engine=InnoDB auto_increment=1 default charset = latin1;



-- adding random data
-- for the employee table

INSERT INTO employee (first_name, last_name, email) VALUES
('Alice', 'Johnson', 'alice.johnson@example.com'),
('Bob', 'Smith', 'bob.smith@example.com'),
('Charlie', 'Lee', 'charlie.lee@example.com'),
('Diana', 'Martinez', 'diana.martinez@example.com'),
('Ethan', 'Brown', 'ethan.brown@example.com'),
('Jotaro','Kujo','Kujo.jotrao@gmail.com'),
('Joseph ','Jostar','joseph.jostar@gmail.com');