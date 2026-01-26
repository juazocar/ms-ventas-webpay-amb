package cl.duoc.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CardDetailDTO {
    @JsonProperty("card_number")
    private String cardNumber;
}
