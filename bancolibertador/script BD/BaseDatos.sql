IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'db_banlibertador')
BEGIN
    CREATE DATABASE db_banlibertador;
END;

USE db_banlibertador;


IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'persona')
BEGIN
create table persona
(
    id             int identity (100, 1) constraint PERSONA_PK PRIMARY KEY,
    nombre         varchar(255),
    genero         varchar(10),
    edad           int,
    fecha_reg      datetime default getdate(),
    direccion      varchar(255),
    telefono       varchar(30),
    identificacion varchar(15)
)
END;

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'cliente')
BEGIN
CREATE TABLE cliente
(
    cliente_id int identity (100, 1)
        constraint TB_CLIENTE_PK PRIMARY KEY,
    persona_id int
        constraint CLIENTE_PERSONA_PERSONA_ID_FK references persona(id),
    estado   int default 1,
    fecha_reg  datetime default getdate(),
    contrasena varchar(50) not null
)
END;

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'cuenta')
BEGIN
CREATE TABLE cuenta (
    id int identity (100, 1) constraint T_CUENTA_PK primary key,
    cliente_id int constraint CUENTA_CLIENTE_CLIENTE_ID  references cliente(cliente_id),
    tipo_cuenta   varchar(50),
    saldo_inicial money default 0,
    fecha_reg  datetime default getdate(),
    numero_cuenta varchar(20) not null
        constraint U_CUENTA_PK  unique,
    estado bit   default 1
    );
END;



IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND  TABLE_NAME = 'movimiento')
BEGIN
CREATE TABLE movimiento (
    id int identity (100, 1) constraint MOVIMIENTO_PK primary key,
    fecha           datetime,
    tipo_movimiento varchar(20),
    fecha_reg  datetime default getdate(),
    valor           money,
    saldo           money,
    id_cuenta       int
        constraint MOVIMIENTO_CUENTA_CUENTA_ID_FK references cuenta(id)
    );
END;