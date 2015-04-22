package com.borabora.csws;

import javax.jws.WebService;

/**
 * Created by mrbueno on 21/04/15.
 */
@WebService(endpointInterface = "com.borabora.csws.TempConvert")
public class TempConvertImpl implements TempConvert {
    public float c2f(float t) {
        return 32.0f + (t * 9.0f / 5.0f);
    }

    public float f2c(float t) {
        return (5.0f / 9.0f) * (t - 32.0f);
    }
}
