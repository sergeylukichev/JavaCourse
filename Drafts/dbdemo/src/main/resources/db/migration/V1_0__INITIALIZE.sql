
CREATE TABLE Course (
  course_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  description VARCHAR(45) NOT NULL,
  PRIMARY KEY  (course_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Student (
  student_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  course_id SMALLINT UNSIGNED,
  PRIMARY KEY  (student_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO Student (student_id, first_name, last_name, course_id)
VALUES (1,'Sergey','Lukichev',1),
       (2,'Ivan','Petrov',2),
       (3,'Anna','Ivanova',1),
       (4,'Alla','Petrova',3),
       (5,'Dmitri','Sokolov',3),
       (6,'Oleg','Smirnov', NULL),
       (7,'Olga','Ivanova', NULL);

INSERT INTO Course (course_id, title, description)
VALUES (1, 'Java', 'Java Basics Programming'),
       (2, 'QA', 'Quality Assurance and Testing'),
       (3, 'Angular', 'JavaScript Framework'),
       (4, 'DevOps', 'Developer Operations');