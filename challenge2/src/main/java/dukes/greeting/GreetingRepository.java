package dukes.greeting;

// Give the repository an appropriate CDI scope. Hint: You can also use the pseudo-scope @Dependent
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import static java.lang.System.Logger;
import static java.lang.System.Logger.Level.DEBUG;

import module java.base;

/** Greeting Entity Repository with CRUD methods */
@Dependent
public class GreetingRepository
{

    private static final Logger logger =
        System.getLogger(GreetingRepository.class.getName());

    @PersistenceContext(name = "Greetings")
    private EntityManager em;

    /**
     * Returns all {@link Greetings} in the persistence unit
     *
     * @return a list of greetings
     */
    public List<Greeting> findAll()
    {
        logger.log(DEBUG, "Getting All Greetings");
        final var greetingQuery =
            em.getCriteriaBuilder().createQuery(Greeting.class);
        greetingQuery.select(greetingQuery.from(Greeting.class));
        return em.createQuery(greetingQuery).getResultList();
    }

    /**
     * Save the {@link Greeting} instance to the persistence unit
     *
     * @param greeting the instance to be persisted
     * @return the successfully saved instance
     */
    public Greeting saveGreeting(Greeting greeting)
    {
        logger.log(DEBUG, "Persisting %s Greeting".formatted(greeting.getMessage()));
        em.persist(greeting);
        return greeting;
    }

}
