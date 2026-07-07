# Write your MySQL query statement below
 #select Distinct Salary as SecondHighestSalary from Employee Order by salary desc limit 1 offset 1


SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (
    SELECT MAX(Salary)
    FROM Employee
);