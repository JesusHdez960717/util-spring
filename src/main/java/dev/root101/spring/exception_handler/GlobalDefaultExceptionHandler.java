/*
 * Copyright 2022 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.root101.spring.exception_handler;

import dev.root101.clean.core.exceptions.ApiException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 * @author jjhurtado@Github
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {Exception.class})
    protected ResponseEntity<Object> handleConflict(
            Exception ex, WebRequest request) throws Exception {

        //maneja la excepcion internamente, para que le llegue a alguien que se registro al servicio
        //posiblemente un modulo encargado de reportar todas las excepciones del sistema
        dev.root101.clean.core.app.services.ExceptionHandler.handleException(ex);

        //si la exception esta anotada con el ResponseStatus, Spring se encarga de convertirla
        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) {
            throw ex;
        }
        //si es una excepcion mia del core, la convierto al statud de ella
        if (ex instanceof ApiException apiException) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.valueOf(apiException.status().value()));
        }
        //si no, dejo que spring se encargue
        return super.handleException(ex, request);
        //si no la puedo procesar yo mismo como un 500. Por ahora dejar que Spring se encargue
        //return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
