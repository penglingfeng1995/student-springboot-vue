create table t_account(
  userId bigint primary key auto_increment,
  username varchar(255) not null ,
  password varchar(255) not null
)default charset utf8mb4;