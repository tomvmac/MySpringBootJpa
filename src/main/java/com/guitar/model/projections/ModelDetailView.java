package com.guitar.model.projections;

import com.guitar.model.Manufacturer;
import com.guitar.model.Model;
import com.guitar.model.ModelType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * Created by tmac on 3/23/2017.
 *
 * Virtual Projections
 */
@Projection(name="modelDetailView", types = {Model.class})
public interface ModelDetailView {

    // map name to Model.name
    @Value("#{target.name}")
    String getModelName();

    BigDecimal getPrice();

    // Virtual method to only get manufacturer name
  //  @Value("#{target.manufacturer.name}")
    @Value("#{target.manufacturer.name}")
    String getManufacturer();

    ModelType getModelType();
    int getFrets();
    String getWoodType();

    // Merged values
    @Value("#{target.manufacturer.name.split(' ')[0]} #{target.name}")
    String getFullName();

}
