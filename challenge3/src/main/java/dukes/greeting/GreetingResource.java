package dukes.greeting;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/** Restful resource to get {@code GreetingRecord} */
@RequestScoped
@Path("greeting")
public class GreetingResource
{

    @Inject
    private GreetingService greetingService;

    /**
     * Returns a {@code GreetingRecord}
     *
     * @return a Greeting in json form
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GreetingRecord getGreeting()
    {
        return greetingService.generateGreeting();
    }

}
