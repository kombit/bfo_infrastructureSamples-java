package dk.kombit.restdelivery.servlets;

import java.io.IOException;
import java.math.BigInteger;

import dk.kombit.bf.beskedkuvert.HaendelsesbeskedType;
import dk.kombit.restdelivery.marshaller.ModtagBeskedInputTypeMarshaller;
import oio.sagdok._3_0.StandardReturType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServlet;
import oio.sts._1_0.ModtagBeskedInputType;
import oio.sts._1_0.ModtagBeskedOutputType;

import dk.kombit.restdelivery.marshaller.ModtagBeskedOutputTypeMarshaller;
import dk.kombit.restdelivery.unmarshaller.ModtagBeskedInputTypeUnmarshaller;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Handles message reception.
 */
public class MessageReceivingServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(MessageReceivingServlet.class);

    private ModtagBeskedInputTypeUnmarshaller modtagBeskedInputTypeMarshaller = new ModtagBeskedInputTypeUnmarshaller();

    @Override
    protected void doPost(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {

        log.info("Message reception request received.");

        String message = IOUtils.toString(request.getReader());

        if(message == null) {
            log.info("Not able to read message. Message seems to be empty.");
            response.setContentType("text/html; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getOutputStream().println("Not able to read message. Message seems to be empty.");
            return;
        }

        ModtagBeskedInputType modtagBeskedInput;
        try {
            modtagBeskedInput = modtagBeskedInputTypeMarshaller.getObject(message);
        } catch (Exception e) {
            ModtagBeskedOutputType modtagBeskedOutput = new ModtagBeskedOutputType();
            StandardReturType standardRetur = new StandardReturType();
            standardRetur.setStatusKode(BigInteger.valueOf(41));
            standardRetur.setFejlbeskedTekst("Couldn't parse message");
            modtagBeskedOutput.setStandardRetur(standardRetur);
            response.setStatus(HttpServletResponse.SC_OK);

            byte[] modtagBeskedOutputTypeBytes = ModtagBeskedOutputTypeMarshaller.marshal(modtagBeskedOutput);

            response.getWriter().write(StringUtils.newStringUtf8(modtagBeskedOutputTypeBytes));
            return;
        }

        HaendelsesbeskedType haendelsesbesked = modtagBeskedInput.getHaendelsesbesked();

        String beskedId = haendelsesbesked.getBeskedId().getUUIDIdentifikator();

        byte[] modtagBeskedInputTypeBytes = ModtagBeskedInputTypeMarshaller.marshal(modtagBeskedInput);
        log.info("=============================================================");
        log.info("Message received from BFO:");
        log.info(StringUtils.newStringUtf8(modtagBeskedInputTypeBytes));

        if(beskedId == null) {
            log.info("Message doesn't contain beskedId.");
            response.setContentType("text/html; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getOutputStream().println("Message doesn't contain beskedId.");
            return;
        }

        int port = request.getLocalPort();

        log.debug("BeskedId: {} port: {}", beskedId, port);

        ModtagBeskedOutputType modtagBeskedOutput = new ModtagBeskedOutputType();
        StandardReturType standardRetur = new StandardReturType();
        standardRetur.setStatusKode(BigInteger.valueOf(20));
        standardRetur.setFejlbeskedTekst("");
        modtagBeskedOutput.setStandardRetur(standardRetur);
        response.setStatus(HttpServletResponse.SC_OK);

        byte[] modtagBeskedOutputTypeBytes = ModtagBeskedOutputTypeMarshaller.marshal(modtagBeskedOutput);

        response.getWriter().write(StringUtils.newStringUtf8(modtagBeskedOutputTypeBytes));

        log.info("=============================================================");
        log.info("Message send to BFO:");
        log.info(StringUtils.newStringUtf8(modtagBeskedOutputTypeBytes));
    }
}
