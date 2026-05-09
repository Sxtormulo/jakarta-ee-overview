package dukes.greeting;

import jakarta.enterprise.context.RequestScoped;
import java.time.LocalDate;

/** Greeting Service that process Greeting Records */
@RequestScoped
public class GreetingService
{

    public GreetingRecord generateGreeting()
    {
        return new GreetingRecord("Saluton!", LocalDate.now());
    }

}
