/*
  Nessa pergunta 1 eu passei uma variavel como retorno, usei a função concat e os caracteres pipes para variar na concatenação, pois os dois
  fazem a mesma coisa. Para deixar a primeira letra maiuscula usei a função upper junto com a substr para pegar exatamente a primeira letra
  e para deixar as demais minsculas usei a função lower junto com a função substr e junto com a função substr usei a função length para pegar
  o tamanho exato do resto do nome que viria como parametro.
*/
CREATE OR REPLACE FUNCTION fnc_concatena_string (
  pprimeironome  VARCHAR2,
  psegundonome   VARCHAR2
) RETURN VARCHAR2 AS
  rnomecompleto VARCHAR2(200);
BEGIN
  rnomecompleto := concat(upper(substr(pprimeironome, 1, 1)), lower(substr(pprimeironome, 2,(length(pprimeironome) - 1))))
                   || ' '
                   || concat(upper(substr(psegundonome, 1, 1)), lower(substr(psegundonome, 2,(length(psegundonome) - 1))));

  RETURN rnomecompleto;
END fnc_concatena_string;