package main;

public class Sale {

    public String salesPerson;

    public String region;

    public Double saleAmount;

    public Sale(String salesPerson, String region, Double saleAmount) {
        this.salesPerson = salesPerson;
        this.region = region;
        this.saleAmount = saleAmount;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Double saleAmount) {
        this.saleAmount = saleAmount;
    }
}
