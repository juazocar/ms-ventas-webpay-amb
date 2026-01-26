package cl.duoc.app.controller;

import cl.duoc.app.model.InitTransaction;
import cl.duoc.app.model.InitTransactionResponse;
import cl.duoc.app.services.WebPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebPayController {

    @Autowired
    WebPayService webPayService;

    @PostMapping("/init-transaction")
    public InitTransactionResponse initTransacion(@RequestBody InitTransaction initTransaction){
        return webPayService.iniciarTransaccion(initTransaction);
    }

    @PutMapping("/confirmar-trx/{token}")
    String confirmarTrx(@PathVariable("token") String token){
        return webPayService.confirmarTrx(token);
    }

    @GetMapping("/obtener-trx/{token}")
    String obtenerTrx(@PathVariable("token") String token){
        return webPayService.obtenerTrx(token);
    }
}
