CREATE DATABASE db_yeahbuddy;

CREATE TABLE usuarios (id int NOT NULL AUTO_INCREMENT, email varchar(255) not null, cpf varchar(255) not null, telefone varchar(255) not null, primary key (id), foreign key (id);

CREATE TABLE endereco (id int NOT NULL AUTO_INCREMENT, rua varchar(255) not null, bairro varchar(255) not null, numero varchar(255) not null, primary key (id);

CREATE TABLE treinos (id int NOT NULL AUTO_INCREMENT, nome varchar(255) not null, dia varchar(255) not null, primary key (id);