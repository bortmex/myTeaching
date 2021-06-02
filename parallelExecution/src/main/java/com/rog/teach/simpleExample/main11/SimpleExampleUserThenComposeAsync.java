package com.rog.teach.simpleExample.main11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleExampleUserThenComposeAsync {
    public static void main(String[] args) {
        CompletableFuture<List<String>> ids = ifhIds(); // <1>

        CompletableFuture<List<String>> result = ids.thenComposeAsync(l -> { // <2>
            Stream<CompletableFuture<String>> zip =
                    l.stream().map(i -> { // <3>
                        CompletableFuture<String> nameTask = ifhName(i); // <4>
                        CompletableFuture<Integer> statTask = ifhStat(i); // <5>

                        return nameTask.thenCombineAsync(statTask, (name, stat) -> "Name " + name + " has stats " + stat); // <6>
                    });
            List<CompletableFuture<String>> combinationList = zip.collect(Collectors.toList()); // <7>
            CompletableFuture<String>[] combinationArray = combinationList.toArray(new CompletableFuture[combinationList.size()]);

            CompletableFuture<Void> allDone = CompletableFuture.allOf(combinationArray); // <8>
            return allDone.thenApply(v -> combinationList.stream()
                    .map(CompletableFuture::join) // <9>
                    .collect(Collectors.toList()));
        });

        List<String> results = result.join(); // <10>
        System.out.println(results.containsAll(Arrays.asList(
                "Name NameJoe has stats 103",
                "Name NameBart has stats 104",
                "Name NameHenry has stats 105",
                "Name NameNicole has stats 106",
                "Name NameABSLAJNFOAJNFOANFANSF has stats 121")));
    }

    private static CompletableFuture<List<String>> ifhIds() {
        CompletableFuture<List<String>> ids = new CompletableFuture<>();
        ids.complete(Arrays.asList("Joe", "Bart", "Henry", "Nicole", "ABSLAJNFOAJNFOANFANSF"));
        return ids;
    }

    private static CompletableFuture<String> ifhName(String id) {
        CompletableFuture<String> f = new CompletableFuture<>();
        f.complete("Name" + id);
        return f;
    }

    private static CompletableFuture<Integer> ifhStat(String id) {
        CompletableFuture<Integer> f = new CompletableFuture<>();
        f.complete(id.length() + 100);
        return f;
    }
}
