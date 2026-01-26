package cl.duoc.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransactionDTO {

    @JsonProperty("vci")
    private String        vci;
    @JsonProperty("amount")
    private int           amount;
    @JsonProperty("status")
    private String        status;
    @JsonProperty("buy_order")
    private String        buyOrder;
    @JsonProperty("session_id")
    private String        sessionId;
    @JsonProperty("card_detail")
    private CardDetailDTO cardDetailDTO;
    @JsonProperty("accounting_date")
    private String        accountingDate;
    @JsonProperty("transaction_date")
    private String        transactionDate;
    @JsonProperty("authorization_code")
    private String        authorizationCode;
    @JsonProperty("payment_type_code")
    private String        paymentTypeCode;
    @JsonProperty("response_code")
    private String           responseCode;
    @JsonProperty("installments_number")
    private int           installmentsNumber;
}
