package com.musiview.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YoutubeService {
    private final String API_KEY="";

    public String buscarTitulo(String videoId)  {
        String url="https://www.googleapis.com/youtube/v3/videos"
                +"?part=snippet"
                +"&id="+videoId
                +"&key="+API_KEY;
        RestTemplate restTemplate=new RestTemplate();
        String response=restTemplate.getForObject(url, String.class);
        return response;
    }
}
