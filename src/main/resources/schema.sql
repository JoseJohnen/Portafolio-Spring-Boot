CREATE TABLE IF NOT EXISTS public.forms
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nombre character varying(250) COLLATE pg_catalog."default" NOT NULL,
    fecha_nacimiento timestamp without time zone NOT NULL,
    edad integer NOT NULL,
    CONSTRAINT forms_pkey PRIMARY KEY (id)
);