CREATE TABLE Actors (
	Name VARCHAR(40),
	Movie VARCHAR(80),
	Year INTEGER,
	Role VARCHAR(40)
);

LOAD DATA LOCAL INFILE "~/data/actors.csv" INTO TABLE Actors 
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' LINES TERMINATED BY '\n'
(Name, Movie, Year, Role);

SELECT 
	A.Name 
FROM
	Actors A
WHERE
	A.Movie="Die Another Day";

DROP TABLE Actors;