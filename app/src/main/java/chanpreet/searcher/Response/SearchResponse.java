package chanpreet.searcher.Response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanpreet on 21/1/17.
 */

public class SearchResponse {

    @SerializedName("plot")
    private String plot;
    @SerializedName("rated")
    private String rated;
    @SerializedName("language")
    private String language;
    @SerializedName("title")
    private String title;
    @SerializedName("country")
    private String country;
    @SerializedName("writer")
    private String writer;
    @SerializedName("year")
    private int year;
    @SerializedName("metascore")
    private int metascore;
    @SerializedName("imdb_id")
    private String imdbId;
    @SerializedName("director")
    private String director;
    @SerializedName("released")
    private String released;
    @SerializedName("imdb_rating")
    private String imdbRating;
    @SerializedName("awards")
    private String awards;
    @SerializedName("poster")
    private String poster;
    @SerializedName("genre")
    private String genre;
    @SerializedName("actors")
    private String actors;
    @SerializedName("runtime")
    private String runtime;
    @SerializedName("type")
    private String type;
    @SerializedName("response")
    private String response;
    @SerializedName("imdb_votes")
    private String imdbVotes;

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMetascore() {
        return metascore;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }
}
