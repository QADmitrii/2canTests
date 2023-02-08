package api.models;

import lombok.Data;

@Data
public class LombokResponse {
    private String message,
            error;
}