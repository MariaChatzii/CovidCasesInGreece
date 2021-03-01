package com.example.covidcasesgreece;

public class AreaRecord {
    private String name;
    private Integer dayDiff;
    private Integer totalVaccinations;
    private Integer dayTotal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDayDiff() {
        return dayDiff;
    }

    public void setDayDiff(Integer dayDiff) {
        this.dayDiff = dayDiff;
    }

    public Integer getTotalVaccinations() {
        return totalVaccinations;
    }

    public void setTotalVaccinations(Integer totalVaccinations) {
        this.totalVaccinations = totalVaccinations;
    }

    public Integer getDayTotal() {
        return dayTotal;
    }

    public void setDayTotal(Integer dayTotal) {
        this.dayTotal = dayTotal;
    }
}
