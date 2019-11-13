CREATE USER 'cvuser'@'localhost' IDENTIFIED BY 'cvpassword';
GRANT ALL PRIVILEGES ON * . * TO 'cvuser'@'localhost';
CREATE USER 'cvuser'@'%' IDENTIFIED BY 'cvpassword';
GRANT ALL PRIVILEGES ON * . * TO 'cvuser'@'%';

## For MySQL version>=8.0.4
ALTER USER 'cvuser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'cvpassword';
ALTER USER 'cvuser'@'%' IDENTIFIED WITH mysql_native_password BY 'cvpassword';