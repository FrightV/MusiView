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
}
