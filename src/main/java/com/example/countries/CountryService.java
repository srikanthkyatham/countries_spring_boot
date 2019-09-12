package com.example.countries;

import com.example.countries.RestClient;
import io.reactivex.Single;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class CountryService {
    
    private RestClient restclient = new RestClient();

/*     public Single<String> codes() {
        return Single.create(singleSubscriber -> {
            singleSubscriber.onSuccess(restClient.getCodes());
        });
    }

    public Single<String> capital(String code) {
        return Single.create(singleSubscriber -> {
            singleSubscriber.onSuccess(restClient.capital(code));
        });

    }
 */
}