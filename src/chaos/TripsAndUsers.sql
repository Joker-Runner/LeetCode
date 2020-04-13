
# 262. Trips and Users

select Request_at as Day, round(sum(case Status when 'completed' then 0 else 1 end)/count(*), 2) as 'Cancellation Rate'
from trips
where Request_at >= '2013-10-01' and Request_at <= '2013-10-03'
  and trips.Client_Id in (select Users_Id from users where banned = 'No')
  and trips.Driver_Id in (select Users_Id from users where banned = 'No')
group by Request_at



-- 创建行程表
CREATE TABLE `trips` (
                         `Id` int(11) NOT NULL,
                         `Client_Id` int(11) DEFAULT NULL,
                         `Driver_Id` int(11) DEFAULT NULL,
                         `City_Id` int(11) DEFAULT NULL,
                         `Status` varchar(45) DEFAULT NULL,
                         `Request_at` datetime DEFAULT NULL,
                         PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


# 创建用户表
CREATE TABLE `users` (
                         `Users_Id` int(11) NOT NULL,
                         `Banned` varchar(45) DEFAULT NULL,
                         `Role` varchar(45) DEFAULT NULL,
                         PRIMARY KEY (`Users_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci