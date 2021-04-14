declare
  v_days_qty number;
begin
  v_days_qty := fnc_get_qtd_dias_next_vr(sysdate, 20);
  dbms_output.put_line(v_days_qty);
end;