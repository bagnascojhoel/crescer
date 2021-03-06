package br.com.cwi.crescer.melevaai.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceTransitionResponse {
    private BigDecimal balance;
}
