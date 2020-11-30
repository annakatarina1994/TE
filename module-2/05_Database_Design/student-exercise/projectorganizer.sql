BEGIN TRANSACTION;

CREATE TABLE employee (
        employee_id serial NOT NULL,
        job_title varchar(100) NOT NULL,
        first_name varchar(30) NOT NULL,
        last_name varchar(30) NOT NULL,
        gender varchar(15) NULL,
        date_of_birth date NOT NULL,
        date_of_hire date NOT NULL,
        department_id int NOT NULL,
        project_id int NOT NULL,
        
        CONSTRAINT pk_employee PRIMARY KEY (employee_id)
        );
        
CREATE TABLE department (
        department_id serial NOT NULL,
        name varchar(50) NOT NULL,
        
        CONSTRAINT pk_department PRIMARY KEY (department_id)
        );
        
CREATE TABLE project (
        project_id serial NOT NULL,
        name varchar(50) NOT NULL,
        start_date date NOT NULL,
        CONSTRAINT pk_project PRIMARY KEY (project_id)
        );
        
ALTER TABLE employee
        ADD CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department (department_id),
        ADD CONSTRAINT fk_employee_project FOREIGN KEY (project_id) REFERENCES project (project_id);
        
COMMIT TRANSACTION;

