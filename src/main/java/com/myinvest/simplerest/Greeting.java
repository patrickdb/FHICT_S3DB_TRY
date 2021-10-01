package com.myinvest.simplerest;

// This is a definition of a data object, that resembles
// the final output we want in JSON
//    {
//    "id": 1,
//    "content": "Hello, World!"
//}
// This output should be generated after a GET /greeting/{name}
// In which {name} is optional
public class Greeting {

    private final String content;
    private final long id;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public long getId() {
        return id;
    }
}
