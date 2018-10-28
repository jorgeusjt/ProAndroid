package br.usjt.pipoca.API;

import java.util.List;

import br.usjt.pipoca.Genero;

public class ResponseGenero {

    private List<Genero> genres;

    public List<Genero> getGenres() {
        return genres;
    }

    public void setGenres(List<Genero> genres) {
        this.genres = genres;
    }


}
