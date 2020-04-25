create table Employee
(
    Id     integer primary key,
    Salary decimal
);

select salary
from (select distinct Salary from Employee union all select null as Salary) t
order by Salary desc
limit 1,1;