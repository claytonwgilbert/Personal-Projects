package com.cg.petpalace.formatters;

import com.cg.petpalace.model.PetType;
import com.cg.petpalace.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType object, Locale locale) {
        return null;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> petTypes = petTypeService.findAll();

        for (PetType pet : petTypes) {
            if (pet.getName().equalsIgnoreCase(text)) {
                return pet;
            }
        }
        throw new ParseException("Pet Type not found:" + text, 0);
    }


}
