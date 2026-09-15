package com.example.UberLLD.Model;

public record Location(double latitude, double longitude) {

    public double distanceTo(Location other) {

        double lat1 = Math.toRadians(latitude);
        double lat2 = Math.toRadians(other.latitude);

        double lon1 = Math.toRadians(longitude);
        double lon2 = Math.toRadians(other.longitude);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1)
                * Math.cos(lat2)
                * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Earth radius in KM
        return 6371 * c;
    }
}
