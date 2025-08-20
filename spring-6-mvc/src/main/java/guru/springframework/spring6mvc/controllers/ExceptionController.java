package guru.springframework.spring6mvc.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
//@Slf4j
//public class ExceptionController {
//    @ExceptionHandler({NotFoundException.class})
//    public ResponseEntity handleNotFoundException() {
//        log.debug("in exception handler");
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
//}
