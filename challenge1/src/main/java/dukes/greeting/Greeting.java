package dukes.greeting;

// Make Greeting a Jakarta Persistence Entity that is not Cacheable
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import module java.base;

/**
 * Greeting class that contains a greeting message
 *
 * @author Sxtormulo
 */
@Cacheable(value = false)
@Entity
@Table(name = "greeting")
public class Greeting
{

    @Id
    @GeneratedValue()
    private UUID id;

    private String message;

    /** Default constuctor for use with the JPA */
    public Greeting()
    {
    }

    /**
     * Construct a new greeting
     *
     * @param message the message of the greeting
     */
    public Greeting(String message)
    {
        this.message = message;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        final Greeting other = (Greeting) obj;
        if(!Objects.equals(this.message, other.getMessage())) return false;
        return Objects.equals(this.id, other.getId());
    }

    /**
     * Get the id of the current instance
     *
     * @return the current id
     */
    public UUID getId()
    {
        return id;
    }

    /**
     * Set a new id for the instance
     *
     * @param id the new id
     */
    public void setId(UUID id)
    {
        this.id = id;
    }

    /**
     * Get the message of the current instance
     *
     * @return the current message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Set a new message for the current instance
     *
     * @param message the new message
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public String toString()
    {
        return "Greeting{" + "id=" + id + ", message=" + message + '}';
    }

}
