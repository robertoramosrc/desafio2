create table transacao (
	idTransacao			            int		 primary key	        	not null,
	idConta				            int		            	        	not null,
	valor                           numeric(21,2)                       not null,
    tipoTransacao  					char(1) 							not null,
	dataTransacao 					datetime							not null
);

ALTER TABLE transacao
    ADD CONSTRAINT FK_TRANSACAO_CONTA
        FOREIGN KEY (idConta) REFERENCES conta (idConta);

