package be.infosupport.java9up.java9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Java9Features implements JavaFeatures {
    public String httpRequest() throws WrapperException {
        try {
            var httpRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://postman-echo.com/get"))
                    .GET()
                    .header("Accept-Language", "nl")
                    .build();

//            HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandler.asString()); //java 9
            HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString()); //java 11

            return response.body();
        } catch (StackOverflowError | InterruptedException | IOException | URISyntaxException e) {
            throw new WrapperException("Something went wrong while sending httpRequest to postman-echo", e);
        }
    }

    public ProcessInfo getProcessInfo() {
        var processInfoBuilder = new ProcessInfo.Builder();

        var processHandle = ProcessHandle.current();
        var processHandleInfo = processHandle.info();
        var command = processHandleInfo.command().isPresent() ? processHandleInfo.command().get() : null;

        return processInfoBuilder
                .processId(processHandle.pid())
                .command(command)
                .build();
    }

    public void killChildren() {
        var children = ProcessHandle.current().children();
        children.forEach(ProcessHandle::destroy);
    }

    public Set<String> convertToSet(String... args) {
        return Set.of(args); //immutable set!
    }

    public Set<String> convertToSet(String a, String b) {
        return Set.of(a, b); //immutable set!
    }

    public List<String> convertToList(String... args) {
        return List.of(args);
    }

    public String streamOptionals() {
        List<Optional<String>> optionalList =
                List.of(Optional.of("Java"), Optional.of("9"), Optional.of("is"), Optional.of("cool"));

        return optionalList.stream().flatMap(Optional::stream).collect(Collectors.joining(" "));
    }


    @Override
    public void doSomething() {
        //do something
    }
}
