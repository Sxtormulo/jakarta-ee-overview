package dukes.greeting;

// request scoped
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.lang.System.Logger;
import java.time.LocalDate;

import static java.lang.System.Logger.Level.INFO;

/** GreetingResources end points for {@code Greeting} entity */
@RequestScoped
@Path("/greeting")
public class GreetingResource
{

    private static final Logger logger = System.getLogger(GreetingResource.class
        .getName());

    @EJB
    private GreetingService greetingService;

    /**
     * Gets a Greeting record as a Json and save it to the db
     *
     * @param greetingRecord the record to persist
     * @return the persisted Greeting
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GreetingRecord createGreeting(GreetingRecord greetingRecord)
    {
        logger.log(INFO, "Creating greeting %s".formatted(greetingRecord.message()));
        try
        {
            var persistedGreeting = greetingService.persistGreeting(greetingRecord);
            return new GreetingRecord(persistedGreeting.getMessage(), LocalDate.now());
        }
        catch(IllegalArgumentException argumentException)
        {
            logger.log(INFO, "Error creating Greeting %s".formatted(greetingRecord
                       .message()));
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    /**
     * Returns a Persisted GreetingRecord. If note persisted record is find returns the
     * default record
     *
     * @return a greeting record
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GreetingRecord getGreetingRecord()
    {
        return greetingService.findFirstGreetingRecord();
    }

}
