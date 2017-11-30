package com.sprig.JunitTest.service;

import com.sprig.JunitTest.model.Greeting;
import java.util.Collection;

/**
 *
 * @author prasanth.s
 */
public interface GreetingService { 
    
     /**
     * Find all Greeting entities.
     * @return A Collection of Greeting objects.
     */
    Collection<Greeting> findAll();

    /**
     * Find a single Greeting entity by primary key identifier.
     * @param id A Long primary key identifier.
     * @return A Greeting or <code>null</code> if none found.
     */
    Greeting findOne(Long id);

    /**
     * Persists a Greeting entity in the data store.
     * @param greeting A Greeting object to be persisted.
     * @return The persisted Greeting entity.
     */
    Greeting create(Greeting greeting);

    /**
     * Updates a previously persisted Greeting entity in the data store.
     * @param greeting A Greeting object to be updated.
     * @return The updated Greeting entity.
     */
    Greeting update(Greeting greeting);

    /**
     * Removes a previously persisted Greeting entity from the data store.
     * @param id A Long primary key identifier.
     */
    void delete(Long id);

}