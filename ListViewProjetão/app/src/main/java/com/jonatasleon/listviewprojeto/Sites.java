package com.jonatasleon.listviewprojeto;

/**
 * Created by jonatasleon on 14/05/16.
 */
public class Sites {

    private String nome;
    private String url;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
