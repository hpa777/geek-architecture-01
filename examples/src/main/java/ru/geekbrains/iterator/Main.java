package ru.geekbrains.iterator;

public class Main {

    public static void main(String[] args) {
        StationList stations = new StationList();
        stations.addStation(new RadioStation(89));
        stations.addStation(new RadioStation(101));
        stations.addStation(new RadioStation(102));
        stations.addStation(new RadioStation(103));
        for (RadioStation station: stations) {
            System.out.println(station.getFrequency());
        }
    }
}
