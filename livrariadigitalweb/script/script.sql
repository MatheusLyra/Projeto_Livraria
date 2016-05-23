CREATE DATABASE LIVRARIA;
USE LIVRARIA;
CREATE TABLE LIVROS
(ID INTEGER NOT NULL PRIMARY KEY auto_increment
,TITULO VARCHAR(45)
,AUTOR VARCHAR(45)
,EDITORA VARCHAR(45)
,EMAIL VARCHAR(45)
,DATALANCAMENTO DATE);

INSERT INTO LIVROS VALUES(0,'A Grande Sacada','André Cavalcanti de Oliveira','Ediouro','email@example.com','1999-01-01');
INSERT INTO LIVROS VALUES(2,'Aprendendo .NET','José Orlando dos Santos','Rocco','email@subdomain.example.com','2012-01-01');
INSERT INTO LIVROS VALUES(3,'Aprendendo SQL','Fabiano da Costa','Selo Antigo','firstname+lastname@example.com','2013-01-01');
INSERT INTO LIVROS VALUES(4,'Aprendendo PYTHON','Bruno da Costa','Selo Jovem','1234567890@example.com','2014-01-01');
INSERT INTO LIVROS VALUES(5,'RUBY Aprendendo','Pedro da Costa','Sextante','email@example-one.com','2015-01-01');
INSERT INTO LIVROS VALUES(6,'PHP Aprendendo','Paulo da Costa','Marca Juvenil','email@example.name','2016-01-01');
INSERT INTO LIVROS VALUES(7,'JAVASCRIPT Aprendendo','Rafael da Costa','Selo Novo','email@example.museum','2000-01-01');
INSERT INTO LIVROS VALUES(8,'Aprendendo C','Carlos da Costa','Selo Velho','email@example.co.jp','2010-01-01');
INSERT INTO LIVROS VALUES(9,'HTML5 Aprendendo','Thiago da Costa','Editora Globo','firstname-lastname@example.com','2001-01-01');
INSERT INTO LIVROS VALUES(10,'CSS3 Aprendendo','Cristiano da Costa','Selo Vanguardista','TEST___@example.com','2002-01-01');
INSERT INTO LIVROS VALUES(11,'Aprendendo JAVA','André Cavalcanti de Oliveira','Abril','firstname.lastname@example.com','1999-01-01');

select * from livros;