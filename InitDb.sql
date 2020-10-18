--初始化数据库
DROP TABLE IF EXISTS student;

CREATE TABLE student
(
	sno         INT             auto_increment,
	name        VARCHAR(200)    NULL,
	age         INT             NULL,
    PRIMARY KEY(sno)
) CHARACTER SET = utf8;

INSERT INTO student(sno, name, age) VALUES (108, 'Ant', 11);
INSERT INTO student(sno, name, age) VALUES (109, 'Ben', 12);
INSERT INTO student(sno, name, age) VALUES (110, 'Cat', 13);
INSERT INTO student(sno, name, age) VALUES (111, 'Dog', 14);
INSERT INTO student(sno, name, age) VALUES (112, 'Egg', 15);
INSERT INTO student(sno, name, age) VALUES (113, 'Fox', 16);
INSERT INTO student(sno, name, age) VALUES (114, 'Git', 17);
INSERT INTO student(sno, name, age) VALUES (115, 'Hop', 18);