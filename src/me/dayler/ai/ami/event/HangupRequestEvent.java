package me.dayler.ai.ami.event;

import java.util.Map;

import me.dayler.common.util.IntegerUtil;

public class HangupRequestEvent extends AmiEvent {

    public static final String RESPONSE_NAME = "HangupRequest";

    private Integer cause;

    public HangupRequestEvent() {
        setName(RESPONSE_NAME);
    }

    @Override
    public void build(Map<String, String> metadata, Object ctx) {
        super.build(metadata);
        setCause(IntegerUtil.tryParse(metadata.get(AmiResponseField.Cause.name())));
    }

    public Integer getCause() {
        return cause;
    }

    public void setCause(Integer cause) {
        this.cause = cause;
    }
}