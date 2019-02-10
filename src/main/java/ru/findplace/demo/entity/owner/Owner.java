package ru.findplace.demo.entity.owner;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "account_id",
        "login_id",
        "account_name",
        "email",
        "first_name",
        "last_name",
        "username",
        "avatar_url",
        "role",
        "member_since",
        "pricing_plan_type",
        "first_payment",
        "account_timezone",
        "account_industry",
        "contact",
        "pro_enabled",
        "last_login",
        "total_subscribers"
})
@ToString
public class Owner {

    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("login_id")
    private String loginId;
    @JsonProperty("account_name")
    private String accountName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("username")
    private String username;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("role")
    private String role;
    @JsonProperty("member_since")
    private String memberSince;
    @JsonProperty("pricing_plan_type")
    private String pricingPlanType;
    @JsonProperty("first_payment")
    private String firstPayment;
    @JsonProperty("account_timezone")
    private String accountTimezone;
    @JsonProperty("account_industry")
    private String accountIndustry;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("pro_enabled")
    private Boolean proEnabled;
    @JsonProperty("last_login")
    private String lastLogin;
    @JsonProperty("total_subscribers")
    private Integer totalSubscribers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("account_id")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("account_id")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("login_id")
    public String getLoginId() {
        return loginId;
    }

    @JsonProperty("login_id")
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @JsonProperty("account_name")
    public String getAccountName() {
        return accountName;
    }

    @JsonProperty("account_name")
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("member_since")
    public String getMemberSince() {
        return memberSince;
    }

    @JsonProperty("member_since")
    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    @JsonProperty("pricing_plan_type")
    public String getPricingPlanType() {
        return pricingPlanType;
    }

    @JsonProperty("pricing_plan_type")
    public void setPricingPlanType(String pricingPlanType) {
        this.pricingPlanType = pricingPlanType;
    }

    @JsonProperty("first_payment")
    public String getFirstPayment() {
        return firstPayment;
    }

    @JsonProperty("first_payment")
    public void setFirstPayment(String firstPayment) {
        this.firstPayment = firstPayment;
    }

    @JsonProperty("account_timezone")
    public String getAccountTimezone() {
        return accountTimezone;
    }

    @JsonProperty("account_timezone")
    public void setAccountTimezone(String accountTimezone) {
        this.accountTimezone = accountTimezone;
    }

    @JsonProperty("account_industry")
    public String getAccountIndustry() {
        return accountIndustry;
    }

    @JsonProperty("account_industry")
    public void setAccountIndustry(String accountIndustry) {
        this.accountIndustry = accountIndustry;
    }

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonProperty("pro_enabled")
    public Boolean getProEnabled() {
        return proEnabled;
    }

    @JsonProperty("pro_enabled")
    public void setProEnabled(Boolean proEnabled) {
        this.proEnabled = proEnabled;
    }

    @JsonProperty("last_login")
    public String getLastLogin() {
        return lastLogin;
    }

    @JsonProperty("last_login")
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    @JsonProperty("total_subscribers")
    public Integer getTotalSubscribers() {
        return totalSubscribers;
    }

    @JsonProperty("total_subscribers")
    public void setTotalSubscribers(Integer totalSubscribers) {
        this.totalSubscribers = totalSubscribers;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}