package fr.esiea.controllers;

import fr.esiea.web.GildedRoseApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GildedRoseApplication.class);

    @RequestMapping("/")
    public String index() {
        LOGGER.info("Welcome to GildedRose !");
        return "Welcome to GildedRose !";
    }

    @RequestMapping("/prices")
    public String prices() {
        LOGGER.info("prices");
        // TODO : Consultation des objets pouvant être vendus (avec prix, qualité et quantité)
        return "prices";
    }

    @RequestMapping("/buy")
    public int buy(@RequestParam("name") String name,
            @RequestParam("quantity") Integer quantity) {
        LOGGER.info("buy");
        // TODO : Achat d'un objet (va provoquer une baisse de la quantité, jusqu'à la disparition de l'objet dans le catalogue)
        return 0;
    }

    @RequestMapping("/add")
    public int add(@RequestParam("name") String name,
            @RequestParam("price") Integer price,
            @RequestParam("quality") Integer quality,
            @RequestParam("quantity") Integer quantity) {
        LOGGER.info("add");
        // TODO : Approvisionnement d'un objet (nom, prix, qualité et quantité)
        return 0;
    }


}
