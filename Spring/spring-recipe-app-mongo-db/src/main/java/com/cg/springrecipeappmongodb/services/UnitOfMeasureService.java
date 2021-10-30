package com.cg.springrecipeappmongodb.services;


import com.cg.springrecipeappmongodb.commands.UnitOfMeasureCommand;
import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
