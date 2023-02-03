create user tickets with password 'haingo';
alter user tickets with createdb;
alter user tickets with superuser;
\q

createdb -U tickets tiketing;
psql -U tickets -d tiketing;
haingo

create table Evenements(
    id_E serial primary key,
    nom_E varchar not null
);
create SEQUENCE evenements start with 1 maxvalue 9999 increment by 1;

create function getSequenceEvenements()
RETURNS INT
language plpgsql
AS
$$
DECLARE
    id_E INTEGER;
BEGIN
    select nextVal('evenements_id_e_seq') into id_E from evenements;

    return id_E;
end;
$$;
create table type_place(
    id_Type serial primary key,
    nom_Type_Place varchar(200) not null
);

create table type_Billets(
    id_Type_Billets serial primary key,
    nom_Billets varchar(200) not null
);

create table confirmation(
    id_Conf serial primary key,
    type_Conf varchar(200) not null
);
create table zones(
    id_Z serial primary key,
    nom_Zone varchar(200) not null
);
create table zones_place(
     id_Zone serial primary key,
     nom_zone int references zones(id_Z) not null,
     quantite_zone int not null,
     type_Places int references type_place(id_Type),
     type_Billet int references type_Billets(id_Type_Billets)
);
create table tena_Evenements(
     id_Tena_Izy serial primary key,
     id_Evenements int references Evenements(id_E),
     id_Zone int references zones_place(id_Zone)
);

create table mividy(
    id_mividy serial primary key,
    nom_olona varchar(200) not null,
    id_Zone int references zones_place(id_Zone),
    type_Billet int references type_Billets(id_Type_Billets),
    quantite_billets int not null,
    conf int references confirmation(id_Conf),
    dates_Conf date not null,
    duree_reservation time 
);

alter table zones_place alter column nom_zone int references zones(id_Z) not null;
alter table evenements add nom_Createur varchar(200) not null;

insert into type_Place values
    (default,'Tsotra'),
    (default,'VIP'),
    (default,'Golden');

insert into type_Billets values
    (default,'Billets Tsotra'),
    (default,'Billets VIP'),
    (default,'Billets Golden');

insert into confirmation values
    (default,'Reserver'),
    (default,'Paye');

insert into zones values
    (default,'Zone A'),
    (default,'Zone B'),
    (default,'Zone C'),
    (default,'Zone D'),
    (default,'Zone E');
