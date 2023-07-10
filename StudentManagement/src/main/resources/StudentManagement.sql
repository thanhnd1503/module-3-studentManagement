create database if not exists `studentmanagement`;
use `studentmanagement`;

create table if not exists Student(
	`id`			int auto_increment primary key,
    `name`			varchar(100) not null,
    `DOB`			date not null,
    `address`		varchar(250) not null,
    `phone`			varchar(10) not null unique,
    `email`			varchar(100) not null unique check(`email` LIKE '%_@_%.__%'),
    `idClassroom`	int not null,
    `isStatus`		bit not null
);

create table if not exists Classroom(
	`id`	int primary key,
	`name`	varchar(25) not null unique
);

ALTER TABLE Student ADD CONSTRAINT FK_Student_Classroom FOREIGN KEY(`idClassroom`) REFERENCES Classroom(`id`);

INSERT INTO CLASSROOM(`id`, `name`) VALUES
(1, 'Class A'),
(2, 'Class B'),
(3, 'Class C');

INSERT INTO STUDENT(`name`, `DOB`, `address`, `phone`, `email`, `idClassroom`, `isStatus`) VALUES
('John Doe', '1999-01-15', '123 Main St, Anytown, USA', '1234567890', 'johndoe@example.com', 1, 1),
('Jane Smith', '2000-03-22', '456 Maple Ave, Somewhere, USA', '2345678901', 'janesmith@example.com', 1, 1),
('Bob Johnson', '1998-05-10', '789 Oak Rd, Nowhere, USA', '3456789012', 'bobjohnson@example.com', 2, 1),
('Mary Davis', '2001-07-07', '321 Elm St, Anytown, USA', '4567890123', 'marydavis@example.com', 2, 1),
('Tom Brown', '1999-09-02', '654 Pine Ave, Somewhere, USA', '5678901234', 'tombrown@example.com', 3, 1),
('Sue Lee', '2000-11-19', '987 Cedar Blvd, Nowhere, USA', '6789012345', 'suelee@example.com', 3, 1),
('Mike Wilson', '1997-02-28', '246 Walnut St, Anytown, USA', '7890123456', 'mikewilson@example.com', 3, 1),
('Karen Kim', '1998-04-11', '369 Birch Dr, Somewhere, USA', '8901234567', 'karenkim@example.com', 3, 1),
('Chris Miller', '2001-06-06', '582 Spruce Ln, Nowhere, USA', '9012345678', 'chrismiller@example.com', 2, 1),
('Lisa Chen', '1999-08-23', '795 Cedar Rd, Anytown, USA', '0123456789', 'lisachen@example.com', 1, 1);

