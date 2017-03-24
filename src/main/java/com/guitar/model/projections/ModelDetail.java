package com.guitar.model.projections;

import com.guitar.model.Manufacturer;
import com.guitar.model.Model;
import com.guitar.model.ModelType;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * Created by tmac on 3/23/2017.
 */
@Projection(name="modelDetail", types = {Model.class})
public interface ModelDetail {

    String getName();
    BigDecimal getPrice();
    Manufacturer getManufacturer();
    ModelType getModelType();
    int getFrets();
    String getWoodType();

}
