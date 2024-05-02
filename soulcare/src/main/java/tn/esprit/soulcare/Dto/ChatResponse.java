package tn.esprit.soulcare.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {

   private List<Choice> choices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
   public static class Choice {
       int index;
       Message message;
   }

}
