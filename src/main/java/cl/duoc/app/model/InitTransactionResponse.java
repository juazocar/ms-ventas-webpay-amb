package cl.duoc.app.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InitTransactionResponse {

    private String token;
    private String url;
}
