package com.guitar.handler;

import com.guitar.model.Manufacturer;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 * Created by tmac on 3/24/2017.
 */

@Component
@RepositoryEventHandler(Manufacturer.class)
public class ManufacturerEventHandler {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @HandleBeforeCreate
    public void handleBeforeCreate(Manufacturer m) {
        //do a check to see if the name is a valid manufacturer
        //...

        //auditing

        //only allow new manufacturers to be created in the active state.
        if(!m.getActive()) {
            throw new IllegalArgumentException("New Manufacturers must be 'active'");
        }
    }
}
