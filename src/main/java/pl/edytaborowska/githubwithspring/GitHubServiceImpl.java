package pl.edytaborowska.githubwithspring;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubServiceImpl implements GitHubService{
    private final GitHubClient gitHubClient;

    public GitHubServiceImpl(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }
    @Override
    public List<GitHubDto> getUserRepositories(String username) {
        List<RepositoryResponse> repositories = gitHubClient.getRepositories(username);

        return repositories.stream()
                .filter(repo -> !repo.fork())
                .map(repo -> {
                    List<BranchResponse> branches = gitHubClient.getBranches(username, repo.nameRepository());

                    List<BranchDto> branchDtos = branches.stream()
                            .map(branch -> new BranchDto(branch.name(), branch.commit().sha()))
                            .toList();

                    return new GitHubDto(repo.nameRepository(), repo.owner().login(), branchDtos);
                })
                .toList();
    }
}
