package pl.edytaborowska.githubwithspring;

import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubServiceImpl implements GitHubService{
    private final GitHubClient gitHubClient;

    public GitHubServiceImpl(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }
    @Override
    public List<GitHubDto> getUserRepositories(String username) throws UserNotFoundException {
        try {
            List<RepositoryResponse> repositories = gitHubClient.getRepositories(username);

            return repositories.stream()
                    .filter(repo -> !repo.fork())
                    .map(repo -> {
                        List<BranchResponse> branches = gitHubClient.getBranches(username, repo.name());

                        List<BranchDto> branchDtos = branches.stream()
                                .map(branch -> new BranchDto(branch.name(), branch.commit().sha()))
                                .toList();

                        return new GitHubDto(repo.name(), repo.owner().login(), branchDtos);
                    })
                    .toList();
        } catch(FeignException.NotFound e){
            throw new UserNotFoundException("User " + username + " not found");
        }
    }
}
