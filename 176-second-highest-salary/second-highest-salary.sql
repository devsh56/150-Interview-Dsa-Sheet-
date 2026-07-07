# Write your MySQL query statement below
 select (select Distinct Salary from Employee Order by salary desc limit 1 offset 1 ) as SecondHighestSalary


#SELECT MAX(Salary) AS SecondHighestSalary
#FROM Employee
#WHERE Salary < (
#    SELECT MAX(Salary)
#    FROM Employee
#);