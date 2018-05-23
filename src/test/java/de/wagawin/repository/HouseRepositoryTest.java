package de.wagawin.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseRepositoryTest {

    @Autowired
    HouseRepository repository;

    @Test
    public void getById() throws Exception {
        assertEquals("address1", repository.getById(1).getAddress());
    }
}