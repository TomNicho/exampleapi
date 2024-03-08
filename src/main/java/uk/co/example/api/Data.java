package uk.co.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.example.api.database.repos.*;

@Component
public class Data {
    @Autowired
    public PRepo products;

    @Autowired
    public VRepo variations;

    @Autowired
    public SRepo stocks;
}
