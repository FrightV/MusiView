package com.musiview.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
@PropertySource("classpath:essential.properties")
public class YoutubeService {
    @Value("${youtube.api.key}")
    private String API_KEY;

    public String[] dataSearch(String videoId)  {
        String url="https://www.googleapis.com/youtube/v3/videos"
                +"?part=snippet"
                +"&id="+videoId
                +"&key="+API_KEY;
        RestTemplate restTemplate=new RestTemplate();
        String response=restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper mapper=new ObjectMapper();
            JsonNode root=mapper.readTree(response);

            JsonNode items=root.path("items");

            if (items != null && items.size() > 0) {

                JsonNode snippet = items.get(0).get("snippet");

                String title = snippet.get("title").asText();
                JsonNode thumbnails=snippet.get("thumbnails");
                String cover;

                if (thumbnails.has("high")) {
                    cover=thumbnails.get("high").get("url").asText();
                } else if (thumbnails.has("medium")) {
                    cover=thumbnails.get("medium").get("url").asText();
                } else {
                    cover=thumbnails.get("default").get("url").asText();
                }

                System.out.println("title: " + title);
                System.out.println("cover: " + cover);

                return new String[]{title, cover};
            }
        } catch (Exception e) {
            System.out.println("Error processing JSON:");
            e.printStackTrace();
        }
        return null;
    }
}
