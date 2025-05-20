package pl.edytaborowska.githubwithspring;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RepositoryResponse(String name,
                                 boolean fork,
                                 Owner owner) {
    public record Owner(String login) {}
}
