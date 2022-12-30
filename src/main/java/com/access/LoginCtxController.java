package com.access;

import com.access.utils.AccessUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginCtxController {
    @PostMapping("/loginCtxDecoder")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity newBook(@RequestBody LoginCtxPayload certificateChainPayload) {
        String tenantName = certificateChainPayload.getTenantName();
        String loginCtx = certificateChainPayload.getLoginCtx();
        try {
            String decodedLoginCtx = AccessUtils.loginCtxDecrypt(tenantName, loginCtx);
            return new ResponseEntity(decodedLoginCtx, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping ("/test")
    @ResponseStatus(HttpStatus.CREATED)
    String test() {
        return "working ok";
        }
}