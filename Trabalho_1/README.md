##Cadastro de Livros

###Trabalho 1

######Disciplina: Padrões de Projeto

######Aluno: Antonio Darcy Soares Fontenele

Para rodar o projeto basta seguir os passos listados a seguir:
1. Download
    - Execute o comando abaixo no terminal.
        ```
        git clone https://github.com/darcyfontenele/esdo-padroes-de-projetos.git
        ```
2. Montagem do ambiente
    - Para o ambiente do projeto é recomendado o uso do docker e necessário:
        - Java 8
        - Postgres
        - Maven
    - Com o postgres instalado é necessário criar um banco e executar o script de geração da tabela necessária.
        ```
        CREATE TABLE public.book (
            id bigserial NOT NULL,
            title varchar(255) NOT NULL,
            author varchar(255) NULL,
            summary varchar(255) NULL,
            release_year int4 NULL,
            CONSTRAINT book_pk PRIMARY KEY (id)
        );
        ALTER TABLE public.book OWNER TO postgres;
        GRANT ALL ON TABLE public.book TO postgres;
        ```
   - No arquivo persistence.xml localizado dentro da pasta META-INF é necessário colocar a URI do banco com o nome do mesmo.
3. Build
    - Para buidar o projeto é necessário executar o comando abaixo na pasta raiz.
        ```
            mvn clean package install
        ```
4. Deploy
    - Utilizando docker:
        1. Montar imagem docker a partir do Dockerfile executando o comando abaixo na pasta raiz.
            ```
            docker build -t trabalho-1 .
            ```
        2. Executar o comando abaixo para iniciar o servidor.
            ```
            docker run --rm -p 8080:8080 -v /<PATH PARA O PROJETO>/target/trabalho-1.war:/usr/local/tomcat/webapps/trabalho-1.war --network=host --name trabalho-1  trabalho-1
            ```
