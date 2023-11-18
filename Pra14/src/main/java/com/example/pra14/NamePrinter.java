package com.example.pra14;

import jakarta.jws.*;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class NamePrinter {
    @WebMethod
    public String printName() {
        return "My Name is Mihir.";
    }
}