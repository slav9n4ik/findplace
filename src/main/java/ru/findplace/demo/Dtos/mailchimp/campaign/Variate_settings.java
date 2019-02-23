package ru.findplace.demo.Dtos.mailchimp.campaign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Variate_settings {

    @JsonProperty("winner_criteria")
    private String winner_criteria;

    @JsonProperty("winner_criteria")
    public String getWinner_criteria() {
        return winner_criteria;
    }

    @JsonProperty("winner_criteria")
    public void setWinner_criteria(String winner_criteria) {
        this.winner_criteria = winner_criteria;
    }
}
