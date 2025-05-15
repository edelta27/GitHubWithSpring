package pl.edytaborowska.githubwithspring;

public record RepositoryResponse(String nameRepository,
                                 boolean fork,
                                 Owner owner) {
    public record Owner(String login) {}
}
