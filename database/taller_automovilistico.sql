﻿create table areas(--S
	id serial not null primary key,
	name varchar(50) not null unique
);
create table tipo_vehiculo(--S
	id serial not null primary key,
	name varchar(50) not null unique
);
create table marca_vehiculo(--S
	id serial not null primary key,
	name varchar(50) not null unique
);
create table modelo_vehiculo(
	id serial not null primary key,
	id_marca_vehiculo int not null constraint fk_modelo_marca references marca_vehiculo(id),
	id_tipo_vehiculo int not null constraint fk_modelo_tipo references tipo_vehiculo(id),
	name varchar(50) not null
);
create table clientes(--S
	id serial not null primary key,
	name varchar(150) not null,
	telefono varchar(25) not null,
	address varchar(800),
	email varchar(100)
);
create table colors(--S
	id serial not null primary key,
	name varchar(50) not null unique
);
create table combustibles(--S
	id serial not null primary key,
	name varchar(50) not null unique
);
create table vehiculos(
	chapa varchar(10) not null primary key,
	id_modelo int not null constraint fk_veh_modelo references modelo_vehiculo(id),
	year  int not null,
	color int not null constraint fk_vehiculo_modelo references colors(id),
	id_combustible int not null constraint fk_vehiculo_combustible references combustibles(id),
	id_cliente int not null constraint fk_vehiculo_cliente references  clientes(id),
	maintenance boolean not null default false
);
create table suplidores(--S
	id serial not null primary key,
	name varchar(100) not null,
	telefono varchar(50) not null,
	direccion varchar(800)
);
create table articulos(
	id serial not null primary key,
	id_suplidor int not null constraint fk_articulo_suplidor references suplidores(id),
	id_area int not null constraint fk_articulo_area references areas(id),
	name varchar(50) not null,
	cost numeric(9,2) not null,
	existencia int default 0,
	punto_reorden int not null

);
create table servicios(
	id serial not null primary key,
	name varchar(150) not null,
	id_area int not null constraint fk_servicio_area references areas(id),
	descripcion varchar(800) not null,
	cost numeric(9,2) not null
);
create table estado_orden(--S
	id int not null primary key,
	name varchar(50) not null,
	descripcion varchar(150) not null
);
create table ordenes(
	id serial not null primary key,
	id_servicio int not null constraint fk_orden_servicio references servicios(id),
	id_vehiculo varchar(10) not null constraint fk_orden_vehiculo references vehiculos(chapa),
	entry_date date not null,
	departure_date date,
	id_estado_orden int not null constraint ordenes_estado references estado_orden(id)
);
create table articulos_utilizados(
	id_orden int not null constraint fk_artU_orden references ordenes(id),
	id_articulo int not null constraint fk_artU_art references articulos(id),
	cant int not null,
	constraint pk_articulos_utilizados primary key(id_orden,id_articulo)
);
create table empleados(
	cedula varchar(11) not null primary key,
	name varchar(300) not null,
	lastname varchar(500) not null,
	id_area int not null constraint fk_empleado_area references areas(id),
	sueldo numeric(7,1) not null,
	address varchar(800) not null,
	phone varchar(25) not null,
	entry_date date not null,
	status int not null
);
create table tipo_usuario(
	id serial not null primary key,
	tipo varchar(50)  not null
);
create table usuarios(
	id varchar(11) not null constraint fk_usuario_empleado references empleados(cedula) primary key,
	usuario varchar(50) not null,
	pass varchar(50) not null,
	id_tipo int not null constraint fk_usuario_tipo references tipo_usuario(id)
);
create table tipo_trans(--S
	id serial not null primary key,
	name varchar(100) not null unique
);
create table trans(
	id serial not null primary key,
	id_tipo_trans int not null constraint fk_tran_tipo references tipo_trans(id),
	id_area int not null constraint fk_tran_area references areas(id),
	fecha timestamp default current_timestamp,
	cantidad int not null,
	valor numeric(7,2) not null,
	total numeric(9,2) not null,
	ref_tran varchar(25) not null,
	id_resource varchar(25)
);
create table cajas(
	id serial not null primary key,
	id_empleado varchar(11) not null constraint fk_caja_empleado references empleados(cedula),
	fondo int not null
);
--INSERTIONS
INSERT INTO public.tipo_usuario(tipo)
	VALUES ('ADMINISTRADOR'),('CAJERO'),('TECNICO'),('VENDEDOR');

INSERT INTO public.areas(name)
    VALUES ('PINTURA'),('MECANICA GENERAL'),('DESABOLLADURA'),('TIENDA');

INSERT INTO public.colors(name)
    VALUES ('ROJO'),('BLANCO'),('AMARILLO'),
('VERDE'),('NARANJA'),('ROJO VINO'),
('AZUL'),('DORADO');

INSERT INTO public.combustibles(name)
    VALUES ('GASOLINA'),('GAS NATURAL'),('GASOIL'),('DIESEL');

INSERT INTO public.marca_vehiculo(name)
    VALUES ('TOYOTA'),('MAZDA'),('PEGEOT'),('PONTIAC'),
    ('FERRARI'),('JEEP'),('MERCEDEZ BENZ'),('BMW'),('LEXUS'),('SKODA');

INSERT INTO public.tipo_vehiculo(name)
    VALUES ('SEDAN'),('COMPACTO'),('JEEPETA'),('CAMIONETA'),('SPORT');

INSERT INTO public.tipo_trans(name)
   VALUES ('COMPRA ARTICULOS'),('PAGO EMPLEADO'),('COBROS POR SERVICIOS'),('VENTAS ARTICULOS');

INSERT INTO public.estado_orden(id, name, descripcion)
    VALUES (1,'COTIZADO','EL VEHICULO FUE REVISADO Y COTIZADO PARA EL CLIENTE'),
    (2,'EN ESPERA','EL VEHICULO SE ENCUENTRA EN COLA DE ESPERA'),
    (3,'EN PROCESO','EL VEHICULO SE ENCUENTRA EN PROCESO DE PREPARACION'),
    (4,'FACTURADO','EL VEHICULO FUE REPARADO CORRECTAMENTE Y SU FACTURA FUE SALDADA POR EL CLIENTE');