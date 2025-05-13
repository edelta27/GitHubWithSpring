package pl.edytaborowska.githubwithspring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "githubClient", url = "https://api.github.com")
public interface GitHubClient {
    @GetMapping("/users/{owner}/repos")
    List<RepositoryResponse> getRepositories(
            @PathVariable("owner") String owner
    );

    @GetMapping("/repos/{owner}/{repo}/branches")
    List<BranchResponse> getBranches(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo
    );
}
