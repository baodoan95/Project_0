Hello Everyone,

My name is Bao Doan and this is my first project working at Revature on making a hangman game that can manipulate data from database.  Programming language used for this project is scala and mySQL.  Database is hosted at local port 3306.  

Database structure:
TABLES: players, scores, words

players table columns:
- player_id : INT, primary key
- nickname : varchar(255)

scores table columns:
- player_id: INT, foreign key, cascade on delete
- score INT

words table columns:
- word: varchar(255)
- times_played: INT

:D 