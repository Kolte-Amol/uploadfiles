/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ARATI-AMOL
 */
public class GetSpecificUser {
    
    public static void main(String args[]){
        
        try {
            
            
            final String uri = "http://localhost:8080/users/{userid}";
            
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            
            Map<String, Integer> params = new HashMap<String, Integer>();
            params.put("userid", id);
            
            System.out.println(uri);
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class, params);
            
            System.out.println(result);
        } catch (RestClientException ex) {
            System.out.println(""+ex);
        }
    }
}
