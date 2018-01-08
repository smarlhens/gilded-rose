package fr.esiea.service.impl;

import fr.esiea.model.domain.City;
import fr.esiea.service.CityService;
import org.springframework.stereotype.Service;

@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl<City, Integer> implements CityService {
}