# metadata-direction-service
Microservice getting metadata from SqlLite DB for recommendation; Sky Hackathon 2023


-- CREATE USER 'dhruva'@'localhost' IDENTIFIED WITH mysql_native_password BY 'booksmart';
-- SET PASSWORD FOR 'dhruva'@'localhost'=PASSWORD('booksmart');
-- FLUSH PRIVILEGES;


ALTER USER 'dhruva'@'127.0.0.1' IDENTIFIED WITH mysql_native_password BY 'booksmart';


-- UPDATE mysql.user SET Password = PASSWORD('booksmart') WHERE (User, Host) = ('dhruva', 'localhost');
FLUSH PRIVILEGES;