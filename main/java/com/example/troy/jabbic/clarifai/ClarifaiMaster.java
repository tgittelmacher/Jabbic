package com.example.troy.jabbic.clarifai;

import com.clarifai.api.ClarifaiClient;

/**
 * Created by Troy on 1/23/2016.
 */
public class ClarifaiMaster {
    private ClarifaiMaster instance;
    private ClarifaiClient client;

    private final String CLIENT_ID = "aMfh1A5nJkCHC_xREeVmpssK9PXSfZ054RPRlbv6";
    private final String CLIENT_SECRET = "TG6jFD5kvs01sjG0Hf4e_ANUm3-2FbAO2iq9UsuO";
    private final String ACCESS_TOKEN = "NdXfVTEb0fH7tkGjy7WXnHy6Fjzs6J";

    private ClarifaiMaster() {

    }

    public ClarifaiMaster getInstance() {
        if (instance == null) {
            instance = new ClarifaiMaster();
        }
        return instance;
    }

}
