package ru.findplace.demo.Dtos.mailchimp.campaignbooklist;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;
import ru.findplace.demo.Dtos.mailchimp.owner.Contact;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "web_id",
        "name",
        "contact",
        "permission_reminder",
        "use_archive_bar",
        "campaign_defaults",
        "notify_on_subscribe",
        "notify_on_unsubscribe",
        "date_created",
        "list_rating",
        "email_type_option",
        "subscribe_url_short",
        "subscribe_url_long",
        "beamer_address",
        "visibility",
        "double_optin",
        "has_welcome",
        "marketing_permissions",
        "modules",
        "stats"
})
@ToString
public class CampaignsBookItem {

    @JsonProperty("id")
    private String id;
    @JsonProperty("web_id")
    private Integer webId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("permission_reminder")
    private String permissionReminder;
    @JsonProperty("use_archive_bar")
    private Boolean useArchiveBar;
    @JsonProperty("campaign_defaults")
    private CampaignDefaults campaignDefaults;
    @JsonProperty("notify_on_subscribe")
    private String notifyOnSubscribe;
    @JsonProperty("notify_on_unsubscribe")
    private String notifyOnUnsubscribe;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("list_rating")
    private Integer listRating;
    @JsonProperty("email_type_option")
    private Boolean emailTypeOption;
    @JsonProperty("subscribe_url_short")
    private String subscribeUrlShort;
    @JsonProperty("subscribe_url_long")
    private String subscribeUrlLong;
    @JsonProperty("beamer_address")
    private String beamerAddress;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("double_optin")
    private Boolean doubleOptin;
    @JsonProperty("has_welcome")
    private Boolean hasWelcome;
    @JsonProperty("marketing_permissions")
    private Boolean marketingPermissions;
    @JsonProperty("modules")
    private java.util.List<Object> modules = null;
    @JsonProperty("stats")
    private Stats stats;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("web_id")
    public Integer getWebId() {
        return webId;
    }

    @JsonProperty("web_id")
    public void setWebId(Integer webId) {
        this.webId = webId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonProperty("permission_reminder")
    public String getPermissionReminder() {
        return permissionReminder;
    }

    @JsonProperty("permission_reminder")
    public void setPermissionReminder(String permissionReminder) {
        this.permissionReminder = permissionReminder;
    }

    @JsonProperty("use_archive_bar")
    public Boolean getUseArchiveBar() {
        return useArchiveBar;
    }

    @JsonProperty("use_archive_bar")
    public void setUseArchiveBar(Boolean useArchiveBar) {
        this.useArchiveBar = useArchiveBar;
    }

    @JsonProperty("campaign_defaults")
    public CampaignDefaults getCampaignDefaults() {
        return campaignDefaults;
    }

    @JsonProperty("campaign_defaults")
    public void setCampaignDefaults(CampaignDefaults campaignDefaults) {
        this.campaignDefaults = campaignDefaults;
    }

    @JsonProperty("notify_on_subscribe")
    public String getNotifyOnSubscribe() {
        return notifyOnSubscribe;
    }

    @JsonProperty("notify_on_subscribe")
    public void setNotifyOnSubscribe(String notifyOnSubscribe) {
        this.notifyOnSubscribe = notifyOnSubscribe;
    }

    @JsonProperty("notify_on_unsubscribe")
    public String getNotifyOnUnsubscribe() {
        return notifyOnUnsubscribe;
    }

    @JsonProperty("notify_on_unsubscribe")
    public void setNotifyOnUnsubscribe(String notifyOnUnsubscribe) {
        this.notifyOnUnsubscribe = notifyOnUnsubscribe;
    }

    @JsonProperty("date_created")
    public String getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("date_created")
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonProperty("list_rating")
    public Integer getListRating() {
        return listRating;
    }

    @JsonProperty("list_rating")
    public void setListRating(Integer listRating) {
        this.listRating = listRating;
    }

    @JsonProperty("email_type_option")
    public Boolean getEmailTypeOption() {
        return emailTypeOption;
    }

    @JsonProperty("email_type_option")
    public void setEmailTypeOption(Boolean emailTypeOption) {
        this.emailTypeOption = emailTypeOption;
    }

    @JsonProperty("subscribe_url_short")
    public String getSubscribeUrlShort() {
        return subscribeUrlShort;
    }

    @JsonProperty("subscribe_url_short")
    public void setSubscribeUrlShort(String subscribeUrlShort) {
        this.subscribeUrlShort = subscribeUrlShort;
    }

    @JsonProperty("subscribe_url_long")
    public String getSubscribeUrlLong() {
        return subscribeUrlLong;
    }

    @JsonProperty("subscribe_url_long")
    public void setSubscribeUrlLong(String subscribeUrlLong) {
        this.subscribeUrlLong = subscribeUrlLong;
    }

    @JsonProperty("beamer_address")
    public String getBeamerAddress() {
        return beamerAddress;
    }

    @JsonProperty("beamer_address")
    public void setBeamerAddress(String beamerAddress) {
        this.beamerAddress = beamerAddress;
    }

    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("double_optin")
    public Boolean getDoubleOptin() {
        return doubleOptin;
    }

    @JsonProperty("double_optin")
    public void setDoubleOptin(Boolean doubleOptin) {
        this.doubleOptin = doubleOptin;
    }

    @JsonProperty("has_welcome")
    public Boolean getHasWelcome() {
        return hasWelcome;
    }

    @JsonProperty("has_welcome")
    public void setHasWelcome(Boolean hasWelcome) {
        this.hasWelcome = hasWelcome;
    }

    @JsonProperty("marketing_permissions")
    public Boolean getMarketingPermissions() {
        return marketingPermissions;
    }

    @JsonProperty("marketing_permissions")
    public void setMarketingPermissions(Boolean marketingPermissions) {
        this.marketingPermissions = marketingPermissions;
    }

    @JsonProperty("modules")
    public java.util.List<Object> getModules() {
        return modules;
    }

    @JsonProperty("modules")
    public void setModules(java.util.List<Object> modules) {
        this.modules = modules;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
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