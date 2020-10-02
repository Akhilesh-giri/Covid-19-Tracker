package com.example.covid19tracker;

public class Model {
    private String country,cases,todayCases,recovered,todayRecovered, deaths,todayDeaths;

    public Model() {
    }

    public Model(String country, String cases, String todayCases, String recovered, String todayRecovered, String deaths, String todayDeaths) {
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }
}
