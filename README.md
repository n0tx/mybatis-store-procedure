# Spring Boot MyBatis MySQL Store Procedure

![image](https://github.com/user-attachments/assets/db68a49f-2fa4-408d-9ef8-50495859f400)

- Java 17
- Maven
- Spring Starter Web
- MyBatis
- MySQL
- Lombok

## Cara Menjalankan Aplikasi

### Buat awal MySQL database dan tabel

- #### Membuat database

``` 
create database mybatis_store_procedure;
```

- #### Membuat tabel

``` 
use mybatis_store_procedure; 
create table Users ( id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(25), email VARCHAR(25) );
```

### Membuat MySQL Stored Procedure CRUD

- #### Stored Procedure untuk Create (Menambahkan Pengguna Baru)

```
DELIMITER //

CREATE PROCEDURE insertUser(IN p_username VARCHAR(50), IN p_email VARCHAR(50))
BEGIN
    INSERT INTO Users (username, email)
    VALUES (p_username, p_email);
END //

DELIMITER ;
```

- #### Stored Procedure untuk Read (Mengambil Daftar Pengguna)

```
DELIMITER //

CREATE PROCEDURE getAllUsers()
BEGIN
    SELECT id, username, email
    FROM Users;
END //

DELIMITER ;
```

- #### Stored Procedure untuk Read (Mengambil Data User berdasarkan ID)

```
DELIMITER //

CREATE PROCEDURE getUserById(IN p_id INT)
BEGIN
    SELECT id, username, email
    FROM Users
    WHERE id = p_id;
END //

DELIMITER ;
```

- #### Stored Procedure untuk Update (Memperbarui Data User)

```
DELIMITER //

CREATE PROCEDURE updateUser(IN p_id INT, IN p_username VARCHAR(50), IN p_email VARCHAR(50))
BEGIN
    UPDATE Users
    SET username = p_username, email = p_email
    WHERE id = p_id;
END //

DELIMITER ;
```

- #### Stored Procedure untuk Delete (Menghapus User berdasarkan ID)

```
DELIMITER //

CREATE PROCEDURE deleteUser(IN p_id INT)
BEGIN
    DELETE FROM Users
    WHERE id = p_id;
END //

DELIMITER ;
```

- #### Git clone

```
git clone https://github.com/n0tx/mybatis-store-procedure.git
```

- #### Run Spring Boot

```
$cd mybatis-store-procedure

$pwd
/mybatis-store-procedure

$./mvnw spring-boot:run
```

## Menguji Endpoint API Aplikasi

- #### List Users

GET http://localhost:8080/api/users

- #### Add User

POST http://localhost:8080/api/users

```
{
    "username": "riki",
    "email": "riki@mail.com"
}
```

- #### Update User

PUT http://localhost:8080/api/users/2

```
{
    "username": "riki - update",
    "email": "riki@mail.com"
}
```

- #### Find User

GET http://localhost:8080/api/users/2


- #### Delete User

DELETE http://localhost:8080/api/users/2
