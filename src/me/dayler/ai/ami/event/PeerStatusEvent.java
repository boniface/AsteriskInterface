package me.dayler.ai.ami.event;

import java.util.Map;

/**
 * Created by nuevatel.com on 6/28/14.
 */

public class PeerStatusEvent extends AmiEvent {

    public static final String RESPONSE_NAME = "PeerStatus";

    public static final String STATUS_REGISTERED = "Registered";
    public static final String STATUS_UNREGISTERED = "Unregistered";
    public static final String STATUS_REACHABLE = "Reachable";
    public static final String STATUS_LAGGED = "Lagged";
    public static final String STATUS_UNREACHABLE = "Unreachable";
    public static final String STATUS_REJECTED = "Rejected";

    private String channelType;
    private String peer;
    private String peerStatus;
    private String cause;
    private String address;

    public PeerStatusEvent() {
        setName(RESPONSE_NAME);
    }

    @Override
    public void build(Map<String, String> metadata, Object ctx) {
        super.build(metadata);
        setChannelType(metadata.get(AmiResponseField.ChannelType.name()));
        setPeer(metadata.get(AmiResponseField.Peer.name()));
        setPeerStatus(metadata.get(AmiResponseField.PeerStatus.name()));
        setCause(metadata.get(AmiResponseField.Cause.name()));
        setAddress(metadata.get(AmiResponseField.Address.name()));
    }

    public String getChannelType() {
        return this.channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getPeer() {
        return this.peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public String getPeerStatus() {
        return this.peerStatus;
    }

    public void setPeerStatus(String peerStatus) {
        this.peerStatus = peerStatus;
    }

    public String getCause() {
        return this.cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}