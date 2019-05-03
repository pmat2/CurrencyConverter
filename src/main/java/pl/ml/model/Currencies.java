package pl.ml.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pmatusiak
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currencies {
    private String base;
    private Rates rates;
    private String date;
}
