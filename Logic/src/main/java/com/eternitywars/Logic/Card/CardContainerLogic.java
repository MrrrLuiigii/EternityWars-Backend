package com.eternitywars.Logic.Card;

import com.eternitywars.Logic.WebsocketServer.WsModels.WsGetCards;
import com.eternitywars.Models.CardCollection;
import com.eternitywars.Models.DTO.CardsDTO;
import com.eternitywars.Models.MessageHandler;
import com.eternitywars.Models.User;
import com.eternitywars.Models.Viewmodels.SingleUserViewmodel;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class CardContainerLogic
{
    private RestTemplate restTemplate;

    public CardContainerLogic() {
        this.restTemplate = new RestTemplate();
    }

    public CardsDTO GetCardsByUserId(WsGetCards wsGetCards)
    {
        SingleUserViewmodel user = wsGetCards.getUser();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(wsGetCards.getToken());
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<CardsDTO> response = restTemplate.exchange(
                "http://localhost:8083/api/public/card/getByUserId/{userId}",
                HttpMethod.GET, request, CardsDTO.class, user.getId());
        return response.getBody();
    }
}
