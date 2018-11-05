create table milk_purchase (
  id int auto_increment primary key,
  user_id int NOT NULL,
  quantity int NOT NULL,
  buy_date date NOT NULL
);