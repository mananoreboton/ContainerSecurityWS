Add In the main Tomcat configuration file conf/server.xml, the section:

<Connector port="8443" protocol="org.apache.coyote.http11.Http11Protocol"
               maxThreads="150" SSLEnabled="true" scheme="https" secure="true"
               clientAuth="false" sslProtocol="TLS" keystoreFile="/home/user/.keystore"/>

Generate certificate:

    % keytool -genkey -alias tomcat -keyalg RSA

Invoke the client, with the -D options to set the keystore and truststore information:

    % java -Djavax.net.ssl.trustStore=/home/user/.keystore \
    -Djavax.net.ssl.trustStorePassword=changeit            \
    -Djavax.net.ssl.keyStore=/home/user/.keystore        \
    -Djavax.net.ssl.keyStorePassword=changeit TempConvert_Client

Troubleshooting:

    java.net.SocketException: Unexpected end of file from server -> Miss 's' in HTTPS_URL

    -Djavax.net.ssl.trustStore=/home/mrbueno/.keystore -Djavax.net.ssl.trustStorePassword=changeit