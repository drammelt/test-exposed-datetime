CREATE TABLE public.baserepo (
	id bigserial NOT NULL,
	updated_at timestamp NOT NULL,
	created_at timestamp NOT NULL,
	deleted bool NOT NULL DEFAULT false
);

INSERT INTO public.baserepo (updated_at,created_at,deleted) VALUES
	 ('2022-07-18 10:44:24.376','2022-07-18 10:44:24.376',false);
