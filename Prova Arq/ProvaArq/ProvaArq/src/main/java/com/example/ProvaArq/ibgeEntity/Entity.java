package com.example.ProvaArq.ibgeEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clima")
public class Entity {

    @Id
    private String id;
    private String noticias;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDadosMeteorologicos() {
        return noticias;
    }

    public void setNoticias(String noticias) {
        this.noticias = noticias;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", dadosMeteorologicos='" + noticias + '\'' +
                '}';
    }
}
