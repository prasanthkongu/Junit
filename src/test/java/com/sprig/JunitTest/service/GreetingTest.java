package com.sprig.JunitTest.service;

import com.sprig.JunitTest.AbstractTest;
import com.sprig.JunitTest.model.Greeting;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GreetingTest extends AbstractTest {
    
    @Autowired
    private GreetingService service;
    
    @Test
    public void testFindAll() {
        Collection<Greeting> list = service.findAll();
        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertEquals("failure - expected size", 2, list.size());
    }
}
