package com.musiview.util;

public class LinkUtils {

    public static String detectPlatform(String link) {


        if (link.contains("spotify.com")) {
            return "Spotify";
        }

        if (link.contains("youtube.com") || link.contains("youtu.be")) {
            return "Youtube";
        }

        if (link.contains("soundcloud.com")) {
            return "Soundcloud";
        }

        return "unknown";
    }

    public static String extractYoutubeId(String link) {

        if (link.contains("v=")) {
            String[] parts=link.split("v=");
            String id = parts[1];

            int end=id.indexOf("&");
            if (end !=-1){
                id=id.substring(0, end);
            }
            return id;
        }
        if (link.contains("youtu.be/")){
            String[] parts=link.split("youtu.be/");
            return parts[1];
        }

        return null;
    }
}
