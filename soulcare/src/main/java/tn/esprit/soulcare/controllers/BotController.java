package tn.esprit.soulcare.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tn.esprit.soulcare.Dto.ChatRequest;
import tn.esprit.soulcare.Dto.ChatResponse;

@RestController
@RequestMapping("/bot")
public class BotController {

    @Value("${openai.model}")
    String model;
    @Autowired
    RestTemplate template;
    @Value("${openai.api.url}")
    String apiURL;

    @GetMapping("/chat")
    public String chat(@RequestParam("promt") String prompt){
        ChatRequest request= new ChatRequest(model,prompt);
        ChatResponse chatResponse = template.postForObject(apiURL,request,ChatResponse.class);
        return chatResponse.getChoices().get(0).getMessage().getContent();
    }

}
