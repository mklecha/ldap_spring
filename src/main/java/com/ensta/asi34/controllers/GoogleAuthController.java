package com.ensta.asi34.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import javax.management.Notification;
import com.vaadin.ui.Notification.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import com.ensta.asi34.model.User;
import com.ensta.asi34.model.repository.PersonRepository;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

import fi.jasoft.qrcode.QRCode;

@Controller
public class GoogleAuthController {
	
	    @Autowired 
	    PersonRepository repository;
	    
	    private final GoogleAuthenticator gAuth = new GoogleAuthenticator();
	    
	    @GetMapping("/success")
	    public String success() {
	    	// Generate secret key, display as QR code and as a plaintext link
	        final GoogleAuthenticatorKey key = gAuth.createCredentials();

	        // make the URI
	        String keyUri = "";
	        try {
	            keyUri = generateKeyUri("jesusm.sanchez93@gmail.com", "ENSTA",
	                    key.getKey());
	        } catch (URISyntaxException e) {
	            System.out.println("Error");
	        }
	        
	     // generate QR code
	        final QRCode qr = new QRCode();
	        qr.setValue(keyUri);
	        qr.setWidth("140px");
	        qr.setHeight("140px");
	        setupLayout.addComponent(qr);

	        // add a key in plain text, as clickable link
	        final Label text = new Label(
	                "Scan the QR code or enter shared key manually into your app. "
	                        + "<h1><a href=\"" + keyUri + "\">" + key.getKey()
	                        + "</a></h1>"
	                        + "Then try the generated password below:",
	                ContentMode.HTML);
	        setupLayout.addComponent(text);
	        setupLayout.setComponentAlignment(text, Alignment.MIDDLE_CENTER);

	        return "success";
	    }
	    
	    /**
	     * Generates a URI that Google Authenticator and most TOTP apps can read
	     * when displayed as a QR code.
	     * <p>
	     * The format is:
	     * otpauth://totp/[ISSUER]:[ACCOUNT]?secret=[SECRET]&issuer=[ISSUER]
	     * </p>
	     * 
	     * @see https://code.google.com/p/google-authenticator/wiki/KeyUriFormat
	     * 
	     * @param account
	     *            account/username
	     * @param issuer
	     *            the provider or service this account is associated with
	     * @param secret
	     *            shared secret key
	     * @return URI string
	     * @throws URISyntaxException
	     */
	    private static String generateKeyUri(String account, String issuer,
	            String secret) throws URISyntaxException {

	        URI uri = new URI("otpauth", "totp", "/" + issuer + ":" + account,
	                "secret=" + secret + "&issuer=" + issuer, null);

	        return uri.toASCIIString();
	    }

}
