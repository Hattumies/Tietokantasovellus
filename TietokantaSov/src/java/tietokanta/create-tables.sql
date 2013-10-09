
Create Table Players
(
Player varchar(30) PRIMARY KEY,
PlayerId varchar(30)
);

Create Table Characters
(
CharacterName varchar(30) PRIMARY KEY,
Player varchar(30) REFERENCES Players(Player),
Mental varchar(10),
Physical varchar(10),
Social varchar(10),
Template varchar(10),
MetanormalAdvantage int
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
CharacterName varchar(30) REFERENCES Characters(CharacterName)
);

Create Table Skills
(
Skillname varchar(30) PRIMARY KEY,
CharacterName varchar(30)REFERENCES Characters(CharacterName),
SkillValue int
);

Create Table Merits
(
MeritName varchar(30) PRIMARY KEY,
CharacterName varchar(30) REFERENCES Characters(CharacterName),
MeritValue int
);


