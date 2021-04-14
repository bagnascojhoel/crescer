create or replace package pck_cidade as
  
  procedure ajusta_cidade_cliente(pNome in varchar2, 
                                  pUF in varchar2, 
                                  pMenorIDCidade in integer);
  procedure exclui_cidades_duplicadas(pNome in varchar2, 
                                      pUF in varchar2, 
                                      pMenorIDCidade in integer);
  procedure elimina_duplicadas;
                                        
end;
/

create or replace package body pck_cidade as
  
  procedure ajusta_cidade_cliente(pNome in varchar2, 
                                  pUF in varchar2, 
                                  pMenorIDCidade in integer) as
    cursor cr_clientes is
      select cl.idcliente
      from cliente cl
      inner join cidade cd
      on cl.idcidade = cd.idcidade
      where
        cd.nome = pNome
        and cd.uf = pUF;
      
  begin
    for registro in cr_clientes loop
      update cliente
      set idcidade = pMenorIDCidade
      where idcliente = registro.idcliente;
    end loop;
  end ajusta_cidade_cliente;
  
  procedure exclui_cidades_duplicadas(pNome in varchar2, 
                                      pUF in varchar2, 
                                      pMenorIDCidade in integer) as
    cursor cr_cidades is
      select idcidade
      from cidade
      where
        nome = pNome
        and uf = pUF
        and idcidade != pMenorIDCidade;
  begin
     for registro in cr_cidades loop
      delete
      from cidade
      where idcidade = registro.idcidade;
     end loop;
  end exclui_cidades_duplicadas;
  
  procedure elimina_duplicadas as
  
    cursor cr_cidades_duplicadas is
      select
        c.nome,
        c.uf,
        min(c.idcidade) idcidade
      from cidade c
      inner join (
        select
          nome,
          uf
        from cidade
        group by
          nome,
          uf
        having count(1) > 1
      ) cf
      on
        c.nome = cf.nome
        and c.uf = cf.uf
      group by
        c.nome,
        c.uf;
        
      
      
  begin
      for registro in cr_cidades_duplicadas loop
      
        ajusta_cidade_cliente(
          pNome => registro.nome,
          pUF => registro.uf,
          pMenorIDCidade => registro.idcidade
        );
    
        exclui_cidades_duplicadas(
          pNome => registro.nome,
          pUF => registro.uf,
          pMenorIDCidade => registro.idcidade); 
          
        dbms_output.put_line(
          'A cidade '
          || registro.nome
          || ' do '
          || registro.uf
          || ' teve seus clientes atualizados com sucesso!');
          
      end loop; 
  end elimina_duplicadas;
                                      
end;
/