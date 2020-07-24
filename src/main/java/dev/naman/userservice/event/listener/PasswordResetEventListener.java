package dev.naman.userservice.event.listener;

import dev.naman.userservice.event.PasswordResetEvent;
import dev.naman.userservice.model.PasswordResetToken;
import dev.naman.userservice.model.User;
import dev.naman.userservice.repository.PasswordResetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PasswordResetEventListener implements ApplicationListener<PasswordResetEvent> {

    @Autowired
    PasswordResetRepository passwordResetRepository;

    @Override
    public void onApplicationEvent(PasswordResetEvent passwordResetEvent) {

        User registeredUser= passwordResetEvent.getRegisteredUser();

        PasswordResetToken passwordResetToken = new PasswordResetToken(registeredUser);

        passwordResetRepository.save(passwordResetToken);

    }
}
