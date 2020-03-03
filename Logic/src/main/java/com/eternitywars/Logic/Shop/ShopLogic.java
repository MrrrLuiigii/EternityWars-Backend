package com.eternitywars.Logic.Shop;

import com.eternitywars.Logic.utils.MessageSender;
import com.eternitywars.Models.MessageHandler;
import com.eternitywars.Models.Pack;
import com.eternitywars.Models.User;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

public class ShopLogic {
    private CardPickerLogic cpl;
    private RestTemplate restTemplate = new RestTemplate();

    public ShopLogic() {
        cpl = new CardPickerLogic();
    }

    public User PurchaseSomePacks(JSONObject jsonObject) throws IOException {
        User user = (User) MessageHandler.HandleMessage(jsonObject.getString("content"), User.class);
        int amount = (int)MessageHandler.HandleMessage(jsonObject.getString("amount"), int.class);
        String token = jsonObject.getString("token");
        if (user.getGold() >= (amount*100)) {
            user.setPackAmount(user.getPackAmount() + amount);
            user.setGold(user.getGold() - (100 * amount));

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject userJson = new JSONObject(user);
            HttpEntity<String> request = new HttpEntity<>(userJson.toString(), headers);
            restTemplate.postForObject("http://localhost:8083/api/private/user/updateGold", request, Boolean.class);
            restTemplate.postForObject("http://localhost:8083/api/private/user/updatePackAmount", request, Boolean.class);
            return user;
        }
        MessageSender.SendError(user.getUserId(),"You dont the correct amount of gold to do that!");
        return user;
    }

    public Pack OpenPack(JSONObject jsonObject) throws IOException {

        User user = (User) MessageHandler.HandleMessage(jsonObject.getString("content"), User.class);
        String token = jsonObject.getString("token");
        if (user.getPackAmount() > 0) {
            int pack_amount = user.getPackAmount() -1;
            user.setPackAmount(pack_amount);

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject userJson = new JSONObject(user);
            HttpEntity<String> request = new HttpEntity<>(userJson.toString(), headers);
            restTemplate.postForObject("http://localhost:8083/api/private/user/updatePackAmount", request, Boolean.class);
            Pack pack = cpl.PickCards(user, token);
            return pack;
        }
        MessageSender.SendError(user.getUserId(),"You dont've any packs to open right now !");
        return null;
    }
}
