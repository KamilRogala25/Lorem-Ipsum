package com.example.generator;


import de.svenjacobs.loremipsum.LoremIpsum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Spring wie że klasa będzie odpowiadała za adresy url

@Controller
public class HomeController {

    //mamy ścieżkę localhost:8080 -> następnie wywołaj metodę home
    @GetMapping("/")
    public String home(ModelMap map) {
        map.put("name", "Michał");
        map.put("result", "Michał");
        return "hi"; // wyświetla html z resources


    }

    @GetMapping("/form") // mazwanie ścieżki -> metoda javowa -> zwracanie htmla
    public String getForm() {
        return "form"; // nazwa nie to nie musi być form, plik można inaczej nazwać
    }

    @GetMapping("/result")
    public String getResult(@RequestParam Integer count,
                            ModelMap map) {
        LoremIpsum lorem = new LoremIpsum();
        map.put("count", lorem.getWords(count));
        return "result";
    }
}




