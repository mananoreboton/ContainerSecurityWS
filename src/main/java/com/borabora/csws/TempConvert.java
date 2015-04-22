package com.borabora.csws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by mrbueno on 21/04/15.
 */
@WebService
public interface TempConvert {
    @WebMethod
    float c2f(float c);

    @WebMethod
    float f2c(float f);
}