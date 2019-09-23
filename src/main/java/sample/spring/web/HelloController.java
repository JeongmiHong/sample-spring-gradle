package sample.spring.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sample.spring.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @PersistenceContext
    private EntityManager em;

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Person> hello() {
        Person p = new Person();
        p.setId(1l);
        p.setName("dave");
        List<Person>list = new ArrayList<>();
        list.add(p);
        return list;
//        return em.createQuery("select p from Person p", Person.class).getResultList();
    }
}
