/*
  No exercício 5: utilizamos a função translate, que recebe três string's: a 
  primeira, é a string base onde serão buscados e alterados os caracteres; a se-
  gunda, é a string que representa a lista de caracteres a serem substituidos;
  a terceira é a string que relaciona cada caracter do segundo parametro a um
  novo caracter;
*/
CREATE OR REPLACE FUNCTION fnc_remove_acentos (
  p_string IN VARCHAR2
) RETURN VARCHAR2 IS
  v_localizar   VARCHAR2(100) := 'ŠŽšžŸÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜÏÖÑÝåáçéíóúàèìòùâêîôûãõëüïöñýÿ';
  v_substituir  VARCHAR2(100) := 'SZszYACEIOUAEIOUAEIOUAOEUIONYaaceiouaeiouaeiouaoeuionyy';
BEGIN
  RETURN translate(p_string, v_localizar, v_substituir);
END;