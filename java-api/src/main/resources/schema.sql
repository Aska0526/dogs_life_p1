DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS owners;

CREATE TABLE owners
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL
);



CREATE TABLE dogs
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age int NOT NULL check(age > 0),
    owner_id int not NULL,
    FOREIGN key (owner_id) REFERENCES owners (id)
);
