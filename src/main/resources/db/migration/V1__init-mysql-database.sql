
   drop table if exists publisher;
   drop table if exists author;
   drop table if exists book;



 create table publisher (
              version integer,
               created_date datetime(6),
               update_date datetime(6),
               id varchar(36) not null,
               label varchar(50) not null,
               zip_code varchar(50) not null,
               email varchar(255) not null,
               primary key (id),
               CONSTRAINT UC_Publisher UNIQUE (id,email)
     ) engine=InnoDB;

   create table author (
             version integer,
             created_date datetime(6),
             update_date datetime(6),
             id varchar(36) not null,
             name varchar(50) not null,
             last_name varchar(50) not null,
             email varchar(255) not null ,
             primary key (id),
             CONSTRAINT UC_Author UNIQUE (id,email)
     )engine=InnoDB;


     create table book (
            version integer,
            created_date datetime(6),
            update_date datetime(6),
            id varchar(36) not null,
            title varchar(50) not null,
            price decimal(38,2) not null,
            publisher_id   varchar(36)  DEFAULT NULL,
            author_id   varchar(36)  DEFAULT NULL,
            primary key (id),
            CONSTRAINT FOREIGN KEY (publisher_id) REFERENCES publisher (id),
            CONSTRAINT FOREIGN KEY (author_id) REFERENCES author (id)
     )engine=InnoDB;




