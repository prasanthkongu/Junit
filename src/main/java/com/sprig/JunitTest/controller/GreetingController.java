package com.sprig.JunitTest.controller;

import com.sprig.JunitTest.model.Greeting;
import com.sprig.JunitTest.service.GreetingService;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author prasanth.s
 */

@RestController
public class GreetingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * The GreetingService business service.
     */
    @Autowired
    private GreetingService greetingService;

    /**
     * Web service endpoint to fetch all Greeting entities. The service returns
     * the collection of Greeting entities as JSON.
     * 
     * @return A ResponseEntity containing a Collection of Greeting objects.
     */
    @RequestMapping(
            value = "/api/greetings",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @SuppressWarnings("Convert2Diamond")
    public ResponseEntity<Collection<Greeting>> getGreetings() {
        logger.info("> getGreetings");

        Collection<Greeting> greetings = greetingService.findAll();

        logger.info("< getGreetings");
        return new ResponseEntity<Collection<Greeting>>(greetings,
                HttpStatus.OK);
    }

    /**
     * Web service endpoint to fetch a single Greeting entity by primary key
     * identifier.
     * 
     * If found, the Greeting is returned as JSON with HTTP status 200.
     * 
     * If not found, the service returns an empty response body with HTTP status
     * 404.
     * 
     * @param id A Long URL path variable containing the Greeting primary key
     *        identifier.
     * @return A ResponseEntity containing a single Greeting object, if found,
     *         and a HTTP status code as described in the method comment.
     */
    @RequestMapping(
            value = "/api/greetings/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> getGreeting(@PathVariable("id") Long id) {
        logger.info("> getGreeting id:{}", id);

        Greeting greeting = greetingService.findOne(id);
        if (greeting == null) {
            return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
        }

        logger.info("< getGreeting id:{}", id);
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }

    /**
     * Web service endpoint to create a single Greeting entity. The HTTP request
     * body is expected to contain a Greeting object in JSON format. The
     * Greeting is persisted in the data repository.
     * 
     * If created successfully, the persisted Greeting is returned as JSON with
     * HTTP status 201.
     * 
     * If not created successfully, the service returns an empty response body
     * with HTTP status 500.
     * 
     * @param greeting The Greeting object to be created.
     * @return A ResponseEntity containing a single Greeting object, if created
     *         successfully, and a HTTP status code as described in the method
     *         comment.
     */
    @RequestMapping(
            value = "/api/greetings",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> createGreeting(
            @RequestBody Greeting greeting) {
        logger.info("> createGreeting");

        Greeting savedGreeting = greetingService.create(greeting);

        logger.info("< createGreeting");
        return new ResponseEntity<Greeting>(savedGreeting, HttpStatus.CREATED);
    }

    /**
     * Web service endpoint to update a single Greeting entity. The HTTP request
     * body is expected to contain a Greeting object in JSON format. The
     * Greeting is updated in the data repository.
     * 
     * If updated successfully, the persisted Greeting is returned as JSON with
     * HTTP status 200.
     * 
     * If not found, the service returns an empty response body and HTTP status
     * 404.
     * 
     * If not updated successfully, the service returns an empty response body
     * with HTTP status 500.
     * 
     * @param greeting The Greeting object to be updated.
     * @return A ResponseEntity containing a single Greeting object, if updated
     *         successfully, and a HTTP status code as described in the method
     *         comment.
     */
    @RequestMapping(
            value = "/api/greetings/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> updateGreeting(
            @RequestBody Greeting greeting) {
        logger.info("> updateGreeting id:{}", greeting.getId());

        Greeting updatedGreeting = greetingService.update(greeting);
        if (updatedGreeting == null) {
            return new ResponseEntity<Greeting>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("< updateGreeting id:{}", greeting.getId());
        return new ResponseEntity<Greeting>(updatedGreeting, HttpStatus.OK);
    }

    /**
     * Web service endpoint to delete a single Greeting entity. The HTTP request
     * body is empty. The primary key identifier of the Greeting to be deleted
     * is supplied in the URL as a path variable.
     * 
     * If deleted successfully, the service returns an empty response body with
     * HTTP status 204.
     * 
     * If not deleted successfully, the service returns an empty response body
     * with HTTP status 500.
     * 
     * @param id A Long URL path variable containing the Greeting primary key
     *        identifier.
     * @param greeting The Greeting object to be deleted. (optional)
     * @return A ResponseEntity with an empty response body and a HTTP status
     *         code as described in the method comment.
     */
    @RequestMapping(
            value = "/api/greetings/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") Long id,
            @RequestBody Greeting greeting) {
        logger.info("> deleteGreeting id:{}", id);

        greetingService.delete(id);

        logger.info("< deleteGreeting id:{}", id);
        return new ResponseEntity<Greeting>(HttpStatus.NO_CONTENT);
    }
}
