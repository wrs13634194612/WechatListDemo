package com.example.iosdialogdemo;

/**
 * 城市 与城市代码
 */
public class Country {
    private String country;
    private String countryCode;
    private String sortLetters;  //显示数据拼音的首字母

    public Country(String country, String countryCode, String sortLetters) {
        this.country = country;
        this.countryCode = countryCode;
        this.sortLetters = sortLetters;
    }

    public Country() {

    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSortLetters() {
        return sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }
}
