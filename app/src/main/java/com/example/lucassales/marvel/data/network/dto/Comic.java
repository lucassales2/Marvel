package com.example.lucassales.marvel.data.network.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comic {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("digitalId")
    @Expose
    private String digitalId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("issueNumber")
    @Expose
    private String issueNumber;
    @SerializedName("variantDescription")
    @Expose
    private String variantDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("diamondCode")
    @Expose
    private String diamondCode;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("issn")
    @Expose
    private String issn;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("pageCount")
    @Expose
    private String pageCount;
    @SerializedName("textObjects")
    @Expose
    private List<TextObject> textObjects = null;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("urls")
    @Expose
    private List<Url> urls = null;
    @SerializedName("series")
    @Expose
    private Series series;
    @SerializedName("variants")
    @Expose
    private List<ResourceUri> variants = null;
    @SerializedName("collections")
    @Expose
    private List<ResourceUri> collections = null;
    @SerializedName("collectedIssues")
    @Expose
    private List<ResourceUri> collectedIssues = null;
    @SerializedName("dates")
    @Expose
    private List<Date> dates = null;
    @SerializedName("prices")
    @Expose
    private List<Price> prices = null;
    @SerializedName("thumbnail")
    @Expose
    private Image thumbnail;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("creators")
    @Expose
    private CreatorsData creators;
    @SerializedName("characters")
    @Expose
    private Characters characters;
    @SerializedName("stories")
    @Expose
    private Stories stories;
    @SerializedName("events")
    @Expose
    private Events events;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(String digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public List<TextObject> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(List<TextObject> textObjects) {
        this.textObjects = textObjects;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public List<ResourceUri> getVariants() {
        return variants;
    }

    public void setVariants(List<ResourceUri> variants) {
        this.variants = variants;
    }

    public List<ResourceUri> getCollections() {
        return collections;
    }

    public void setCollections(List<ResourceUri> collections) {
        this.collections = collections;
    }

    public List<ResourceUri> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(List<ResourceUri> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public CreatorsData getCreators() {
        return creators;
    }

    public void setCreators(CreatorsData creators) {
        this.creators = creators;
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public Stories getStories() {
        return stories;
    }

    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

}
