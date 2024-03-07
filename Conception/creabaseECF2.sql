/*==============================================================*/
/* Nom de SGBD :  Microsoft SQL Server 2016                     */
/* Date de création :  27/02/2024 08:26:17                      */
/*==============================================================*/


if exists (select 1
            from  sysobjects
           where  id = object_id('CLIENT')
            and   type = 'U')
   drop table CLIENT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PROSPECT')
            and   type = 'U')
   drop table PROSPECT
go

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
CREATE TABLE CLIENT (
   ID_CLIENT            numeric              IDENTITY,
   CHIFFREAFFAIRE_CLIENT decimal(10,2)        NOT NULL,
   RAISONSOCIAL_SOCIETE varchar(50)          NOT NULL 
      CONSTRAINT UQ_RAISONSOCIAL_SOCI_CLIENT UNIQUE,
   NUMERORUE_SOCIETE    varchar(5)           NOT NULL,
   NOMRUE_SOCIETE       varchar(30)          NOT NULL,
   VILLE_SOCIETE        varchar(45)          NOT NULL,
   CODEPOSTAL_SOCIETE   varchar(5)           not null,
   TELEPHONE_SOCIETE    varchar(20)          NOT NULL 
      CONSTRAINT MIN_TELEPHONE_SOCIETE_CLIENT CHECK (LEN(TELEPHONE_SOCIETE) >= 10),
   ADRESSEMAIL_SOCIETE  varchar(60)          NOT NULL,
   COMMENTAIRE_SOCIETE  text                 NULL,
   NBREMPLOYE_CLIENT    int                  NOT NULL,
   CONSTRAINT PK_CLIENT PRIMARY KEY (ID_CLIENT)
)
GO


/*==============================================================*/
/* Table : PROSPECT                                             */
/*==============================================================*/
CREATE TABLE PROSPECT (
   ID_PROSPECT          numeric              IDENTITY,
   DATE_PROSPECT        datetime             NOT NULL,
   RAISONSOCIAL_SOCIETE varchar(50)          NOT NULL
		CONSTRAINT UQ2_RAISONSOCIAL_SOCIETE UNIQUE,
   NUMERORUE_SOCIETE    varchar(5)           NOT NULL,
   NOMRUE_SOCIETE       varchar(30)          NOT NULL,
   VILLE_SOCIETE        varchar(45)          NOT NULL,
   CODEPOSTAL_SOCIETE   varchar(5)           not null,
   TELEPHONE_SOCIETE    varchar(20)          NOT NULL 
      CONSTRAINT MIN2_TELEPHONE_SOCIETE_PROSPECT CHECK (LEN(TELEPHONE_SOCIETE) >= 10),
   ADRESSEMAIL_SOCIETE  varchar(60)          NOT NULL,
   COMMENTAIRE_SOCIETE  text                 NULL,
   INTERET_PROSPECT     varchar(3)           NOT NULL,
   CONSTRAINT PK_PROSPECT PRIMARY KEY (ID_PROSPECT)
)
GO



