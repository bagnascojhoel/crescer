package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class URL {

    private String url;

    @JsonCreator
    public URL(String url) {
        this.url = url;
    }
}
