package Models

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArtifactVersionController {

    @GetMapping("/artifact-version")
    fun getArtifactVersion():ArtifactVersion{
        return ArtifactVersion("DEV","HTTpjls","link")

    }

}