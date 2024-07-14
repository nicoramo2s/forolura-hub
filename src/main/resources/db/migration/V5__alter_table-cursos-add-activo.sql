alter table cursos add column activo tinyint;
update cursos set activo = 1;
alter table cursos modify activo tinyint not null;