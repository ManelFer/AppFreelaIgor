package main.java.back.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;
    public void saveForm(Form form) {
        if (form.getEmail().contains("@")){
            repository.save(form);
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }
}
