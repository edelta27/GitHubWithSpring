package pl.edytaborowska.githubwithspring;

import feign.FeignException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping(value = "/{username}/repos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GitHubDto> getUserRepositories(@PathVariable String username,
                                               @RequestHeader("Accept") String acceptHeader) throws UserNotFoundException {
        if (!acceptHeader.equals(MediaType.APPLICATION_JSON_VALUE)) {
            throw new UnsupportedMediaTypeException("Use JSON format only");
        }

        return gitHubService.getUserRepositories(username);
    }

}
