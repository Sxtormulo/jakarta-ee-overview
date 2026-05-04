package dukes.greeting;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import module java.base;
import java.lang.System.Logger;

import static java.lang.System.Logger.Level.WARNING;

@Stateless
public class GreetingService
{

    @Inject
    private GreetingRepository greetingRepository;

    /**
     * Get a Greeting instance
     *
     * @return the first Greeting find
     */
    public Greeting findFirstGreeting()
    {

        try
        {
            return greetingRepository.findAll().getFirst();
        }
        catch(NoSuchElementException elementException)
        {
            logger.log(WARNING, "No greeting found. Using default Greeting");
            return new Greeting("Hello, Wordl!");
        }
    }
    private static final Logger logger = System.getLogger(GreetingService.class
        .getName());

}
