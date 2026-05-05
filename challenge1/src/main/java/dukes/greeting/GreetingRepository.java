package dukes.greeting;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import static java.lang.System.Logger;
import static java.lang.System.Logger.Level.DEBUG;

import module java.base;

/** Manage the interaction with the greeting repository that provide persistence */
@Dependent
public class GreetingRepository
{

    private static final Logger LOG =
        System.getLogger(GreetingRepository.class.getName());

    /** Get the Greetings unit from the Persistence Provider */
    @PersistenceContext(unitName = "Greetings")
    private EntityManager em;

    /**
     * Get all Greetings from the persistence provider
     *
     * @return the greetings in the persistence
     */
    public List<Greeting> findAll()
    {
        LOG.log(DEBUG, "Getting all Greetigs");

        final var greetingQuery = em.getCriteriaBuilder().createQuery(Greeting.class);
        greetingQuery.select(greetingQuery.from(Greeting.class));
        return em.createQuery(greetingQuery).getResultList();

    }
}
