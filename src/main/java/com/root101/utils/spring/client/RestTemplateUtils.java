/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.utils.spring.client;

import com.root101.utils.services.ConverterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RestTemplateUtils {

    //----------------------------------- LIST -----------------------------------\\
    public static <T> List<T> getForList(RestOperations template, String url, Class<T> clazz) throws Exception {
        return getForList(template, url, new HashMap<>(), clazz);
    }

    public static <T> List<T> getForList(RestOperations template, String url, Map<String, Object> uriVariables, Class<T> clazz) throws Exception {
        return objectForList(template, url, HttpMethod.GET, uriVariables, clazz);
    }

    public static <T> List<T> postForList(RestOperations template, String url, Class<T> clazz) throws Exception {
        return postForList(template, url, new HashMap<>(), clazz);
    }

    public static <T> List<T> postForList(RestOperations template, String url, Map<String, Object> uriVariables, Class<T> clazz) throws Exception {
        return objectForList(template, url, HttpMethod.POST, uriVariables, clazz);
    }

    public static <T> List<T> objectForList(RestOperations template, String url, HttpMethod method, Map<String, Object> uriVariables, Class<T> clazz) throws Exception {
        ParameterizedTypeReference<List<T>> type = new ParameterizedTypeReference<List<T>>() {
        };
        ResponseEntity<List<T>> response = template.exchange(url, method, null, type, uriVariables);

        //como es tipo <T> lo que lee es linkedHashMap, hay que castearlo de nuevo al objeto como tal
        return ConverterService.convert(response.getBody(), clazz);
    }

    //----------------------------------- MAP -----------------------------------\\
    public static <V, K> Map<V, K> postForMap(RestOperations template, String url, Class<V> clazzV, Class<K> clazzK) throws Exception {
        return postForMap(template, url, new HashMap<>(), clazzV, clazzK);
    }

    public static <V, K> Map<V, K> postForMap(RestOperations template, String url, Map<String, Object> uriVariables, Class<V> clazzV, Class<K> clazzK) throws Exception {
        return objectForMap(template, url, HttpMethod.POST, uriVariables, clazzV, clazzK);
    }

    public static <V, K> Map<V, K> getForMap(RestOperations template, String url, Class<V> clazzV, Class<K> clazzK) throws Exception {
        return getForMap(template, url, new HashMap<>(), clazzV, clazzK);
    }

    public static <V, K> Map<V, K> getForMap(RestOperations template, String url, Map<String, Object> uriVariables, Class<V> clazzV, Class<K> clazzK) throws Exception {
        return objectForMap(template, url, HttpMethod.GET, uriVariables, clazzV, clazzK);
    }

    public static <V, K> Map<V, K> objectForMap(RestOperations template, String url, HttpMethod method, Map<String, Object> uriVariables, Class<V> clazzV, Class<K> clazzK) throws Exception {
        ParameterizedTypeReference<Map<V, K>> type = new ParameterizedTypeReference<Map<V, K>>() {
        };
        ResponseEntity<Map<V, K>> response = template.exchange(url, method, null, type, uriVariables);

        //como es tipo <T> lo que lee es linkedHashMap, hay que castearlo de nuevo al objeto como tal
        //return ConverterService.convert(response.getBody(), clazz);
        return response.getBody();
    }
}
