package com.example.ProvaArq.ibgeService;
import com.example.ProvaArq.ibgeEntity.Entity;
import com.example.ProvaArq.repository.ibgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {
    private final ibgeRepository repositorio;

    @Autowired
    public Service(ibgeRepository repositorio) {
        this.repositorio = repositorio;
    }

    private String consultarURL(String apiUrl){
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        return dados;
    }
    public String consultarNoticiasRealeace() {
      return  consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias");
    }
    public String consultarNoticias() {
        String apiUrl ="https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia";
        RestTemplate restTemplate = new RestTemplate();

        try {
            String noticias = restTemplate.getForObject(apiUrl, String.class);
            salvarDadosNoBanco(noticias);
            return  consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia");
        } catch (RestClientException e) {
            return "Erro ao chamar a API Climatempo: " + e.getMessage();
        }
    }
    private void salvarDadosNoBanco(String noticias) {
        Entity entity = new Entity();
        entity.setNoticias(noticias);
        repositorio.save(entity);
    }
    public String consultarRealeace() {
        String apiUrl ="https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";
        RestTemplate restTemplate = new RestTemplate();

        try {
            String realeace = restTemplate.getForObject(apiUrl, String.class);
            salvarDadosNoBanco(realeace);
            return  consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release");
        } catch (RestClientException e) {
            return "Erro ao chamar a API Climatempo: " + e.getMessage();
        }
    }

}


