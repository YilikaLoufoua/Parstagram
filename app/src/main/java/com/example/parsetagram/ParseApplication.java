package com.example.parsetagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("O9VCNiLqR5QBUZtJxgC1zTFREVhNF2mDjNhzCxbn")
                .clientKey("RPTYJKhqrL4g4fdkDxQD8I1UbUOUU2llEDX2jw6F")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
