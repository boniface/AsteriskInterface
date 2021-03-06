/**
 *
 */
package me.dayler.ai.ami.event;

import java.util.Map;

import me.dayler.ai.ami.ChannelState;
import me.dayler.common.util.IntegerUtil;

/**
 * @author asalazar
 */
public class NewchannelEvent extends AmiEvent {

    public static final String RESPONSE_NAME = "Newchannel";

    private String channel;

    private ChannelState channelState;

    private String callerIdNum;

    private String callerIdName;

    private String accountCode;

    private String exten;

    private String context;

    public NewchannelEvent() {
        setName(RESPONSE_NAME);
    }


    /* (non-Javadoc)
     * @see com.nuevatel.ai.ami.event.Response#build(java.util.Deque)
     */
    @Override
    public void build(Map<String, String> metadata, Object ctx) {
        super.build(metadata);
        setChannel(metadata.get(AmiResponseField.Channel.name()));
        setChannelState(metadata.get(AmiResponseField.ChannelState.name()));
        setCallerIdNum(metadata.get(AmiResponseField.CallerIDNum.name()));
        setCallerIdName(metadata.get(AmiResponseField.CallerIDName.name()));
        setAccountCode(metadata.get(AmiResponseField.AccountCode.name()));
        setExten(metadata.get(AmiResponseField.Exten.name()));
        setContext(metadata.get(AmiResponseField.Context.name()));
    }

    public String getChannel() {
        return channel;
    }

    protected void setChannel(String channel) {
        this.channel = channel;
    }

    public ChannelState getChannelState() {
        return channelState;
    }

    protected void setChannelState(ChannelState channelState) {
        this.channelState = channelState;
    }

    protected void setChannelState(String channelState) {
        Integer state = IntegerUtil.tryParse(channelState);
        this.channelState = ChannelState.valueOf(state == null ? ChannelState.HUNGUP.getStatus() : state);
    }

    public String getCallerIdNum() {
        return callerIdNum;
    }

    protected void setCallerIdNum(String callerIdNum) {
        this.callerIdNum = callerIdNum;
    }

    public String getCallerIdName() {
        return callerIdName;
    }

    protected void setCallerIdName(String callerIdName) {
        this.callerIdName = callerIdName;
    }

    public String getAccountCode() {
        return accountCode;
    }

    protected void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getExten() {
        return exten;
    }

    protected void setExten(String exten) {
        this.exten = exten;
    }

    public String getContext() {
        return context;
    }

    protected void setContext(String context) {
        this.context = context;
    }
}
