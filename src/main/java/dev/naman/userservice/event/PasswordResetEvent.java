package dev.naman.userservice.event;

import dev.naman.userservice.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class PasswordResetEvent extends ApplicationEvent {

    private final User registeredUser;


    public PasswordResetEvent(User registeredUser){
        super(registeredUser);
        this.registeredUser = registeredUser;
    }

}
