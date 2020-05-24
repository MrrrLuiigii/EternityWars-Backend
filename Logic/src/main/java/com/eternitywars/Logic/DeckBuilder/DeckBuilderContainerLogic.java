package com.eternitywars.Logic.DeckBuilder;

import com.eternitywars.Logic.WebsocketServer.WsModels.WsDeck;
import com.eternitywars.Logic.WebsocketServer.WsModels.WsGetDeckByUserId;
import com.eternitywars.Models.*;
import com.eternitywars.Models.DTO.DecksDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class DeckBuilderContainerLogic
{
    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders GetHttpHeaders(JSONObject jsonObject)
    {
        String token = jsonObject.getString("Token");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    private Object SendPost(String url, HttpHeaders httpHeaders, Object object)
    {
        GsonBuilder gs = new GsonBuilder();
        gs.serializeNulls();
        Gson gson = gs.create();

        HttpEntity<String> request = new HttpEntity<>(gson.toJson(object), httpHeaders);

        //todo breaking with deletedeck on sending request -> not using this method right now
        return restTemplate.postForObject(url, request, object.getClass());
    }

    private Object SendGet(String url, HttpHeaders httpHeaders, Object object, int parameter)
    {
        GsonBuilder gs = new GsonBuilder();
        gs.serializeNulls();
        Gson gson = gs.create();

        //todo getting all 0 and null back -> not using this method right now
        HttpEntity<String> request = new HttpEntity<>(gson.toJson(object), httpHeaders);
        ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.GET, request, object.getClass(), parameter);
        return response.getBody();
    }

    public Deck AddDeck(WsDeck wsDeck)
    {
//        GsonBuilder gs = new GsonBuilder();
//        gs.serializeNulls();
//        Gson gson = gs.create();

        Deck deck = wsDeck.getDeck();
        deck.setUser(wsDeck.getUser());
        JSONObject output = new JSONObject(deck);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(output.toString(), headers);

        ResponseEntity<Deck> response = restTemplate.exchange("http://localhost:8083/api/public/deck/add", HttpMethod.POST, request, Deck.class);
        return response.getBody();
    }

    public boolean DeleteDeck(JSONObject jsonObject)
    {
        GsonBuilder gs = new GsonBuilder();
        gs.serializeNulls();
        Gson gson = gs.create();

        JSONObject content = jsonObject.getJSONObject("Content");
        Deck deck = gson.fromJson(content.toString(), Deck.class);

        HttpHeaders httpHeaders = GetHttpHeaders(jsonObject);
        String url = "http://localhost:8083/api/private/deck/delete";
        HttpEntity<String> request = new HttpEntity<>(gson.toJson(deck), httpHeaders);
        return restTemplate.postForObject(url, request, boolean.class);
    }

    public DecksDTO GetAllDecks(WsGetDeckByUserId wsGetDeckByUserId)
    {
        HttpHeaders httpHeaders = new HttpHeaders();

        GsonBuilder gs = new GsonBuilder();
        gs.serializeNulls();
        Gson gson = gs.create();
        HttpEntity<String> request = new HttpEntity<>(gson.toJson(wsGetDeckByUserId.getParameter()), httpHeaders);

        String url = "http://localhost:8083/api/public/deck/getByUserId/{userId}";
        ResponseEntity<DecksDTO> response = restTemplate.exchange(url, HttpMethod.GET, request, DecksDTO.class, wsGetDeckByUserId.getParameter().getId());
        return response.getBody();
    }


    public Deck GetDeckById(int deckid, String token)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        GsonBuilder gs = new GsonBuilder();
        gs.serializeNulls();
        Gson gson = gs.create();


        HttpEntity<String> request = new HttpEntity<>(httpHeaders);

        String url = "http://localhost:8083/api/private/deck/get/{deckId}";
        ResponseEntity<Deck> response = restTemplate.exchange(url, HttpMethod.GET, request , Deck.class, deckid);
        return response.getBody();
    }

    public Deck GetEmptyDeckById(JSONObject jsonObject)
    {
        String token = jsonObject.getString("token");
        int id = jsonObject.getInt("content");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(httpHeaders);

        String url = "http://localhost:8083/api/private/deck/getEmptyByDeckId/{deckId}";
        ResponseEntity<Deck> response = restTemplate.exchange(url, HttpMethod.GET, request , Deck.class, id);
        return response.getBody();
    }
}
