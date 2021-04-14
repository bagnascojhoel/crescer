DECLARE
  CURSOR cr_cidades_duplicadas IS
    select idcidade
    from cidade 
    inner join (
      SELECT nome, uf, count(1)
      FROM cidade
      GROUP BY nome, uf
      HAVING COUNT(1) > 1
    ) subq on cidade.nome || cidade.uf = subq.nome || subq.uf;

  CURSOR cr_cliente_cidade_duplicada (pidcidade IN NUMBER) IS
    SELECT nome
    FROM cliente
    WHERE idcidade = pidcidade;

BEGIN
  FOR reg_cidade IN cr_cidades_duplicadas LOOP
    FOR reg_cliente IN cr_cliente_cidade_duplicada(reg_cidade.idcidade) LOOP
      dbms_output.put_line(reg_cliente.nome || ' da cidade ' || reg_cidade.idcidade);
    END LOOP;
  END LOOP;
END;

DECLARE
  CURSOR cr_cliente_cidade_duplicada IS
    SELECT nome, idcidade
    FROM cliente
    WHERE idcidade in (
      select idcidade
      from cidade 
      inner join (
        SELECT nome, uf, count(1)
        FROM cidade
        GROUP BY nome, uf
        HAVING COUNT(1) > 1
      ) subq on cidade.nome || cidade.uf = subq.nome || subq.uf
    );

BEGIN
  FOR reg_cliente IN cr_cliente_cidade_duplicada LOOP
    dbms_output.put_line(reg_cliente.nome || ' da cidade ' || reg_cliente.idcidade);
  END LOOP;
END;



