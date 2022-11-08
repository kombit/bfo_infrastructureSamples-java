## 1. Introduction

These code examples are made to help you build integrations with Fælleskommunal Beskedfordeler (BFO). It demonstrates how to:

* Generate code classes from XSD files ([see chapter 5](#5-code-generation-from-xsd-files))
* Get a token from Security Token Service ([WS-Trust implementation](https://cxf.apache.org/docs/ws-trust.html))
* Send a message to BFO via [AMQP](https://www.amqp.org/) (**Afsend**)
* Receive a message from BFO via [AMQP](https://www.amqp.org/) (**Afhent**)
* Receive a message from BFO via push REST service and how to respond (**Modtag**)
* Create/update/list/delete Værdiliste via Web Service (SOAP)

## 2. Prerequisites
* At least Java 11
* Certificates ([see 2.1](#21-amqp-certificates-sendreceive-messages-via-afsendafhent) and [2.2](#22-rest-delivery-certificates-receive-messages-via-modtag))

#### 2.1 AMQP Certificates (send/receive messages via Afsend/Afhent)

In order for the amqp application to work, you need to place the following certificates in a truststore:
* BFO function certificate.
    * This certificate is included in this package and can also be downloaded from [Digitaliseringskataloget](https://docs.kombit.dk/loesning/adgangsstyring/certifikater).
* Security Token Service Certificate.
    * This certificate is included in this package and can also be downloaded from [Digitaliseringskataloget](https://docs.kombit.dk/loesning/adgangsstyring/certifikater).

Example certificates can be found in the **cert** folder in bf-client-example-app folder.

#### 2.2 Rest delivery Certificates (receive messages via Modtag)

In order to receive messages via **Modtag**, you need the following certificates so that BFO can establish a 2-way TLS connection with your REST endpoint:
* A TLS/SSL certificate issued to your HTTPS endpoint (The Root CA of this certificate must be on BFOs whitelist - see D.09.02 Beskedfordeler-Besked-Aflever-Snitflade.pdf).
* BFO function certificate (placed in a truststore).
    * This certificate is included in this package and can also be downloaded from [Digitaliseringskataloget](https://docs.kombit.dk/loesning/adgangsstyring/certifikater).
* An Anvendersystem registered in Fælleskommunal Administrationsmodul. Read more on how to set this up [here](https://digitaliseringskataloget.dk/kom-godt-i-gang-vejledninger)
    * This anvendersystem must have a service agreement (**Serviceaftale**) with BFO for the service **Modtag**.
    * This is where you will need to register your TLS/SSL certificate and endpoint under It-systemer -> YourSystemName -> Anvendersystem -> Callback Endpoints.

Example certificates (except for TLS/SSL certificate) can be found in the **certs** folder which is located in path 'restdelivery-example-app\src\main\resources'.

**Disclaimer:** These certificates are not required to run the code example out of the box. This is because the code example does not interact with the real BFO, but rather shows how an endpoint could be implemented and allows you to send local messages to it yourself.

## 3. Code example project structure

The code examples consist of two different java projects:
* **bf-client-example-app** which contains an example of an integration with BFO via AMQP method (**Afhent** and **Afsend**)
    * java classes (`dk/kombit/samples/beskedfordeler/`):
        * `amqp` package contains classes responsible for receiving and sending messages via AMQP:
            * `amqp/AfhentBesked.java` - main class for receiving messages (**Afhent**)
            * `amqp/AfsendBesked.java` - main class for sending messages (**Afsend**)
        * `soap` package contains classes responsible for integration with web services via SOAP:
          * `soap/SoapClient.java` - main class for web services code example
        * `sts` package contains classes responsible for obtaining token form Security Token Service
        * `utils` package contains helper classes
    * `resources/`:
      * `beskedfordeler` folder contains XSD files that define the schema for communication with BFO ([see chapter 5](#5-code-generation-from-xsd-files))
      * `example_messages` folder contains a valid example message that can be sent to BFO for testing purposes
      * `wsdl` folder contains web service definition for CXF Security Token Service communication ([see chapter 6.1](#61-wsdl-for-cxf-security-token-service))
      * `application.properties` - main config file for **bf-client-example-app**
      * `logback.xml` - logback file (set up logging level here)
* **restdelivery-example-app** which contains example for integration with BFO via REST delivery endpoint method. [Eclipse Jetty](https://www.eclipse.org/jetty/) servlet container implementation is used.
  * java classes (`dk/kombit/restdelivery/`):
    * `RestDeliveryApp.java` - main class for receiving message (Modtag besked)
    * `/config` package contains classes responsible for configuring secure connection
    * `/connectors` package contains class responsible for creating server connectors and verify host certificate
    * `/exceptions` package contains custom exception classes
    * `/marshaller` package contains class responsible for marshalling
    * `/servlets` package contains class responsible for Jetty Servlet implementation
    * `/unmarshaller` package contains class responsible for unmarshalling
    * `/utils` package contains helper class
  * `resources/`:
    * `beskedfordeler` folder contains XSD files that defines schema for communication with BFO ([see chapter 5](#5-code-generation-from-xsd-files))
    * `certs` folder contains certificates required by code examples
    * `test` folder contains example BFO message 
    * `application.properties` - main config file for **restdelivery-example-app**
    * `logback.xml` - logback file (set up logging level there)

Config files must be edited before you run code examples. Please edit the section between the **BEGIN for edit** and **END for edit** marks with appropriate parameters.
Please notice, that for the 'send message to BFO via AMQP (Afsend)' example, the `safewhere.token.request.applysTo` parameter must be
different than for the 'receive message from BFO via AMQP (Afhent)' example - details in [chapter 4](#4-how-to-build-and-run-code-examples).

## 4. How to build and run code examples

#### 4.1 Building process (general information)
To build final executable jars, [Maven](https://maven.apache.org/) build automation tool is used. So as not to force user to install Maven locally, [Maven Wrapper](https://maven.apache.org/wrapper/) tool is included within code examples.  
During the building process, auto generation from XSD files to java classes take place ([see chapter 5](#5-code-generation-from-xsd-files)).
**Disclaimer:** When it comes to the application.properties, password handling falls upon the implementer and the properties set in the code examples are for demonstration purposes only.

#### 4.2 Receiving messages from BFO via AMQP - Afhent example (build and run)
In order to receive messages from BFO via AMQP the following steps must be performed:
1. Navigate to the bf-client-example-app java project
2. Edit `application.properties` file from `resources` folder with appropriate parameters
    1. Please notice that `safewhere.token.request.applysTo` parameter must be set to the following:  
       `safewhere.token.request.applysTo=http://<bfo_hostname>/service/afhent/1` replace the \<bfo_hostname\> placeholder with the BFO hostname that you are aiming to connect.
3. Generate executable jar file by running the following command for Windows:  
   `.\mvnw clean package`  
   and the following command for Unix systems  
   `./mvnw clean package`  
   Generated executables can be found in `target/jars` folder.
4. Run <code>java -jar .\target\jars\afhentbesked-client-1.0.jar</code>.
**Disclaimer:** The included code example receives messages from a static Dueslag which is shared amongst all instances of the code samples. If multiple systems run these code examples at the same time, even if you put a message in the Dueslag in order to try and retrieve it another system might receive retrieve it before you do. If you believe you are having this issue, we recommend that you follow the [Kom godt i gang](https://digitaliseringskataloget.dk/kom-godt-i-gang-vejledninger) guide on how to set up a service agreement and your own dueslag, and edit `application.properties` accordingly.

#### 4.3 Sending messages to BFO via AMQP - Afsend example (build and run)
In order to send messages to BFO via AMQP the following steps must be performed:
1. Navigate to the bf-client-example-app java project
2. Edit `application.properties` file from `resources` folder with appropriate parameters
3. Please notice, that `safewhere.token.request.applysTo` parameter must be set as following:  
   `safewhere.token.request.applysTo=http://<bfo_hostname>/service/afsend/1` replace the \<bfo_hostname\> placeholder with the BFO hostname that you are aiming to connect. \<bfo_hostname\> must be set to **eksterntest-stoettesystemerne** for the code examples to work.
4. Generate executable jar file by running the following command for Windows:  
   `.\mvnw clean package`  
   and the following command for Unix systems  
   `./mvnw clean package`.  
   Generated executables can be found in `target/jars` folder.
5. Run <code>java -jar .\target\jars\afsendbesked-client-1.0.jar</code>.

#### 4.4 Receiving messages from BFO via push REST service - Modtag example (build and run)
This code example does not interact with the real BFO in any way, it is only an example of how BFO expects an endpoint to be set up.
This code example shows what a message from BFO looks like when the endpoint receives it, and it shows what the endpoint
responds with to let BFO know that the message was successfully received. The endpoint in this code example is also capable of doing
a 2-way TLS handshake if the sender of the message connects to port 443 instead of the default 9044, but TLS requires certificates
custom to your instance for it to work and therefore does not work out of the box. The code can still be inspected to see how the handshake is performed. Which port is exposed is configured in `application.properties` and only one port can be exposed at a time.
**Disclaimer:** Port 9044 must NEVER be exposed in a production environment. BF only allows secure communication on port 443.
In order to run a local endpoint and send an example message to it, the following steps must be performed:
1. Navigate to the restdelivery-example-app java project
2. Edit `application.properties` file from `resources` folder with appropriate parameters
3. Generate executable jar file by running the following command for Windows:  
   `.\mvnw clean package`  
   and the following command for Unix systems  
   `./mvnw clean package`.  
   Generated executables can be found in `target` folder.
4. Run <code>java -jar .\target\restdelivery-example-app-1.0.jar</code>.
5. Restdelivery-example-app can expose a `/push` endpoint on the following ports:
      * port `443` for secure connection via TLS/SSL - use only when you have correct certificates registered
      * port `9044` for unsecure connection - can be used for demonstration purposes without any certificate with the following cUrl request (go to the `resources/test` folder and type):  
           `curl -d "@message.xml" -H "Content-Type: text/xml;charset=UTF-8" -X POST http://localhost:9044/push`  
      then press enter. Example message recived from BFO and acknowledge message fo BFO can be found in restdelivery-example-app logs 

#### 4.5 Integration with web services in BFO via SOAP - Vaerdiliste CRUD operations example (build and run)
In order to test web services in BFO via SOAP the following steps must be performed:
1. Navigate to the bf-client-example-app java project
2. Edit `application.properties` file from `resources` folder with appropriate parameters
3. Please notice, that `safewhere.token.request.applysTo` parameter must be set as following:  
   `safewhere.token.request.applysTo=http://<bfo_hostname>/service/afhent/1` fulfill placeholder with BFO hostname that you are aiming to connect. \<bfo_hostname\> must be set to **eksterntest-stoettesystemerne** for the code examples to work.
4. Generate executable jar file by running the following command for Windows:  
   `.\mvnw clean package`
   and the following command for Unix systems  
   `./mvnw clean package`.
   Generated executables can be found in `target/jars` folder.
5. Run <code>java -jar .\target\jars\soap-client-1.0.jar</code>.
6. Run the desired service according to the description displayed in the console.

## 5. Code generation from XSD files

The project contains code which is autogenerated from the service XSD files.  
The latest files are included in this package but also are available in at Digitaliseringskataloget in [SF1461 Modtag beskeder via Beskedfordeler]( https://docs.kombit.dk/integration/sf1461) or [SF1462 Afsend beskeder via Beskedfordeler](https://docs.kombit.dk/integration/sf1462). Please always use updated XSD files in your production code.  
Auto generation takes place during building process ([see chapter 4](#41-building-process-general-information)) via [CXF XJC Maven Plugin](https://cxf.apache.org/cxf-xjc-plugin.html)
and can be triggered by the maven build command `mvnw clean package`.  
Generated classes can be found in the `target/generated-sources/cxf` folder
and are automatically added to the final executable jar file.

## 6. Additional information

#### 6.1 WSDL for CXF Security Token Service
Web service definition for CXF Security Token Service communication can be found under <code>https://<adgangsstyring_host_name>/runtime/services/kombittrust/mex?singleWsdl</code>, but the one included in these code examples should not be changed as it is a more specific service definition satisfying oio requirements.
Nevertheless, token signing service certificate can be found there under X509Certificate section.

#### 6.2 Additional documentation
Additional information (e.g. how to set up a **Serviceaftale** for the **Modtag** service) can be fount in the [**Kom godt i gang - Fælleskommunal Beskedfordeler**](https://docs.kombit.dk/latest/ba48e791) document.