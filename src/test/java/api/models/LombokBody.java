package api.models;

import lombok.Data;

@Data
public class LombokBody {
    private String email,
            password,
            username,
            phone,
            config,
            locale,
            c_code,
            timezone,
            currency_code;

}