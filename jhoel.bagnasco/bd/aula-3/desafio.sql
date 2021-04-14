SELECT
  emp0.nomeempregado    "Empregado",
  emp0.cargo            "Cargo Empregado",
  emp1.nomeempregado    "Gerente",
  emp1.cargo            "Cargo Gerente"
FROM
       empregado emp0
  JOIN empregado emp1 ON emp0.idgerente = emp1.idempregado