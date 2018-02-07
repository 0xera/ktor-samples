# Maven Google Appengine Standard

Sample project for [Ktor](http://ktor.io) running under [Google App Engine](https://cloud.google.com/appengine/)
standard infrastructure with [Maven](https://maven.apache.org) build script. 

## Prerequisites

* [Java SDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Apache Maven](https://maven.apache.org)
* [Google Cloud SDK](https://cloud.google.com/sdk/docs/)

## Running

Run this project under local dev mode with:

```
mvn appengine:run
```
 
And navigate to [http://localhost:8080/](http://localhost:8080/) to see the sample home page.  

## Deploying

Use Google Cloud SDK to create application similarly to 
[Google App Engine for Java Quickstart](https://cloud.google.com/appengine/docs/standard/java/quickstart):

Install all the Google Cloud components and login into your account:

```
gcloud init
gcloud components install app-engine-java
gcloud components update  
gcloud auth application-default login
```

Create project and application:

```
gcloud projects create <unique-project-id> --set-as-default
gcloud app create
```                                

Then deploy your application with:

```
mvn appengine:deploy
```

You can checkout deployed version of this sample application at
https://ktor-maven-sample.appspot.com
