-- -------------------------------------------------------------------------
-- Worksheet 4. QUESTIONS
-- Write your answers next to each comment.
-- -------------------------------------------------------------------------

/* 1. Display the list of journalists who have NOT published any article in 
the newspaper with Id 4.
Schema: (Journalist_Id, Journalist_Name).*/

SELECT j.idJournalist, j.name FROM journalist 
JOIN article a ON a.idJournalist = j.idJournalist
WHERE a.IDNEWSPAPER = 4;


/* 2. Display the list  of journalists who have NOT published any article in 
the newspaper 'The Gazette'. The result must only include journalists that have
published at least one article.
Schema: (Journalist_Id, Journalist_Name).*/



/* 3. Display the list of the newspapers that in 2018 received more
visits than 'The Gazette'.
Schema: (Newspaper_Name, Num_Visits)  */



/* 4. Display the headlines of articles written by authors that in 2019 DID
NOT write ANY article in English.
Schema: (Article_Id, Article_Headline, Journalist_Name)
*/



/* 5. Display the headlines of the articles written by journalists
that in 2018 wrote for newspapers in English ONLY.
Schema: (Article_Id, Headline, PubDate, Journalist_Name)
*/


  
/* 6. Display the most visited articles in each newspaper.  
Schema: (Newspaper_Id, Article_Id, Headline, Num_visits) */



/* 7. Name of the authors that have published articles in ALL newspapers in 
English.
Schema: (Journalist_Id, Journalist_Name)*/



/* 8. Show the name and number of visits of the most famous
journalist(s) (the journalist(s) whose articles have the greatest number of 
visits in total).
Schema: (Journalist_Id, Journalist_Name, TotalVistits) */



/* 9. List the years in which ALL newspapers in English have published at least one
article, the total number of articles published on each year and total
number of visits received by those newspapers.
(Hints: (a) you can use GROUP BY clauses with expressions, as for example 
function calls;
(b) you can check the universal condition (the "ALL") by checking that the number
of newspapers in English that have published articles in some year is equal to the 
total number of newspapers in English.)
Schema: (Year, Num_Articles, Num_Visits)*/



/* 10. For each Journalist, obtain the difference between the total number of visits 
received by their articles and the average of the number of visits per journalist.
(Hard! this query requires querying two different sets of rows from table 
article: on one hand, the rows grouped by journalist, in order to compute
the sum of visits for each journalist; on the other hand, all rows from all 
journalists in order to compute the average total number of visits for all 
journalists. Then you can compute the difference. This requires two queries.

Hint1: You can think about having a subquery in the SELECT clause
obtaining the average number of visits received by all journalists,
which result is subtracted from the total number of visits per
journalist.

Hint2: Alternatively, think about having subqueries in the FROM
clause, one for obtaining the total number of visits for each
journalist, and another one for obtaining the average number of visits
received by all journalists. Both queries should be joined using a
cartesian product.  Finally, the subtraction of these two numbers can
be performed.)
Schema: (Journalist_Id, Journalist_Name, Deviation)*/



/* 11. Display the articles that received more visits than the average of the visits
of the newspaper where they were published.
(Hint: try it with a correlated subquery that computes the average number
of visits for each newspaper)
Schema: (Newspaper_Id, Article_Id, Headline, Num_visits) */



/* 12. Display the articles that received more visits than the average visits
of the newspaper where they were published.
Schema: (Newspaper_Id, Article_Id, Headline, Num_visits, Avg_visits_Newspaper) 
(Hard, because the avg number of visits of the newspaper must be included in the 
result. You can use a subquery in the FROM clause that obtains the newspaper id 
and the average number of visits for each newspaper, and join it with the 
articles to check that the number of visits is greater than the average.)
*/

