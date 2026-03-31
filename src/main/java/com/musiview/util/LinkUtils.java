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

        if (link.contains("youtu.be/")) {
            String id = link.split("youtu.be/")[1];

            if (id.contains("?")) {
                id = id.split("\\?")[0];
            }
            return id;
        }

        if (link.contains("watch?v=")) {
            String id = link.split("v=")[1];

            if (id.contains("&")) {
                id = id.split("&")[0];
            }
            return id;
        }
        return null;
    }
}
