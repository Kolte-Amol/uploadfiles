/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ARATI-AMOL
 */
public class GetAllUsers {
    
    public static void main(String args[]){
        
        try {
            final String uri = "http://localhost:8080/users";
            
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            
            System.out.println(result);
        } catch (RestClientException ex) {
            System.out.println(""+ex);
        }
    }
}
