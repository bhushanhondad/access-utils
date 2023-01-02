package com.access;

import com.access.utils.AccessUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginCtxController {
    @PostMapping("/loginCtxDecoder")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity loginCtxDecoder(@RequestBody AccessCtxPayload accessCtxPayload) {
        String tenantName = accessCtxPayload.getTenantName();
        String loginCtx = accessCtxPayload.getLoginCtx();
        try {
            String decodedLoginCtx = AccessUtils.loginCtxDecrypt(tenantName, loginCtx);
            return new ResponseEntity(decodedLoginCtx, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/errorCtxDecoder")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity errorCtxDecoder(@RequestBody AccessCtxPayload accessCtxPayload) {
        String tenantName = accessCtxPayload.getTenantName();
        String errorCtx = accessCtxPayload.getErrorCtx();
        try {
            String decodedLoginCtx = AccessUtils.errorCtxDecrypt(tenantName, errorCtx);
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