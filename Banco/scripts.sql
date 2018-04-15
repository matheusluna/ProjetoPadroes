create table cliente(
	nome text not null,
	sobrenome text not null,
	email text primary key,
	senha text not null
)

create table admin(
	email text primary key,
	senha text not null
)

insert into admin values('admin@gmail.com', '123456')

create table atendente(
	nome text not null,
	email text primary key,
	senha text not null,
	foto text 
);

create table servico(
	id serial unique,
	nome text,
	primary key(id)
);

create table atendenteservico(
	atendente text,
	servico int,
	tempo time,
	primary key(atendente, servico),
	foreign	key (atendente) references atendente(email),
	foreign key (servico) references servico(id)
);

create table horarioatendente(
	atendente text,
	inicio time,
	fim time,
	diasemana text,
	primary key(atendente, inicio, fim, diasemana),
	foreign key(atendente) references atendente(email)
);

create table atendimento(
	cliente text,
	atendente text,
	servico int,
	dia date,
	inicio time,
	primary key(cliente, atendente, dia, inicio),
	foreign key (cliente) references cliente(email),
	foreign key (atendente) references atendente(email)
)


