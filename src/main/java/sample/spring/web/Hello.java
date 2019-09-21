package sample.spring.web;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sample.spring.model.Person;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebServlet("/hello")
public class Hello extends HttpServlet {

    @PersistenceUnit(unitName = "sample-spring-pu")
    private EntityManagerFactory factory;

    private EntityManager em;

    @PostConstruct
    public void init(){
        em = factory.createEntityManager();
    }

    @Transactional
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(em.createQuery("select p from Person", Person.class));
        resp.getWriter().write("oy!");
    }
}
