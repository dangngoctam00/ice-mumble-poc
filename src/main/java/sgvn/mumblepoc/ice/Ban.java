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
 * A single ip mask for a ban.
 **/
public class Ban implements Cloneable,
                            java.io.Serializable
{
    /**
     * Address to ban.
     **/
    public byte[] address;

    /**
     * Number of bits in ban to apply.
     **/
    public int bits;

    /**
     * Username associated with ban.
     **/
    public String name;

    /**
     * Hash of banned user.
     **/
    public String hash;

    /**
     * Reason for ban.
     **/
    public String reason;

    /**
     * Date ban was applied in unix time format.
     **/
    public int start;

    /**
     * Duration of ban.
     **/
    public int duration;

    public Ban()
    {
        this.name = "";
        this.hash = "";
        this.reason = "";
    }

    public Ban(byte[] address, int bits, String name, String hash, String reason, int start, int duration)
    {
        this.address = address;
        this.bits = bits;
        this.name = name;
        this.hash = hash;
        this.reason = reason;
        this.start = start;
        this.duration = duration;
    }

    public boolean equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Ban r = null;
        if(rhs instanceof Ban)
        {
            r = (Ban)rhs;
        }

        if(r != null)
        {
            if(!java.util.Arrays.equals(this.address, r.address))
            {
                return false;
            }
            if(this.bits != r.bits)
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
            if(this.hash != r.hash)
            {
                if(this.hash == null || r.hash == null || !this.hash.equals(r.hash))
                {
                    return false;
                }
            }
            if(this.reason != r.reason)
            {
                if(this.reason == null || r.reason == null || !this.reason.equals(r.reason))
                {
                    return false;
                }
            }
            if(this.start != r.start)
            {
                return false;
            }
            if(this.duration != r.duration)
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
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::MumbleServer::Ban");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, address);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, bits);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, name);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, hash);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, reason);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, start);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, duration);
        return h_;
    }

    public Ban clone()
    {
        Ban c = null;
        try
        {
            c = (Ban)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeByteSeq(this.address);
        ostr.writeInt(this.bits);
        ostr.writeString(this.name);
        ostr.writeString(this.hash);
        ostr.writeString(this.reason);
        ostr.writeInt(this.start);
        ostr.writeInt(this.duration);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.address = istr.readByteSeq();
        this.bits = istr.readInt();
        this.name = istr.readString();
        this.hash = istr.readString();
        this.reason = istr.readString();
        this.start = istr.readInt();
        this.duration = istr.readInt();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, Ban v)
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

    static public Ban ice_read(com.zeroc.Ice.InputStream istr)
    {
        Ban v = new Ban();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<Ban> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, Ban v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<Ban> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(Ban.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final Ban _nullMarshalValue = new Ban();

    /** @hidden */
    public static final long serialVersionUID = 7124363554920928943L;
}
