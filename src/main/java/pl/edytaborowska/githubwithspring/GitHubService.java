package pl.edytaborowska.githubwithspring;

import java.util.List;

public interface GitHubService {
    List<GitHubDto> getUserRepositories(String username);
}
