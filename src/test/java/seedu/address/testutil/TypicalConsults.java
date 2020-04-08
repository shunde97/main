package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.consult.Consult;
import seedu.address.model.event.consult.ConsultTAble;

/**
 * A utility class containing a list of {@code Consults}  to be used in tests.
 */
public class TypicalConsults {

    public static Consult consult1;
    public static Consult consult2;

    static {
        try {
            consult1 = new ConsultBuilder().withBeginDateTime("2020-03-03 12:00")
                    .withEndDateTime("2020-03-03 14:00")
                    .withMatricNumber("A0111111A")
                    .withLocation("Deck").build();
            consult2 = new ConsultBuilder().withBeginDateTime("2020-03-04 12:00")
                    .withEndDateTime("2020-03-04 14:00")
                    .withMatricNumber("A0123456Z")
                    .withLocation("SR1").build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns an {@code ConsultTAble} with all the typical consults.
     */
    public static ConsultTAble getTypicalConsultTAble() {
        ConsultTAble st = new ConsultTAble();
        for (Consult consult : getTypicalConsults()) {
            st.addConsult(consult);
        }
        return st;
    }

    public static List<Consult> getTypicalConsults() {
        return new ArrayList<>(Arrays.asList(consult1, consult2));
    }
}
