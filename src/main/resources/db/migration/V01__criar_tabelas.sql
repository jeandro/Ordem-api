CREATE TABLE public.ordem_servico (
    codigo SERIAL PRIMARY KEY,
    idcliente integer NOT NULL,
    problema text,
    solucao text,
    modelo_equipamento text,
    marca_equipamento text,
    status character varying(255),
    idusuarioordem integer NOT NULL,
    data_hora_usuario_ordem timestamp without time zone,
    data_hora_entrega_prevista timestamp without time zone,
    idusuariofechamento integer NOT NULL,
    data_hora_usuario_fechamento timestamp without time zone
 
);

COPY public.ordem_servico (idcliente, problema, solucao, modelo_equipamento,  marca_equipamento, status, idusuarioordem, data_hora_usuario_ordem, data_hora_entrega_prevista, idusuariofechamento, data_hora_usuario_fechamento ) FROM stdin;
2	NÃO CONECTA NA INTERNET	string	HP PAVILHON	HP	ESPERA	2	2021-04-02 09:44:48.646	2021-04-02 09:44:48.645	3	2021-04-02 09:44:48.646
1	NÃO LIGA	string	DELL INSPIRION	DELL	RESOLVIDO	1	2021-04-02 09:44:48.646	2021-04-02 09:44:48.645	1	2021-04-02 09:44:48.646
3	TECLADO NÃO FUNCIONA	string	POSITIVO 345	POSITIVO	NO LABORATORIO	1	2021-04-02 09:44:48.646	2021-04-02 09:44:48.645	1	2021-04-02 09:44:48.646
1	TELA PRETA	string	ASSUS P17	ASSUS	RESOLVIDO	3	2021-04-02 09:44:48.646	2021-04-02 09:44:48.645	2	2021-04-02 09:44:48.646
1	NÃO TEM  O WORD INSTALADO	string	ITAUTEC 234	ITAUTEC	NO LABORATORIO	1	2021-04-02 09:44:48.646	2021-04-02 09:44:48.645	1	2021-04-02 09:44:48.646
\.


CREATE TABLE public.cidade (
    codigo SERIAL PRIMARY KEY,
    codibge character varying(255),
    nome character varying(255),
    uf	 character varying(255)
);

COPY public.cidade (codibge, nome,	uf) FROM stdin;
5217708	PONTALINA	GO
5206503	CROMINIA	GO
5207402	EDEIA	GO
5207352	EDEALINA	GO
5212600	MAIRIPOTADA	GO
5218391	PROF. JAMIL	GO
5200506	ALOANDIA	GO
5222054	VICENTINOPOLIS	GO
5201801	ARAGOIANIA	GO
5209101	GOIATUBA	GO
5211503	ITUMBIARA	GO
5213806	MORRINHOS	GO
5215306	ORIZONA	GO
5212105	JOVIANIA	GO
\.



CREATE TABLE public.cliente (
    codigo SERIAL PRIMARY KEY,
    nome character varying(255),
    email character varying(255),
    cpf character varying(255),
    celular character varying(255),
    endereco character varying(255),
    cep character varying(255),
    idcidade integer NOT NULL

);

COPY public.cliente (nome, email, cpf, celular, endereco, cep, idcidade) FROM stdin;
PAULO CORREIA	paulo@gmail.com	758.254.788-48	(64) 9 9375-0229	RUA ITAPOLIS 35	75.620-000	1
JOAO CORREIA	jp@gmail.com	485.754.158-76	(62) 9 9775-0226	RUA GOIANIA 369	75.620-000	3
ROGERIO ANTUNES	@gmail.com	684.294.277-75	(64) 9 9377-0279	RUA DAS ANDORINHAS 368	75.620-000	1
GERONIMO CORREIA	drg@gmail.com	475.254.751-47	(64) 9 9335-0729	RUA MORRINHOS 37	75.620-000	1
PEDRO PAULO	ppaulo@gmail.com	875.875.258-27	(67) 9 9365-0229	RUA BRASIL    368	75.620-000	2
JORGE ARAGAO	aragao@gmail.com	365.254.258-73	(64) 9 9375-0228	RUA MORRINHOS 378	75.620-000	1
CRISTINA FERNANDES	cfernandes@gmail.com	795.254.548-73	(63) 9 9735-7229	RUA A 368	75.620-000	14
\.



CREATE TABLE public.usuario (
    codigo SERIAL PRIMARY KEY,
    ativo boolean NOT NULL,
    celular character varying(255),
    email character varying(255),
    login character varying(255),
    nascimento date,
    nome character varying(255),
    permissao character varying(255),
    senha character varying(255)
);

COPY public.usuario (ativo, celular, email, login, nascimento, nome, permissao, senha) FROM stdin;
t	(64) 9999-9999	rhennoa@gmail.com	RHENNOA	2018-07-25	RHENNOA	ROLE_USUARIO	151850
t	(64) 9 9284-2200	jeandro@gtasistemas.com.br	JEANDRO	2007-01-01	JEANDRO ALVES CORREIA	ROLE_USUARIO	3698
t	(64) 9 9234-3245	juca@gtasistemas.com.br	JUCA	2007-01-01	JUCA ALVES CORREIA	ROLE_ADMINISTRADOR	3698
t	(64) 9 9254-2584	jose@gtasistemas.com.br	JOSE	2007-01-01	JOSE	ROLE_ADMINISTRADOR	3698
t	(64) 9 9284-6589	bruna@gtasistemas.com.br	BRUNA	2007-01-01	BRUNA	ROLE_USUARIO	3698
\.


