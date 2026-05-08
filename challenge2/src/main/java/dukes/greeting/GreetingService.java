package dukes.greeting;

// The GreetingService should be a Stateless session bean
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.LocalDate;

/** Provide a greeting service that manages greeting repository */
@Stateless
public class GreetingService
{

    private static final Logger logger = System.getLogger(GreetingService.class
        .getName());

    @Inject
    private GreetingRepository greetings;

    /**
     * Find a {@code Greeting} and map it to a {@code GreetingRecord}. If not record is
     * found return a generated default
     *
     * @return the GreetingRecord with current Date
     */
    public GreetingRecord findFirstGreetingRecord()
    {
        return greetings.findAll().stream()
            .findFirst()
            .map(g -> new GreetingRecord(g.getMessage(), LocalDate.now()))
            .orElseGet(() ->
            {
                logger.log(Level.DEBUG, "Returning default greeting");
                return new GreetingRecord("Hello, World!", LocalDate.now());
            });
    }

    /**
     * Persist a {@code GreetingRecord} with JPA
     *
     * @param greetingRecord a record to persist
     * @return a new Greeting that was persisted
     */
    public Greeting persistGreeting(GreetingRecord greetingRecord)
    {
        final var greeting = new Greeting(greetingRecord.message());
        return greetings.saveGreeting(greeting);
    }

}
