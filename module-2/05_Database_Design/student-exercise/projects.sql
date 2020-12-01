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

INSERT INTO department (name)
        VALUES ('Human Resources'), ('Sales'), ('IT');
                
INSERT INTO project (name, start_date)
        VALUES ('Project Hire Hunters', '08/31/2020'), ('Sell Out', '01/03/2005'), ('Automate Automating', '04/01/2018'), ('System Update 3000', '05/09/2019'), ('Pitch Poor', '10/31/2020');
        
INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, date_of_hire, department_id, project_id)
        VALUES ('HR Manager', 'Steve', 'Thompson', 'male', '07/11/1975', '02/16/2003', 1, 1),
                ('HR Representative', 'Jesse', 'Pinkman', null, '08/21/1987', '11/24/2019', 1, 1),
                ('Sales Manager', 'Nikita', 'Boseman', 'female', '03/07/1968', '12/03/2008', 2, 2),
                ('Sales Representative', 'Gary', 'Krusczynski', 'male', '05/11/1980', '04/21/2011', 2, 5),
                ('Scrum Master', 'Nathaniel', 'Blackman', 'male', '03/15/1965', '09/14/2010', 3, 3),
                ('Software Engineer', 'Svetlana', 'Karsaiova', 'female', '05/09/1990', '11/30/2019', 3, 4),
                ('Sales Representative', 'Edwina', 'Sanchez', 'female', '06/12/1988', '07/23/2016', 2, 5),
                ('Help Desk Technician', 'Sam', 'Abebe', null, '06/30/1992', '06/07/2017', 3, 4),
                ('RPA Developer', 'Akari', 'Secka', 'female', '08/10/1980', '11/30/2019', 3, 3),
                ('System Administrator', 'Camilo', 'Garcia', 'male', '07/01/1984', '04/04/2010', 3, 4),
                ('Sales Representative', 'Dzenana', 'Nedasova', 'female', '02/12/1973', '08/10/2019', 2, 2);
               