ALTER TABLE favorito
  DROP CONSTRAINT favorito_fk_usuario_id_fkey;
ALTER TABLE favorito
  DROP COLUMN fk_usuario_id;
ALTER TABLE favorito
  ADD COLUMN uid character varying(200);