/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.utils.spring.client;

import com.jhw.utils.services.ConverterService;
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

    public static <T> List<T> getForList(RestTemplate template, String url, Class<T> clazz) throws Exception {
        return getForList(template, url, new HashMap<>(), clazz);
    }

    public static <T> List<T> getForList(RestTemplate template, String url, Map<String, Object> uriVariables, Class<T> clazz) throws Exception {
        return objectForList(template, url, HttpMethod.GET, uriVariables, clazz);
    }

    public static <T> List<T> postForList(RestTemplate template, String url, Class<T> clazz) throws Exception {
        return postForList(template, url, new HashMap<>(), clazz);
    }

    public static <T> List<T> postForList(RestTemplate template, String url, Map<String, Object> uriVariables, Class<T> clazz) throws Exception {
        return objectForList(template, url, HttpMethod.POST, uriVariables, clazz);
    }

    public static <T> List<T> objectForList(RestTemplate template, String url, HttpMethod method, Map<String, Object> uriVariables, Class<T> clazz) throws Exception {
        ParameterizedTypeReference<List<T>> type = new ParameterizedTypeReference<List<T>>() {
        };
        ResponseEntity<List<T>> response = template.exchange(url, method, null, type, uriVariables);

        //como es tipo <T> lo que lee es linkedHashMap, hay que castearlo de nuevo al objeto como tal
        return ConverterService.convert(response.getBody(), clazz);
    }
}
