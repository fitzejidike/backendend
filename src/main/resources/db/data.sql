truncate table users cascade;
truncate table user_role cascade;

insert into users(id,time_created, time_updated, email, first_name, last_name, password, username) values
 (2, '2024-07-01 10:00:00', '2024-07-01 10:00:00','john.doe@example.com','John', 'Doe', '$2a$10$pbQSD9N4.6wN7Ofav9sdqueWvcRrn647WKwV5xPzeGAR1iAD55QbK', 'johndoe'),
 (4,'2024-07-25 20:21:41', '2024-07-25 20:21:41', 'janesmith@example.com','Jane', 'Smith','$2a$10$dmJuzTrm44F.1NmOBYbT9ujHtX/BtFolUzJHb3QgRLak23frtx0Ty', 'janesmith');

insert into user_role(user_id,role)values
                                     (2, 'ADMIN'),
                                     (4, 'ADMIN');

