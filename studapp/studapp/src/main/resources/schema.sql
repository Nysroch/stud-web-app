DROP TABLE IF EXISTS student_course;

DROP TABLE IF EXISTS user_authority;

DROP TABLE IF EXISTS students;

DROP TABLE IF EXISTS courses;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS authority;



CREATE TABLE students(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    jmbag VARCHAR (10) NOT NULL,
    dateofbirth DATE NOT NULL,
    ects INT DEFAULT 0


);

CREATE TABLE courses(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    ects INT NOT NULL

);


CREATE TABLE student_course(
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    constraint fk_student foreign key (student_id) references students(id),
    constraint fk_course foreign key (course_id) references courses(id)
);


CREATE TABLE users(
    id IDENTITY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(250) NOT NULL,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL
);

CREATE TABLE authority(
    id IDENTITY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE user_authority(
    user_id INT NOT NULL,
    authority_id INT NOT NULL,
    constraint fk_user foreign key (user_id) references users(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
);
