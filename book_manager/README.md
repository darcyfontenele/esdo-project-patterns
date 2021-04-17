## Book Manager

### Project 1

##### Course: Project Patterns
##### Student: Antonio Darcy Soares Fontenele

---

Book manager develop in Java using JSP, PostgresSQL as database and docker to deploy project..

## Build and Run
To run the project follow the next steps:
1. Download
    - Run the command to download project:
        ```
        git clone https://github.com/darcyfontenele/esdo-project-patterns.git
        ```
2. Mount enviroment
    - For the project environment, the use of the docker is recommended and it is necessary to:
        - Java 8
        - Postgres
        - Maven
    - In postgres, create the database and run the next queries to create tables.
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
   - In persistence.xml file, inside the META-INF folder, is necessary to change the database URI with the datebase name.
3. Build
    - To build the project run de next command in root folder.
        ```
        mvn clean package install
        ```
4. Deploy
    - Using docker:
        1. Build docker image from Dockerfile running the next command.
            ```
            docker build -t trabalho-1 .
            ```
        2. Running the command below to start the server.
            ```
            docker run --rm -v /<PATH PARA O PROJETO>/target/trabalho-1.war:/usr/local/tomcat/webapps/trabalho-1.war --network=host --name trabalho-1  trabalho-1
            ```
5. Access the system in URI:
    http://localhost:8080/trabalho-1/books