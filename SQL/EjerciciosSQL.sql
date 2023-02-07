--:::::::::::::::::::::::::::::::::::::::::::::Ejercicios:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::--
/*
 Resolver las siguientes consultas SQL:
*/
--::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::--

--------------------------------------------- Ejercicio 1) ----------------------------------------------------------
/*
 Your boss wants to identify the successful projects running in your company, so he asked you to prepare a list of all the currently active 
 projects and their average monthly income.

 You have stored the information about these projects in a simple database with a single Projects table that has five columns:
      internal_id: the company's internal identifier for the project;
      project_name: the official name of the project;
      team_size: the number of employees working on the project;
      team_lead: the name of the project manager;
      income: the average monthly income of the project.

Your boss says that internal project ids are irrelevant to him and that he isn't interested in how big the teams are. Since that's the case, 
he wants you to create another table by removing the internal_id and team_size columns from the existing Projects table. Return it sorted by 
internal_id in ascending order.
*/
CREATE PROCEDURE solution()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
	SELECT project_name, team_lead, income
	FROM Projects
	ORDER BY internal_id ASC;
END

--------------------------------------------- Ejercicio 2) ----------------------------------------------------------
/*
Your friend wants to become a professional tour guide and travel all around the world. In pursuit of this dream, she enrolled in tour guide 
school. The professors in this school turned out to be very demanding, and one of them gave your friend a difficult assignment that she has to 
finish over the weekend.

Here's the assignment: Given a list of countries, your friend should identify all the countries that are in Africa. To help her, you have 
decided to write a function that will find all such countries from any set of countries. The countries table in which the countries are stored 
has the following structure:

      name: the name of the country;
      continent: the continent on which the country is situated;
      population: the country's population.

Your task is to return a new table that has the same columns, but that only contains the countries from Africa. The countries should be sorted 
alphabetically by their names.

*/

CREATE PROCEDURE solution()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
	SELECT name, continent, population
	FROM countries
	WHERE continent = 'Africa'
	ORDER BY name ASC;	
END

--------------------------------------------- Ejercicio 3) ----------------------------------------------------------
/*
Students at your university get scholarships that are paid out throughout the year.

Information about the scholarships is stored in the table scholarships, which has the structure:

	id: the unique student id;
	scholarship: the amount of the annual scholarship the student has been awarded.

Now you need to calculate the amount of money each student should get per month. Given the table scholarships, build the resulting table as 
follows: The table should have the same columns as the initial table, but the scholarship column should contain the amount of the student's 
monthly scholarship payout. The rows should be ordered by the students' ids.

*/

CREATE PROCEDURE solution()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
	SELECT id, scholarship/12
	FROM scholarships
	ORDER BY id;	
END

--------------------------------------------- Ejercicio 4) ----------------------------------------------------------
/*
Students at your university get scholarships that are paid out throughout the year.

Information about the scholarships is stored in the table scholarships, which has the structure:

	id: the unique student id;
	scholarship: the amount of the annual scholarship the student has been awarded.

Now you need to calculate the amount of money each student should get per month. Given the table scholarships, build the resulting table as 
follows: The table should have the same columns as the initial table, but the scholarship column should contain the amount of the student's 
monthly scholarship payout. The rows should be ordered by the students' ids.

*/

CREATE PROCEDURE solution()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
	SELECT DISTINCT name
	FROM projectLog
	ORDER BY name;
END

--------------------------------------------- Ejercicio 5) ----------------------------------------------------------
/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
The application you've been working on for the past year is a huge success! It already has a large and active user community. You know the ID 
number, username, and email of each user. Each user also has a specific role that shows their position in the community. Information about the
users is stored in the database as a table users, which has the following structure:
	
	id: the unique user ID;
	username: the username of the user;
	role the user's role;
	email: the user's email.

You want to send users automatic notifications to let them know about the most recent updates. However, not all users should get these 
notifications: Administrators don't need notifications since they know about the updates already, and premium users don't need them since they
get personalized weekly updates.

Given the users table, your task is to return the emails of all the users who should get notifications, i.e. those whose role is not equal to 
"admin" or "premium". Note that roles are case insensitive, so users with roles of "Admin", "pReMiUm", etc. should also be excluded.

The resulting table should contain a single email column and be sorted by emails in ascending order.
*/

