package com.rest.client;

import com.rest.domain.User;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by Bk93287 on 6/27/2017.
 */
public class DeleteUser {

    public static void main(String args[]){

        try {
            final String uri = "http://localhost:8080/users/deleteuser/{userid}";

            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            System.out.println(""+id);

            Map<String, Integer> params = new HashMap<String, Integer>();
            params.put("userid", id);

            System.out.println(uri);

            User user = new User(-1, "name", "profession");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            List<MediaType> mediaType = new ArrayList<>();
            mediaType.add(MediaType.APPLICATION_JSON);
            headers.setAccept(mediaType);

            HttpEntity<User> entity = new HttpEntity<User>(user ,headers);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity result = restTemplate.exchange(uri,HttpMethod.DELETE, entity, String.class, params);

            System.out.println(result);
        } catch (RestClientException ex) {
            System.out.println(""+ex);
        }
    }
}
