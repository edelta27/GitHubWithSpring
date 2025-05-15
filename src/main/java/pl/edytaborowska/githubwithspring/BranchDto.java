package pl.edytaborowska.githubwithspring;

public record BranchDto(String branchName,
                        String lastCommitSha) {
}
