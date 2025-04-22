CREATE database umb_java;
use umb_java;
create table db_clientes(
ID int AUTO_INCREMENT PRIMARY KEY,
TipoID varchar(45),
Nombre VARCHAR(45),
Apellido VARCHAR(45),
Usuario VARCHAR(45),
password VARCHAR(45),
NroCelular BIGINT,
email VARCHAR(45)
);

INSERT INTO db_clientes (TipoID,Nombre,Apellido,Usuario,password,NroCelular,email) values(
'cCiudadania',
'Juan',
'Hernandes',
'JuHerna',
'dfasdfsdfsd',
3012346542,
'junarnandez@gmail.com'
);