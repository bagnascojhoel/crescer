create table log_produto (
  idlogproduto integer generated always as identity,
  usuario varchar2(30),
  data_modificacao date default sysdate,
  idproduto integer not null,
  operacao varchar(10) not null,
  constraint pk_log_produto primary key (idlogproduto)
);

create or replace trigger tr_aud_produtos
  after insert or update or delete on produto
  for each row
declare
  vOperacao log_produto.operacao%type;
  vIdProduto log_produto.idproduto%type;
begin
  vIdProduto := :new.idproduto;
  
  if INSERTING then
    vOperacao := 'INSERT';
  elsif UPDATING then
    vOperacao := 'UPDATE';
  else
    vIdProduto := :old.idproduto;
    vOperacao := 'DELETE';
  end if;
  
  insert into log_produto
    (idproduto, usuario, operacao)
    values (vIdProduto, user, vOperacao);
end;
