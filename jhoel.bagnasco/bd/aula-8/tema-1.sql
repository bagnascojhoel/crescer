/* criar um package constituido de 2 procedures e 1 function com as seguintes funções:

1) Reajusta o valor de venda dos produtos (apenas preço venda) de acordo com uma 
porcentagem definida por parâmetro para produtos com a situação Ativo, ignore os
pedidos ja a faxina e prepara a vá feitos com o preço antigo
2) Calcula e printa o valor total adquirido com o reajuste (valor antigo de 
preço de venda e novo valor, mostrando também a diferença entre os valores)
3) Ranking dos 3 produtos mais caros depois do reajuste
*/

create or replace PACKAGE pck_reajuste AS
  
  FUNCTION ajusta_valor_produto(pPorcentagem in NUMBER) RETURN NUMBER;
  
  PROCEDURE printa_valores(pValorAnterior in NUMBER);
  
  PROCEDURE reajusta_produtos(pPorcentagem in NUMBER);
                                        
END;

/

create or replace PACKAGE BODY pck_reajuste AS

  /* Calcula o novo valor para os produtos baseado na porcentagem 
     Calcula a soma dos valores antigos como retorno
  */
  FUNCTION ajusta_valor_produto(pPorcentagem in NUMBER)
    RETURN NUMBER AS rSoma produto.precovenda%type;
  
  BEGIN
    select sum(precovenda)
    into rSoma
    from produto
    where situacao = 'A';
    
    update produto
    set precovenda = precovenda * ((pPorcentagem / 100) + 1)
    where situacao = 'A';
     
    RETURN rSoma;

  END ajusta_valor_produto;

  /* Calcula a diferença entre os valores antigo e novo 
     Calcula a soma dos valores novos
     Printa os resultados em forma de relatório
  */
  PROCEDURE printa_valores(pValorAnterior IN NUMBER) AS

  vSomaAtual produto.precovenda%type;
  vDiferencaSomas produto.precovenda%type;

  BEGIN
    select sum(precovenda)
    into vSomaAtual
    from produto
    where situacao = 'A'; 
    
    vDiferencaSomas := vSomaAtual - pValorAnterior;
    
    DBMS_OUTPUT.PUT_LINE(
      'Somatório antigo: '
      || pvaloranterior
      || ', novo somatório: '
      || vsomaatual
      || ', diferença de: '
      || abs(vdiferencasomas));

  END printa_valores;

 /* Realiza o levantamento do ranking após chamar os outros procedimentos */
  PROCEDURE reajusta_produtos(pPorcentagem in NUMBER) AS

  vSoma produto.precovenda%type;

  CURSOR cr_produtos_mais_caros IS
    select
      nome,
      precovenda,
      rank() over (order by precovenda desc) ranking
    from produto
    order by precovenda desc
    fetch first 3 row only;

  BEGIN 

    vSoma := ajusta_valor_produto(pPorcentagem);
    printa_valores(pValorAnterior => vSoma);
    
    dbms_output.put_line('Três produtos mais caros após reajuste:');
    FOR produto IN cr_produtos_mais_caros LOOP
      DBMS_OUTPUT.PUT_LINE(
        produto.ranking
        || 'º Produto: '
        || produto.nome
        || ', valor: '
        || produto.precovenda);
    END LOOP;

  END reajusta_produtos;

END pck_reajuste;
/

exec pck_reajuste.reajusta_produtos(5);
