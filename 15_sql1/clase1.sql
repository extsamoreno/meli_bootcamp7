{\rtf1\ansi\ansicpg1252\cocoartf2580
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fmodern\fcharset0 Courier;\f1\fmodern\fcharset0 Courier-Bold;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;\red255\green255\blue255;\red29\green29\blue30;
\red148\green0\blue58;\red255\green255\blue255;\red62\green190\blue234;\red18\green116\blue149;\red126\green107\blue29;
}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;\cssrgb\c100000\c100000\c100000;\cssrgb\c15332\c15333\c15686;
\cssrgb\c65555\c3536\c29320;\cssrgb\c100000\c100000\c99971\c84706;\cssrgb\c28238\c78930\c93370;\cssrgb\c3839\c52957\c65105;\cssrgb\c56975\c49065\c14804;
}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26\fsmilli13067 \cf2 \cb3 \expnd0\expndtw0\kerning0
CREATE DATABASE emple_dep;\
\
CREATE TABLE departamentos (\
  id int unsigned NOT NULL auto_increment,\
  nombre varchar(255) default NULL,\
  direccion varchar(255) default NULL,\
  PRIMARY KEY (id)\
) \
\
INSERT INTO departamentos (nombre,direccion) VALUES ("Riesgos","824-9741 Vestibulum St."),("IT","369 Pede Road"),("Legales","Ap #343-3035 Sed, Rd."),("Finanzas","7285 Eu Rd."),("RRHH","438 Dolor Ave");\
\pard\pardeftab720\partightenfactor0

\f1\b \cf2 \
CREATE TABLE empleados (
\f0\b0 \
\pard\pardeftab720\partightenfactor0
\cf2 	id int unsigned NOT NULL auto_increment,
\f1\b \

\f0\b0 	nro_legajo int unsigned NOT NULL,\
	dni int unsigned NOT NULL,\
	apellido varchar(255) NOT NULL,\
	nombre varchar(255) NOT NULL,\
	fecha_nacimiento timestamp NOT NULL,\
	fecha_incorporacion timestamp NOT NULL,\
	cargo varchar(255) NOT NULL,\
	sueldo_neto double NOT NULL,\
	departamento_id int NOT NULL,\
	
\f1\b constraint 
\f0\b0 dep_id\
  \'a0		
\f1\b foreign key 
\f0\b0 (dep_id) 
\f1\b references 
\f0\b0 departamentos (id)\
\pard\pardeftab720\partightenfactor0

\f1\b \cf2 )
\f0\b0 \

\f1\b INSERT INTO 
\f0\b0 empleados (nro_legajo,dni,apellido,nombre,fecha_nacimiento,fecha_incorporacion,cargo,sueldo_neto,departamento_id)\

\f1\b VALUES 
\f0\b0 ("71458129899",21683446,"Gretchen","Simmons","2021-07-19 02:49:08","2021-02-13 01:56:56","Administrativo",118981,5),\
      ("01366760999",21705696,"Wynter","Duffy","2021-05-01 18:21:15","2022-01-02 12:43:15","Administrativo",157423,5),\
       ("64303403699",37011393,"Timothy","Duncan","2021-11-08 12:36:34","2020-09-15 12:57:54","Administrativo",139762,4),\
       ("38218547499",20452239,"Jeremy","Raymond","2021-11-18 22:39:25","2021-09-23 10:32:14","Administrativo",195069,5),\
       ("07970219699",36901807,"Connor","Romero","2020-06-24 13:31:30","2020-11-29 06:40:24","Administrativo",140216,4),\
       ("66672946999",24171173,"Isadora","Whitley","2022-04-17 10:12:22","2021-07-04 13:44:30","Administrativo",151196,4),\
       ("66349470999",28671097,"Russell","Short","2021-07-20 08:48:56","2022-02-12 17:35:58","Administrativo",187550,1),\
       ("41436994599",30360086,"Karleigh","Kline","2021-04-01 21:44:59","2022-02-10 20:39:11","Administrativo",151169,5),\
       ("25488775299",36760801,"Louis","Joyce","2021-12-13 23:53:25","2022-03-19 18:45:40","Administrativo",100131,3),\
       ("04666642099",33903995,"Louis","Guthrie","2022-02-02 17:17:23","2021-05-13 10:42:41","Administrativo",182374,2),\
       ("86462447199",32404887,"Baker","Middleton","2022-04-12 20:37:15","2022-03-09 00:18:42","Administrativo",176018,5),\
       ("22898734499",36473104,"Connor","Oneill","2022-03-18 22:00:27","2021-05-04 23:02:46","Administrativo",129389,3),\
       ("64503934999",35506113,"Dominic","Malone","2021-12-20 19:23:31","2020-08-14 12:12:28","Administrativo",104673,3),\
       ("25961595899",22277577,"Quemby","Craft","2020-10-07 16:58:22","2021-02-20 16:56:10","Administrativo",112819,4),\
       ("39210653599",37126523,"Carissa","Webster","2020-10-03 18:25:18","2022-04-19 13:59:35","Administrativo",108463,2);\
}