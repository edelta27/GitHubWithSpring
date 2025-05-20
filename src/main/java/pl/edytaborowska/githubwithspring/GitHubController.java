package pl.edytaborowska.githubwithspring;

import feign.FeignException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/")
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GitHubDto> getUserRepositories(@PathVariable String username,
                                               @RequestHeader(value = "Accept", required = false) String acceptHeader) throws UserNotFoundException {
        if (acceptHeader == null || !acceptHeader.contains("application/json")) {
            throw new UnsupportedMediaTypeException("Use JSON format only");
        }
        System.out.println("Accept header: " + acceptHeader);

        return gitHubService.getUserRepositories(username);
    }

}
