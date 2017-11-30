package com.sprig.JunitTest.Repository;

import com.sprig.JunitTest.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prasanth.s
 */
@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
