package fr.esiea;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import fr.esiea.web.GildedRoseApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GildedRoseApplication.class)
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void index() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Welcome to ")));
    }

    @Test
    public void prices() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/prices").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("[]")));
    }

    @Test
    public void add_buy_item_normal() throws Exception {
        Integer id = Integer.parseInt(mvc.perform(MockMvcRequestBuilders.get("/add?name=biere&sellin=30&quality=10&price=7&quantity=2&type=item&attribute=normal").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(greaterThan("0")))
            .andReturn().getResponse().getContentAsString());
        mvc.perform(MockMvcRequestBuilders.get("/buy?id=" + id + "&quantity=4").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Il ne reste que 2 exemplaire(s) du produit que vous désirez (biere).")));
        mvc.perform(MockMvcRequestBuilders.get("/buy?id=" + id + "&quantity=1").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Merci pour votre achat de 1 biere.")));
        mvc.perform(MockMvcRequestBuilders.get("/buy?id=" + id + "&quantity=1").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Merci pour votre achat de 1 biere.")));
        mvc.perform(MockMvcRequestBuilders.get("/buy?id=" + id + "&quantity=2").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Le produit n'existe pas.")));
    }

    @Test
    public void add_cheese_legendary() throws Exception {
        Integer id = Integer.parseInt(mvc.perform(MockMvcRequestBuilders.get("/add?name=emmental&sellin=30&quality=80&price=100&quantity=1&type=cheese&attribute=legendary").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(greaterThan("0")))
            .andReturn().getResponse().getContentAsString());
        mvc.perform(MockMvcRequestBuilders.get("/buy?id=" + id + "&quantity=1").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Merci pour votre achat de 1 emmental.")));
    }

    @Test
    public void add_ticket_conjured() throws Exception {
        Integer id = Integer.parseInt(mvc.perform(MockMvcRequestBuilders.get("/add?name=jul&sellin=30&quality=10&price=50&quantity=1&type=ticket&attribute=conjured").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(greaterThan("0")))
            .andReturn().getResponse().getContentAsString());
        mvc.perform(MockMvcRequestBuilders.get("/buy?id=" + id + "&quantity=1").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Merci pour votre achat de 1 jul.")));
    }

}
