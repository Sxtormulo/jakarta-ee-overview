package dukes.greeting;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import module java.base;

/** Entity to save greetings with {@code Jakarta Persistence Api} */
@Cacheable(false)
@Entity
@Table(name = "greeting")
public class Greeting
{

    @Id
    @GeneratedValue
    private UUID id;
    private String message;

    /** Constructor to be used by JPA */
    public Greeting()
    {
    }

    /**
     * Construct a new instance with the provided message
     *
     * @param message a greeting
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
        if(!Objects.equals(this.message, other.message)) return false;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Returns the id that represents the object
     *
     * @return a unique value id
     */
    public UUID getId()
    {
        return id;
    }

    /**
     * Change the id of the instance
     *
     * @param id the new id
     */
    public void setId(UUID id)
    {
        this.id = id;
    }

    /**
     * Get the message of the instance
     *
     * @return a greeting
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Change the message of the instance
     *
     * @param message a new greeting
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Greeting{");
        sb.append("id=").append(id);
        sb.append(", message=").append(message);
        sb.append('}');
        return sb.toString();
    }

}
