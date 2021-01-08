/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.utils.spring.server;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RESTUrlConstants {

    public static final String CREATE_PATH = "/create";
    public static final RequestMethod CREATE_METHOD = RequestMethod.POST;

    public static final String CREATE_PATH_LIGHTWEIGHT = "/create_light";
    public static final RequestMethod CREATE_LIGHTWEIGHT_METHOD = RequestMethod.PUT;

    public static final String EDIT_PATH = "/edit";
    public static final RequestMethod EDIT_METHOD = RequestMethod.POST;

    public static final String EDIT_PATH_LIGHTWEIGHT = "/edit_light";
    public static final RequestMethod EDIT_LIGHTWEIGHT_METHOD = RequestMethod.PUT;

    public static final String DESTROY_PATH = "/destroy";
    public static final RequestMethod DESTROY_METHOD = RequestMethod.POST;

    @Deprecated
    public static final String DESTROY_PATH_LIGHTWEIGHT = "/destroy_light";
    @Deprecated
    public static final RequestMethod DESTROY_LIGHTWEIGHT_METHOD = RequestMethod.DELETE;

    public static final String DESTROY_ID_PATH = "/destroy_id";
    public static final RequestMethod DESTROY_ID_METHOD = RequestMethod.POST;

    @Deprecated
    public static final String DESTROY_ID_LIGHTWEIGHT_PATH = "/destroy_id";
    @Deprecated
    public static final RequestMethod DESTROY_ID_LIGHTWEIGHT_METHOD = RequestMethod.DELETE;

    public static final String FIND_ALL_PATH = "/find_all";
    public static final RequestMethod DFIND_ALL_METHOD = RequestMethod.GET;

    public static final String ID = "id";
    public static final String FIND_BY_PATH = "/find_by/{" + ID + "}";
    public static final RequestMethod FIND_BY_METHOD = RequestMethod.GET;

    public static final String COUNT_PATH = "/count";
    public static final RequestMethod COUNT_METHOD = RequestMethod.GET;
}
