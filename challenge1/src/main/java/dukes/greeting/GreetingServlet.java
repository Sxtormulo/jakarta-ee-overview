package dukes.greeting;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

/** Produce GreetingServel responses */
@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet
{

    private static final Logger logger = System.getLogger(GreetingServlet.class
        .getName());
    /** Greeting Enterprise Bean to get greetings */
    @EJB
    private GreetingService greetingService;

    /**
     * Serve a Get response with message
     *
     * @param req  the user request
     * @param resp the response message
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        try(var writer = resp.getWriter())
        {
            writer.println(greetingService.findFirstGreeting().getMessage());
        }
        catch(IOException ex)
        {
            logger.log(Level.ERROR, ex.getMessage(), ex);
        }
    }

}
