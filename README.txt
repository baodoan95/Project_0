Hello Guys,

My name is Bao Doan and this is my first project working at Revature on making a hangman game that can perform CRUD operations on database.  Programming language used to build this project is scala and mySQL is used to communicate with database with the help of java connector library dependency. 

Structure of database:
3 TABLES: players, scores, words

players table:
- player_id : INT, primary key
- nickname : varchar(255)

scores table:
- player_id: INT, foreign key, cascade on delete
- score INT

words table:
- word: varchar(255)
- times_played: INT
