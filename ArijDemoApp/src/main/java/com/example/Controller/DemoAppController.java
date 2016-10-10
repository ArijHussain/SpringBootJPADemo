package com.example.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arij Hussain on 9/19/2016.
 */
@RestController
public class DemoAppController {

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = "application/json")
    public String getStarted(){
        return  "Application Started!!";
    }
}
