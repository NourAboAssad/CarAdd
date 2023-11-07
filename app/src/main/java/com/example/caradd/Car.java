package com.example.caradd;

public class Car {
    private Integer year ;
    private String model;
    private String color;
    private Integer price;
    private Integer cylinder;
    private Integer horsepower;
    private Integer MN;
    private Double engineDisplacement;

    public Car(String color, Integer year, String model, Integer price, Integer cylinder, Integer horsepower, Integer MN, Double engineDisplacement)
    {
        this.MN=MN;
        this.color = color;
        this.cylinder=cylinder;
        this.price=price;
        this.year=year;
        this.horsepower=horsepower;
        this.model=model;
        this.engineDisplacement=engineDisplacement;
    }

    public Car() {
    }

    public void setEngineDisplacement(Double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public Double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setMN(Integer MN) {
        this.MN = MN;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public void setCylinder(Integer cylinder) {
        this.cylinder = cylinder;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMN() {
        return MN;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public Integer getCylinder() {
        return cylinder;
    }

    public Integer getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }
}

