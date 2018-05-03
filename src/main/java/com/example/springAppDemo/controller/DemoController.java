
package com.example.springAppDemo.controller;

import com.example.springAppDemo.db.Student;
import com.example.springAppDemo.db.StudentRepository;
import com.example.springAppDemo.db.StudentStatus;
import com.example.springAppDemo.instrumentering.MyComponent;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@Timed
@Api(value="demo controller", description="Beskriver demo controller")
public class DemoController {



    // metrics
    private Counter counter = Metrics.counter("handler.calls", "uri", "/demo");
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MyComponent myComponent;

    @ResponseBody
    @RequestMapping(value = "/student/{userId}", method = GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fant student"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ApiOperation(value = "Finn student", response = Student.class)
    public Student getStudent(
            @PathVariable("userId") Long user
            ) {

        Long id= user;
        logger.info("Ser etter " + user);

        if (studentRepository.existsById(id)){

                    return (studentRepository.findById(id).get());
        }
        else
        {
            // not found
            //throw new HttpStatusCodeException(487);
            return null;

        }

    }

    @ResponseBody
    @RequestMapping(value = "/studente/{userId}", method = GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fant student"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ApiOperation(value = "Finn student entity", response = Student.class)
    public ResponseEntity<Student> getStudentEnt(
            @PathVariable("userId") Long user
    ) {

        var id= user;

        if (studentRepository.existsById(id)){

            return new ResponseEntity<Student>(studentRepository.findById(id).get(), HttpStatus.OK);
        }
        else
        {
            // not found
            return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
        }

    }







    @ResponseBody
    @RequestMapping(value = "/student/new/{name}", method = GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fant student"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ApiOperation(value = "Ny student", response = Student.class)
    public Student newStudent(
            @PathVariable("name") String navn
    ) {

        {
            Student s = new Student();
            s.setName(navn);
            s.setStatus(StudentStatus.NY);

            logger.info("Lager " + navn);


            return (studentRepository.save(s));
        }

    }


    @ResponseBody
    @RequestMapping(path = "/demo", method = GET, produces = "application/json")

    @ApiOperation(value = "demo - teller metric", response = String.class)
    public String demo() {

        counter.increment();

        myComponent.handleMessage("fra demo");

        return ("{}");

    }

}
