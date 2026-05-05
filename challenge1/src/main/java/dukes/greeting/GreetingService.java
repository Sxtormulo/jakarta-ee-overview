package dukes.greeting;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.lang.System.Logger;

import static java.lang.System.Logger.Level.DEBUG;

/** Provide a greeting service that return a {@link Greeting} instance */
@Stateless
public class GreetingService
{

    private static final Logger logger = System.getLogger(GreetingService.class
        .getName());
    /** Get a {@code GreetingRepository} by CDI */
    @Inject
    private GreetingRepository greetingRepository;

    /**
     * Get a Greeting instance
     *
     * @return the first Greeting find
     */
    public Greeting findFirstGreeting()
    {
        return greetingRepository.findAll().stream().findFirst().orElseGet(() ->
        {
            logger.log(DEBUG, () -> "Returning default object");
            return new Greeting("Hello, world!");
        });
    }

}
