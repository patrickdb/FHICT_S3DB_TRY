package com.myinvest.simplerest;

import org.springframework.hateoas.RepresentationModel;

public class SayHi extends RepresentationModel {

    private final String content;

    public SayHi(String content) {

        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

/**
 * Used example has explicit JSON creation, but is not needed for SpringBoot REstFul service
 * It is done by the framework itself
 *
 * public class Greeting extends RepresentationModel<Greeting> {
 *
 * 	private final String content;
 *
 *        @JsonCreator
 *    public Greeting(@JsonProperty("content") String content) {
 * 		this.content = content;
 *    }
 *
 * 	public String getContent() {
 * 		return content;
 *    }
 * }
 */
