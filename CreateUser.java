/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.client;

import com.rest.domain.User;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ARATI-AMOL
 */
public class CreateUser {
    
    public static void main(String args[]){
        
        try {
            final String uri = "http://localhost:8080/users/createuser";
            
             Scanner sc = new Scanner(System.in);
             String name = sc.nextLine();
             System.out.println(name);
             String profession = sc.nextLine();
             System.out.println(profession);
             
             User user = new User(-1, name, profession);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            List<MediaType> mediaType = new ArrayList<>();
            mediaType.add(MediaType.APPLICATION_JSON);
            headers.setAccept(mediaType);

            HttpEntity<User> entity = new HttpEntity<User>(user ,headers);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            //   ResponseEntity result =  restTemplate.exchange(uri, HttpMethod.POST , entity, String.class);
            String result = restTemplate.postForObject(uri, entity, String.class);
            
            System.out.println(result);
        } catch (RestClientException ex) {
            System.out.println(""+ex);
        }
    }
}
