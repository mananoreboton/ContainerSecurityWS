package com.borabora.csws;

import com.borabora.csws.client.TempConvertImplService;

import javax.net.ssl.*;
import javax.xml.ws.BindingProvider;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * Created by mrbueno on 21/04/15.
 */
public class TempConvert_Client {
    private static final String HTTPS_URL = "https://localhost:8443/ws/tc";

    public static void main(String[] args) {
//        setSecurity();
        TempConvertImplService service = new TempConvertImplService();
        com.borabora.csws.client.TempConvert port = service.getTempConvertImplPort();

//        change url to https port
        Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, HTTPS_URL);

        float v = port.c2F(2.2f);
        System.out.println("v = " + v);
        float v1 = port.f2C(34f);
        System.out.println("v1 = " + v1);
    }

    private static void setSecurity() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                // Trust always
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                // Trust always
            }
        }};
        // Install the all-trusting trust manager
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // Create empty HostnameVerifier
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        };

        try {
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }
}
