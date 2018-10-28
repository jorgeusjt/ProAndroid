package br.usjt.pipoca.API;

import java.util.List;

public class ResponseFilme {

    private List<ResponseResult> results;


    public List<ResponseResult> getResults() {
        return results;
    }

    public void setResults(List<ResponseResult> results) {
        this.results = results;
    }
}
