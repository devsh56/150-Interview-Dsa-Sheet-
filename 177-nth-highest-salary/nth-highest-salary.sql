CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
Set N = N-1;
  RETURN (
    
    select Distinct Salary from Employee Order by Salary Desc limit 1 offset N
      # Write your MySQL query statement below.

  );
END