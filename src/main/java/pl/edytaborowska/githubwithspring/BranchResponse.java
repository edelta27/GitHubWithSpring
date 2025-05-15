package pl.edytaborowska.githubwithspring;

public record BranchResponse(String name,
                             Commit commit) {
    public record Commit(String sha) {}
}
