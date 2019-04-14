package hello.hello.request;

import java.io.Serializable;
import java.util.HashMap;

public class PersonRequest extends HashMap<String, String> implements Serializable {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return this.get("firstName");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
