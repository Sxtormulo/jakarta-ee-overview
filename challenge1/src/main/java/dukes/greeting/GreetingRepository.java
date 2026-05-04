package dukes.greeting;

// Give the repository an appropriate CDI scope. Hint: You can also use the pseudo-scope @Dependent
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.metamodel.EntityType;

import module java.base;
import java.lang.System.Logger;

import static java.lang.System.Logger.Level.INFO;

public class GreetingRepository
{

    private static final Logger LOG =
        System.getLogger(GreetingRepository.class.getName());

    /**
     * Helpful documentation:
     * https://jakarta.ee/specifications/platform/10/apidocs/jakarta/persistence/entitymanager
     */
    @PersistenceContext(unitName = "Greetings")
    private EntityManager em;
    // Create a method that retrieves all greetings from the database. Return type should be List<Greeting>

    // Hint: Check out the Criteria Language for building queries
    // CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
    // cq.select(cq.from(Greeting.class));
    // return em.createQuery(cq).getResultList();
    /**
     * Get all Greetings from the persistence provider
     *
     * @return the greetings in the persistence
     */
    public List<Greeting> findAll()
    {
        LOG.log(INFO, "Getting all Greetigs");
        final var criteriaBuilder = em.getCriteriaBuilder();
        final var greetingQuery = criteriaBuilder.createQuery(Greeting.class);
        final EntityType<Greeting> Greeting_ = em.getMetamodel().entity(Greeting.class);
        greetingQuery.select(greetingQuery.from(Greeting_));
        return em.createQuery(greetingQuery).getResultList();

    }
}
