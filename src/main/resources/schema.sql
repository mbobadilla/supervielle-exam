 CREATE TABLE person(
  documenttype CHAR(8) NOT NULL,
  documentnumber CHAR(15) NOT NULL,
  country char(50) NOT NULL,
  genre char(1) NOT NULL,
  PRIMARY KEY(documenttype,documentnumber,country,genre)
 );

 CREATE TABLE typedocument(
 id int NOT NULL,
 type char(8) NOT NULL,
 PRIMARY KEY(id)
 );

  CREATE TABLE country_iso_3166_1(
  code char(3) NOT NULL,
  name char(3) NOT NULL,
  PRIMARY KEY(code)
  );