package ir.orangehat.movieinfo.bussines.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * SearchResult
 */

public class SearchResult {

    @SerializedName("Search")
    private ArrayList<Movie> search;

    private int totalResults;

    @SerializedName("Response")
    private boolean response;

    public ArrayList<Movie> getSearch() {
        return search;
    }

    public void setSearch(ArrayList<Movie> search) {
        this.search = search;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
