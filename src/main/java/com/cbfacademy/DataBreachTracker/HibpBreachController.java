package com.cbfacademy.DataBreachTracker;

import java.io.IOException;
import java.net.HttpURLConnection; 
import java.net.URI; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController// will handle HTTP requests and return JSON responses
public class HibpBreachController {

    // Endpoint to fetch breaches from Have I Been Pwned API
    // ⚠️ Note: HIBP expects a full domain name (e.g., "tesco.com", not just "tesco")
    // This design avoids handling personal data like emails, improving security
    
    @GetMapping(value = "/api/hibp-breaches/{org}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBreaches(@PathVariable String org) throws IOException {

        // Build the URI and convert to connection
        URI uri = URI.create("https://haveibeenpwned.com/api/v3/breaches?domain=" + org);
        HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
        conn.setRequestProperty("User-Agent", "Java-HIBP"); // Required by HIBP

        // Return the response body as JSON
        return new String(conn.getInputStream().readAllBytes());
    }
}




