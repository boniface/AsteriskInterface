/**
 *
 */
package me.dayler.ai.ami.event;

import java.util.Map;

import me.dayler.ai.ami.service.AmiService;
import me.dayler.ai.ami.service.context.SessionCtx;
import me.dayler.common.util.StringUtils;
import static me.dayler.common.util.ClassUtil.castAs;

/**
 * Throws event when Session is removed from ami session cache. There is not an event from AMI
 * asterisk interface, it is exclusive for {@link AmiService} implementation.
 *
 * @author asalazar
 */
public class AmiDiscardSessionEvent extends AmiEvent {

    public static final String RESPONSE_NAME = "AmiRemoveSessionEvent";

    private SessionCtx sessionCtx;

    private String sessionId;

    private String channel;

    public AmiDiscardSessionEvent() {
        setName(RESPONSE_NAME);
    }

    public SessionCtx getSessionCtx() {
        return sessionCtx;
    }

    public void setSessionCtx(SessionCtx sessionCtx) {
        this.sessionCtx = sessionCtx;
    }

    /**
     * @return the sessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return the channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel the channel to set
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public void build(Map<String, String> metadata, Object ctx) {
        super.build(metadata);

        if ((sessionCtx = castAs(SessionCtx.class, ctx)) == null) {
            return;
        }

        setUniqueId(StringUtils.isBlank(sessionCtx.getSessionID())? StringUtils.EMPTY : sessionCtx.getSessionID());
        setSessionId(metadata.get(AmiResponseField.UniqueId.name()));
        setChannel(metadata.get(AmiResponseField.Channel.name()));
        setSessionCtx(sessionCtx);
    }
}
