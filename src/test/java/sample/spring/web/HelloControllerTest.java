package sample.spring.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.spring.model.Person;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HelloControllerTest {

    @Autowired
    private HelloController controller;

    @Test
    public void shouldList(){
        List<Person> list = controller.hello();
        assertEquals(1,list.size());
    }

}
