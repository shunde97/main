package seedu.address.storage.consults;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.event.EventLocation;
import seedu.address.model.event.EventName;
import seedu.address.model.event.consult.Consult;

/**
 * Jackson-friendly version of {@link Consult}.
 */
class JsonAdaptedConsult {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Consult's %s field is missing!";
    private static final String INVALID_DATE_FORMAT = "Invalid date format!";

    private final String eventName;
    private final String beginDateTime;
    private final String endDateTime;
    private final String eventLocation;

    /**
     * Constructs a {@code JsonAdaptedConsult} with the given consult details.
     */
    @JsonCreator
    public JsonAdaptedConsult(@JsonProperty("eventName") String eventName,
                              @JsonProperty("beginDateTime") String beginDateTime,
                              @JsonProperty("endDateTime") String endDateTime,
                              @JsonProperty("eventLocation") String eventLocation) {
        this.eventName = eventName;
        this.beginDateTime = beginDateTime;
        this.endDateTime = endDateTime;
        this.eventLocation = eventLocation;
    }

    /**
     * Converts a given {@code Consult} into this class for Jackson use.
     */
    public JsonAdaptedConsult(Consult source) {
        eventName = source.getEventName().eventName;
        beginDateTime = source.getEventBeginDateTime().toString();
        endDateTime = source.getEventEndDateTime().toString();
        eventLocation = source.getLocation().eventLocation;
    }

    /**
     * Converts this Jackson-friendly adapted consult object into the model's {@code Consult} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Consult toModelType() throws IllegalValueException {
        if (eventName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    EventName.class.getSimpleName()));
        }
        if (!EventName.isValidEventName(eventName)) {
            throw new IllegalValueException(EventName.MESSAGE_CONSTRAINTS);
        }
        final EventName modelName = new EventName(eventName);

        if (beginDateTime == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "BEGIN DATE TIME"));
        }

        if (endDateTime == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "END DATE TIME"));
        }

        LocalDateTime modelBeginDateTime;
        LocalDateTime modelEndDateTime;

        try {
            modelBeginDateTime = LocalDateTime.parse(this.beginDateTime);
            modelEndDateTime = LocalDateTime.parse(this.endDateTime);
        } catch (DateTimeParseException ex) {
            throw new IllegalValueException(INVALID_DATE_FORMAT);
        }

        if (eventLocation == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "EVENT LOCATION"));
        }

        final EventLocation modelLocation = new EventLocation(eventLocation);

        return new Consult(modelName, modelBeginDateTime, modelEndDateTime, modelLocation);
    }
}