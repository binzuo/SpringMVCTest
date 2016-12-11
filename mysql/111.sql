DROP DATABASE IF EXISTS demo;
CREATE DATABASE demo;
DROP TABLE IF EXISTS demo.student;
CREATE TABLE demo.student(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  snumber VARBINARY(50),
  sname VARBINARY(20),
  sage INT(3),
  height DOUBLE(3,2)
);
#DESC demo.student;
INSERT INTO demo.student VALUE (NULL ,'001','贤二',22,1.78);
INSERT INTO demo.student VALUE (NULL ,'002','王小五',22,1.78);
INSERT INTO demo.student VALUE (NULL ,'003','李四',22,1.78);
SELECT *FROM demo.student;