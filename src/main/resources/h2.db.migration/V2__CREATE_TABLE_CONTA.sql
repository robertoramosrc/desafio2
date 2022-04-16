create table conta (
	idConta				        int		 primary key	        	not null,
	idPessoa				        int		            	        	not null,
	saldo                           numeric(21,2)                       not null,
    limiteSaqueDiario               numeric(21,2)                       not null,
    flagAtivo 						numeric(1)							not null,
	tipoConta   					numeric(2)							not null,
	dataCriacao 					datetime							not null
);

ALTER TABLE conta
    ADD CONSTRAINT FK_CONTA_PESSOA
        FOREIGN KEY (idPessoa) REFERENCES pessoa (idPessoa);


