package facades;

import entities.Location;
import entities.Match;
import entities.Role;
import entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserFacadeTest {

    private static EntityManagerFactory emf;
    private static UserFacade facade;

    public UserFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = UserFacade.getUserFacade(emf);
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("roles.deleteAllRows").executeUpdate();
            em.createNamedQuery("users.deleteAllRows").executeUpdate();
            em.getTransaction().commit();

            em.getTransaction().begin();
            Role userRole = new Role("user");
            Role adminRole = new Role("admin");
            User user = new User("user", "test");
            user.addRole(userRole);
            User admin = new User("admin", "test");
            admin.addRole(adminRole);
            User both = new User("user_admin", "test");
            both.addRole(userRole);
            both.addRole(adminRole);


            em.persist(userRole);
            em.persist(adminRole);
            em.persist(user);
            em.persist(admin);
            em.persist(both);


            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /*
    This tests the function adds a user to our database
    the function being tested is in src\test\java\facades\UserFacadeTest.java
    */
    @Test
    void signUpTest() {
        User actual = facade.signUp("testing", "testingThis");
        User expected = new User("testing", "testingThis");
        assertEquals(actual.getUserName(), expected.getUserName());
    }

/*
    This tests the function adds a user to our database when it is given wrong info
    the function being tested is in src\test\java\facades\UserFacadeTest.java
    */
    @Test
    void signUpTestFail() {
        User actual = facade.signUp("testinghihi", "testingThis");
        User expected = new User("testing", "testingThis");
        assertNotEquals(actual.getUserName(), expected.getUserName());
    }

    /*
   This tests the function that gets all the users in our database
   the function being tested is in src\test\java\facades\UserFacadeTest.java
   */
    @Test
    void seeAllUsers() {
        int actual = facade.seeAllUsers().size();
        int expected = 3;
        assertEquals(actual, expected);
    }

}