INSERT INTO students(first_name, last_name, jmbag, ects, dateofbirth) VALUES
    ('Marko', 'Obrvan', '0321586491', '111', '1998-02-08'),
    ('Ivan', 'Zelentrovic', '0226482951', '153', '1998-09-06'),
    ('Mihael', 'Barisic', '0226482952', '45', '1990-03-16');

INSERT INTO courses(name, ects) VALUES
    ('Web Aplikacije u Javi', '7'),
    ('Administracija Racunalnih Mreza', '6');

INSERT INTO student_course(student_id, course_id) VALUES
    ('1', '1'),
    ('1', '2'),
    ('2', '2'),
    ('3', '1');


INSERT INTO users(id, username, password, first_name, last_name) VALUES
    (1, 'admin', '$2y$10$w6MOORiPctzaujLy6amFiu7LRw3Fe12kdiPsGBr5YYRBtXfULX5sG', 'admin', 'admin'),
    (2, 'user', '$2y$10$w6MOORiPctzaujLy6amFiu7LRw3Fe12kdiPsGBr5YYRBtXfULX5sG', 'user', 'user'),
    (3, 'updater', '$2y$10$w6MOORiPctzaujLy6amFiu7LRw3Fe12kdiPsGBr5YYRBtXfULX5sG', 'updater', 'updater');

INSERT INTO authority(id, name) VALUES
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER'),
    (3, 'ROLE_UPDATER');

INSERT INTO user_authority(user_id, authority_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3);



