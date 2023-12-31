//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `MumbleServer.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package sgvn.mumblepoc.ice;

/**
 * A channel.
 **/
public class Channel implements Cloneable,
                                java.io.Serializable
{
    /**
     * Channel ID. This is unique per channel, and the root channel is always id 0.
     **/
    public int id;

    /**
     * Name of the channel. There can not be two channels with the same parent that has the same name.
     **/
    public String name;

    /**
     * ID of parent channel, or -1 if this is the root channel.
     **/
    public int parent;

    /**
     * List of id of linked channels.
     **/
    public int[] links;

    /**
     * Description of channel. Shown as tooltip for this channel.
     **/
    public String description;

    /**
     * Channel is temporary, and will be removed when the last user leaves it.
     **/
    public boolean temporary;

    /**
     * Position of the channel which is used in Client for sorting.
     **/
    public int position;

    public Channel()
    {
        this.name = "";
        this.description = "";
    }

    public Channel(int id, String name, int parent, int[] links, String description, boolean temporary, int position)
    {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.links = links;
        this.description = description;
        this.temporary = temporary;
        this.position = position;
    }

    public boolean equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Channel r = null;
        if(rhs instanceof Channel)
        {
            r = (Channel)rhs;
        }

        if(r != null)
        {
            if(this.id != r.id)
            {
                return false;
            }
            if(this.name != r.name)
            {
                if(this.name == null || r.name == null || !this.name.equals(r.name))
                {
                    return false;
                }
            }
            if(this.parent != r.parent)
            {
                return false;
            }
            if(!java.util.Arrays.equals(this.links, r.links))
            {
                return false;
            }
            if(this.description != r.description)
            {
                if(this.description == null || r.description == null || !this.description.equals(r.description))
                {
                    return false;
                }
            }
            if(this.temporary != r.temporary)
            {
                return false;
            }
            if(this.position != r.position)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::MumbleServer::Channel");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, id);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, name);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, parent);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, links);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, description);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, temporary);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, position);
        return h_;
    }

    public Channel clone()
    {
        Channel c = null;
        try
        {
            c = (Channel)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeInt(this.id);
        ostr.writeString(this.name);
        ostr.writeInt(this.parent);
        ostr.writeIntSeq(this.links);
        ostr.writeString(this.description);
        ostr.writeBool(this.temporary);
        ostr.writeInt(this.position);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.id = istr.readInt();
        this.name = istr.readString();
        this.parent = istr.readInt();
        this.links = istr.readIntSeq();
        this.description = istr.readString();
        this.temporary = istr.readBool();
        this.position = istr.readInt();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, Channel v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public Channel ice_read(com.zeroc.Ice.InputStream istr)
    {
        Channel v = new Channel();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<Channel> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, Channel v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<Channel> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(Channel.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final Channel _nullMarshalValue = new Channel();

    /** @hidden */
    public static final long serialVersionUID = 8766127961788709429L;
}
