package cl.duoc.app.services;

import cl.duoc.app.clients.IWebPayFeignClient;
import cl.duoc.app.model.InitTransaction;
import cl.duoc.app.model.InitTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class WebPayService {

    @Autowired
    IWebPayFeignClient iWebPayFeignClient;

    public InitTransactionResponse iniciarTransaccion(InitTransaction initTransaction){

        String apiKeyId     = "597055555532";
        String apiKeySecret = "579B532A7440BB0C9079DED94D31EA1615BACEB56610332264630D42D0A36B1C";

        InitTransactionResponse resultado = iWebPayFeignClient.initTransaction(apiKeyId, apiKeySecret, initTransaction);
        return resultado;
    }

    public String confirmarTrx(String token){
        String apiKeyId     = "597055555532";
        String apiKeySecret = "579B532A7440BB0C9079DED94D31EA1615BACEB56610332264630D42D0A36B1C";

        return iWebPayFeignClient.confirmarTrx(apiKeyId, apiKeySecret, token);
    }

    public String obtenerTrx(String token){
        String apiKeyId     = "597055555532";
        String apiKeySecret = "579B532A7440BB0C9079DED94D31EA1615BACEB56610332264630D42D0A36B1C";
        return iWebPayFeignClient.obtenerTrx(apiKeyId, apiKeySecret, token);
    }
}
