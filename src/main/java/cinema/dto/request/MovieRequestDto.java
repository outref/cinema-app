package cinema.dto.request;

import javax.validation.constraints.Size;

public class MovieRequestDto {
    @Size(min = 1, max = 30)
    private String title;
    @Size(max = 200)
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
