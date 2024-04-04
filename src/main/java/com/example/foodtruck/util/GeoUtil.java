package com.example.foodtruck.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GeoUtil {

    private static final double EARTH_RADIUS_IN_METER = 6378137;

    private static double toRadians(double degree) {
        return degree * Math.PI / 180.0;
    }

    /**
     * @return two points distance in meter
     */
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert latitude and longitude to radians
        double radLat1 = toRadians(lat1);
        double radLon1 = toRadians(lon1);
        double radLat2 = toRadians(lat2);
        double radLon2 = toRadians(lon2);

        // Calculate differences in latitude and longitude
        double deltaLat = radLat2 - radLat1;
        double deltaLon = radLon2 - radLon1;

        // Apply the spherical law of cosines to calculate distance
        double a = Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Return distance in meter
        return EARTH_RADIUS_IN_METER * c;
    }
}
