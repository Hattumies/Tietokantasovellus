
Create Table Players
(
Player varchar(30) PRIMARY KEY,
PlayerId varchar(30)
);

Create Table Attributes
(
CharacterName varchar(30) PRIMARY KEY,
Mental varchar(10),
Physical varchar(10),
Social varchar(10)
);

Create Table Items
(
ItemName varchar(30) PRIMARY KEY,
CharacterName varchar(30)
);

Create Table Skills
(
Skillname varchar(30) PRIMARY KEY,
CharacterName varchar(30),
SkillValue int
);

Create Table Merits
(
MeritName varchar(30) PRIMARY KEY,
CharacterName varchar(30),
MeritValue int
);
Create Table Characters
(
CharacterName varchar(30) PRIMARY KEY,
Player varchar(30),
Mental varchar(10),
Physical varchar(10),
Social varchar(10),
Template varchar(10),
MetanormalAdvantage int
);

