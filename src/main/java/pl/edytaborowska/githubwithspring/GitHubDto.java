package pl.edytaborowska.githubwithspring;

import java.util.List;

public record GitHubDto(String repositoryName,
                        String ownerLogin,
                        List<BranchDto> branchDtoList) {
}
