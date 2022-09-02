package com.library.app.registration.validation.email;

import com.library.app.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class EmailValidator implements Predicate<String> {
    
    @Autowired
    private final AccountRepository accountRepository;
    
    @Override
    public boolean test(String email) {
        Pattern pattern = Pattern.compile(
                "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]" +
                        "+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]" +
                        "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f]" +
                        ")*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?" +
                        "\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])" +
                        "?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]" +
                        "?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]" +
                        "?|[a-z0-9-]*[a-z0-9]:(?:" +
                        "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]" +
                        "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher matcher = pattern.matcher(email);
        
        return matcher.find();
    }
}