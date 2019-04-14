package hello;

import java.util.concurrent.atomic.AtomicLong;

import hello.hello.request.PersonRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = GET, name = "/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(method = PUT, name = "/greeting")
    public Greeting greeting(@RequestBody PersonRequest person) {
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        return new Greeting(counter.incrementAndGet(),
                String.format(template, person.getFirstName()));
    }
}
