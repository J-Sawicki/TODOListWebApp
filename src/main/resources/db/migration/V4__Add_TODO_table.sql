create table TODO (
      id int unsigned primary key auto_increment,
      text varchar(200) not null,
      done boolean
  );