/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.utils.spring.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RestTemplateUtils {

    public static <T> List<T> getForList(RestTemplate template, String url, Class<T> clazz) {
        return getForList(template, url, new HashMap<>(), clazz);
    }

    public static <T> List<T> getForList(RestTemplate template, String url, Map<String, Object> uriVariables, Class<T> clazz) {
        ParameterizedTypeReference<List<T>> type = new ParameterizedTypeReference<List<T>>() {
        };
        ResponseEntity<List<T>> response = template.exchange(url, HttpMethod.GET, null, type, uriVariables);
        return response.getBody();
    }

    public static <T> List<T> postForList(RestTemplate template, String url, Class<T> clazz) {
        return postForList(template, url, new HashMap<>(), clazz);
    }

    public static <T> List<T> postForList(RestTemplate template, String url, Map<String, Object> uriVariables, Class<T> clazz) {
        ParameterizedTypeReference<List<T>> type = new ParameterizedTypeReference<List<T>>() {
        };
        ResponseEntity<List<T>> response = template.exchange(url, HttpMethod.POST, null, type, uriVariables);
        return response.getBody();
    }
}
