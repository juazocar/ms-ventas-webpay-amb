package cl.duoc.app.clients;

import cl.duoc.app.model.InitTransaction;
import cl.duoc.app.model.InitTransactionResponse;
import cl.duoc.app.model.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 *  La anotación FeignClient, nos sirve para poder establecer la comunicación con algun servicio externo, en este
 *  caso WebPay
 *  Entre los parámetros requeridos encontramos
 *  name = El cual es un nombre del servicio que no se debe repetir con otro feignClient
 *  url = Corresponde a la ruta base del servicio al cual nos queremos integrar.
 */
@FeignClient(name = "svc-webpay", url="https://webpay3gint.transbank.cl")
public interface IWebPayFeignClient {

    /**
     *  Cuando queremos generar una nueva integración a algún endpoint de la api remota, debemos tener en
     *  consideración las siguientes cosas
     *  1) Identificar el verbo HTTP al cual nos queremos integrar
     *     Si es POST usamos @PostMapping
     *     Si es GET usamos @GetMapping
     *     Si es PUT usamos @PutMapping
     *     Si es DELETE usamos @DeleteMapping
     *
     *  2) Revisar los parámetros que requiere el servicio externo, en este caso, el servicio pide
     *     2 headers (Tbk-Api-Key-Id y Tbk-Api-Key-Secret) y un body, el cual corresponde al Dto InitTransaction
     *     Este dto debe tener los mismos atributos que solicita el servicio.
     *  3) Debemos conocer cual es la respuesta del servicio. Esto siempre está documentado en el sition web del
     *     proveedor.
     */
    @PostMapping(path = "/rswebpaytransaction/api/webpay/v1.2/transactions")
    InitTransactionResponse initTransaction(@RequestHeader("Tbk-Api-Key-Id")     String apiKeyId,
                                            @RequestHeader("Tbk-Api-Key-Secret") String apiKeySecret,
                                            @RequestBody InitTransaction initTransaction);


    @PutMapping(path = "/rswebpaytransaction/api/webpay/v1.2/transactions/{token}")
    String confirmarTrx(@RequestHeader("Tbk-Api-Key-Id")     String apiKeyId,
                        @RequestHeader("Tbk-Api-Key-Secret") String apiKeySecret,
                        @PathVariable("token") String token);

    @GetMapping(path = "/rswebpaytransaction/api/webpay/v1.2/transactions/{token}")
    TransactionDTO obtenerTrx(@RequestHeader("Tbk-Api-Key-Id")     String apiKeyId,
                              @RequestHeader("Tbk-Api-Key-Secret") String apiKeySecret,
                              @PathVariable("token") String token);
}
