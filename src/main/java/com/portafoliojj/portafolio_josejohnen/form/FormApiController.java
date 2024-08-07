package com.portafoliojj.portafolio_josejohnen.form;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/forms")
public class FormApiController {

    //@Autowired //Field Injection, not recommended but possible, commented because of that
    private final FormRepository formRepository;

    public FormApiController(FormRepository formRepository){
        this.formRepository = formRepository;
    }

    @GetMapping("")
    List<Form> GetForms()
    {
        return formRepository.findAll();
    }

    @GetMapping("/{id}")
    Form GetForm(@PathVariable Integer id)
    {
        Optional<Form> form = formRepository.findById(id);

        if(form.isEmpty())
        {
            throw  new FormNotFoundException();
        }

        return form.get();
    }

    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void PostForm(@Valid @RequestBody Form form)
    {
        formRepository.create(form);
    }

    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void PutForm(@Valid @RequestBody Form form, @PathVariable Integer id)
    {
        formRepository.update(form, id);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void DeleteForm(@PathVariable  Integer id)
    {
        System.out.println(id);
        formRepository.delete(id);
    }
}