CREATE PROCEDURE solution()
    SELECT email
    FROM users
    WHERE role NOT IN ("admin", "premium")

    ORDER BY email;

--------------------------------------------- Ejercicio 6) ----------------------------------------------------------
/*
You are creating a website that will help you and your friends keep track of the results of volleyball teams from all around the world. Your
website regularly crawls the web searching for new games, and adds the results of these games to the results table stored in your local database.
After each update, the table should be sorted in ascending order by the total number of games won. This year's results are quite marvelous - at
any given moment there are no two teams that have won the same number of games!

The results table contains the following columns:
	name - the unique name of the team;
	country - the country of the team;
	scored - the number of scored goals;
	missed - the number of missed goals;
	wins - the total number of games the team has won.

Your task is to sort the given results table in ascending order by the number of wins.
*/

CREATE PROCEDURE solution()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
	SELECT *
	FROM results
	ORDER BY wins;
END

--------------------------------------------- Ejercicio 7) ----------------------------------------------------------
/*
Mr. Cash wants to keep track of his expenses, so he has prepared a list of all the products he bought this month. Now he is interested in 
finding the product on which he spent the largest amount of money. If there are products that cost the same amount of money, he'd like to find
the one with the lexicographically smallest name.

The list of expenses is stored in a table Products which has the following columns:

	id: unique product id;
	name: the unique name of the product;
	price: the price for one item;
	quantity: the number of items bought.
The resulting table should contain one row with a single column: the product with the lexicographically smallest name on which Mr. Cash spent
the largest amount of money.

The total amount of money spent on a product is calculated as price * quantity.
*/

CREATE PROCEDURE solution()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
	SELECT name
	FROM Products
	WHERE price * quantity = (
		SELECT MAX(price * quantity)
		FROM Products)
	ORDER BY name
	LIMIT 1;
	
END

--------------------------------------------- Ejercicio 8) ----------------------------------------------------------
/*
You are working as a recruiter at a big IT company, and you're actively looking for candidates who take the top places in major programming
contests. Since the grand finale of the annual City Competition, you've been reaching out to the top participants from the leaderboard, and
successfully so.

You have already interviewed all the prize winners (the top 3 participants), but that's not enough right now. Your company needs more
specialists, so now you would like to connect with the participants who took the next 5 places.

The contest leaderboard is stored in a table leaderboard with the following columns:
	id: unique id of the participant;
	name: the name of the participant;
	score: the score the participant achieved in the competition.

The resulting table should contain the names of the participants who took the 4th to 8th places inclusive, sorted in descending order of their
places. If there are fewer than 8 participants, the results should contain those who ranked lower than 3rd place.

It is guaranteed that there are at least 3 prize winners in the leaderboard and that all participants have different scores.
*/

CREATE PROCEDURE solution()
BEGIN
	/* Write your SQL here. Terminate each statement with a semicolon. */
	SELECT name
	FROM leaderboard
	ORDER BY score DESC
	LIMIT 5 OFFSET 3;
END

--------------------------------------------- Ejercicio 9) ----------------------------------------------------------
/*
At the end of every semester your professor for "Introduction to Databases" saves the exam results of every student in a simple database
system. In the database table Grades, there are five columns:

Name: the name of the student;
ID: the student's ID number (a 5 byte positive integer);
Midterm1: the result of the first midterm out of 100 points;
Midterm2: the result of the second midterm out of 100 points;
Final: the result of the final exam, this time out of a possible 200 points.
According to school policy, there are three possible ways to evaluate a grade:

Option 1:
Midterm 1: 25% of the grade
Midterm 2: 25% of the grade
Final exam: 50% of the grade
Option 2:
Midterm 1: 50% of the grade
Midterm 2: 50% of the grade
Option 3:
Final exam: 100% of the grade.
Each student's final grade comes from the option that works the best for that student.

As a Teaching Assistant (TA), you need to query the name and id of all the students whose best grade comes from Option 3, sorted based on the
first 3 characters of their name. If the first 3 characters of two names are the same, then the student with the lower ID value comes first.
*/

CREATE PROCEDURE solution()
BEGIN
	select Name, ID from Grades
    where 2 * final > midterm1 + midterm2
    order by left(name, 3) asc, id asc;
END

--::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::--
--::::::::::::::::::::::::::::::::::::::::::::::::::FIN:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::--