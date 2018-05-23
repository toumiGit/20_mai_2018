package de.wagawin.factory;

import de.wagawin.view.ChildInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @Author toumi on 23.05.18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChildInfoFactoryTest {

    @Autowired
    ChildInfoFactory factory;

    @Test
    public void getChildInfo() throws Exception {
        ChildInfo childInfo = factory.getChildInfo(1);
        assertEquals( "person1", childInfo.getParent().getName());
        assertEquals( "meal favourite", childInfo.getFavouriteMeal().getName());

        childInfo = factory.getChildInfo(2);
        assertEquals( "person1", childInfo.getParent().getName());
        assertEquals( null, childInfo.getFavouriteMeal().getName());

    }
}