[![Build Status](https://travis-ci.org/walkingdevs/sdk.svg?branch=master)](https://travis-ci.org/walkingdevs/sdk)
[![Download](https://api.bintray.com/packages/walkingdevs/mvn/sdk/images/download.svg) ](https://bintray.com/walkingdevs/mvn/sdk/_latestVersion)

# State: Proof Of Concept!

## The artifact (With Latest Java "Features")
    <groupId>walkingdevs</groupId>
    <artifactId>sdk</artifactId>
    <version>8.9</version>

## Why?
- Cut down boilerplate code and noise
- Increase expressiveness
- Be more functional
- Be more object oriented
- Be less procedural

## What's included
- HTTP client
- Byte, String, Stream ~~utility~~ classes

## Quick review
Http client examples:

    RespBody body = ReqBuilder.GET("https://google.com")
        .build()
        .send()
        .body();
    assert body.text().contains("google")

TODO: more examples

## TODO
- Functional arrays
- JSON
- Small mockable, embeddable HTTP server
- NULLSafe

## Philosophy
Programming isn't an Art, but it does not mean that it can be ugly.
Man who loves programming will love to write beautiful code too.
It's hard to write good code with JDK. I hope that this artifact will
help someone to write a better code.