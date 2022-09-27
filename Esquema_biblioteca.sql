create database biblioteca;

create table titulo(isbn bigint not null primary key, titulo varchar(45) not null, autor varchar(45) not null,
editorial varchar(30) not null, genero varchar(30) not null, fecha_lanzamiento date, descripcion varchar(200),
img varchar(45));

create table usuario(idUsuario int not null primary key auto_increment, nombre varchar(20) not null, 
apellido_paterno varchar(20) not null, apellido_materno varchar(20) not null, direccion varchar(45) not null,
telefono varchar(12), username varchar(20) not null, contrasena varchar(20) not null);

create table prestamo(idPrestamo int primary key not null auto_increment, fecha_prestamo date not null, 
fecha_entrega date not null, idUsuario int not null, isbn bigint not null);