package br.usjt.pipoca.API;

import java.util.List;

public class ResponseCredits {

    private List<ResponseCrew> crew;

    public List<ResponseCrew> getCrew() {
        return crew;
    }

    public void setCrew(List<ResponseCrew> crew) {
        this.crew = crew;
    }
}
