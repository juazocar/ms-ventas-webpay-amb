package cl.duoc.app.services;

import cl.duoc.app.clients.IWebPayFeignClient;
import cl.duoc.app.model.InitTransaction;
import cl.duoc.app.model.InitTransactionResponse;
import cl.duoc.app.model.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class WebPayService {

    @Autowired
    IWebPayFeignClient iWebPayFeignClient;

    @Value("${api.key.id}")
    private String apiKeyId;
    @Value("${api.key.secret}")
    private String apiKeySecret;

    public InitTransactionResponse iniciarTransaccion(InitTransaction initTransaction){
        InitTransactionResponse resultado = iWebPayFeignClient.initTransaction(apiKeyId, apiKeySecret, initTransaction);
        return resultado;
    }

    public String confirmarTrx(String token){
       return iWebPayFeignClient.confirmarTrx(apiKeyId, apiKeySecret, token);
    }

    public TransactionDTO obtenerTrx(String token){
        TransactionDTO transactionDTO = iWebPayFeignClient.obtenerTrx(apiKeyId, apiKeySecret, token);
        transactionDTO.setVci((transactionDTO.getVci() == null)? "": transactionDTO.getVci());

        return transactionDTO;
    }
}
