create table pessoa (
	idPessoa				        int		 primary key	        	not null,
	nome    						varChar(50)							not null,
	cpf     						varChar(11) 						not null,
	dataNascimento					datetime							not null,
	dataCriacao 					datetime							not null
);

CREATE NONCLUSTERED INDEX idx_pessoa_cpf
    ON pessoa (cpf);
