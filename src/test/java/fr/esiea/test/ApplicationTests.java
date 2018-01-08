package fr.esiea.test;

import com.github.pagehelper.PageInfo;
import fr.esiea.model.domain.City;
import fr.esiea.service.CityService;
import fr.esiea.util.JsonUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationTests extends SpringBaseTest {

    @Autowired
    private CityService cityService;

    @Test
    public void selectPage() {
        cityService.selectPageAndCount(null, 1, 3).getList().stream()
                .map(JsonUtils::toJson)
                .forEach(log::info);
    }

}