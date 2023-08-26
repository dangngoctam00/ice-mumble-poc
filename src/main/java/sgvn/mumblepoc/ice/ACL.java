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
 * Access Control List for a channel. ACLs are defined per channel, and can be inherited from parent channels.
 **/
public class ACL implements Cloneable,
                            java.io.Serializable
{
    /**
     * Does the ACL apply to this channel?
     **/
    public boolean applyHere;

    /**
     * Does the ACL apply to subchannels?
     **/
    public boolean applySubs;

    /**
     * Is this ACL inherited from a parent channel? Read-only.
     **/
    public boolean inherited;

    /**
     * ID of user this ACL applies to. -1 if using a group name.
     **/
    public int userid;

    /**
     * Group this ACL applies to. Blank if using userid.
     **/
    public String group;

    /**
     * Binary mask of privileges to allow.
     **/
    public int allow;

    /**
     * Binary mask of privileges to deny.
     **/
    public int deny;

    public ACL()
    {
        this.group = "";
    }

    public ACL(boolean applyHere, boolean applySubs, boolean inherited, int userid, String group, int allow, int deny)
    {
        this.applyHere = applyHere;
        this.applySubs = applySubs;
        this.inherited = inherited;
        this.userid = userid;
        this.group = group;
        this.allow = allow;
        this.deny = deny;
    }

    public boolean equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        ACL r = null;
        if(rhs instanceof ACL)
        {
            r = (ACL)rhs;
        }

        if(r != null)
        {
            if(this.applyHere != r.applyHere)
            {
                return false;
            }
            if(this.applySubs != r.applySubs)
            {
                return false;
            }
            if(this.inherited != r.inherited)
            {
                return false;
            }
            if(this.userid != r.userid)
            {
                return false;
            }
            if(this.group != r.group)
            {
                if(this.group == null || r.group == null || !this.group.equals(r.group))
                {
                    return false;
                }
            }
            if(this.allow != r.allow)
            {
                return false;
            }
            if(this.deny != r.deny)
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
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::MumbleServer::ACL");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, applyHere);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, applySubs);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, inherited);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, userid);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, group);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, allow);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, deny);
        return h_;
    }

    public ACL clone()
    {
        ACL c = null;
        try
        {
            c = (ACL)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeBool(this.applyHere);
        ostr.writeBool(this.applySubs);
        ostr.writeBool(this.inherited);
        ostr.writeInt(this.userid);
        ostr.writeString(this.group);
        ostr.writeInt(this.allow);
        ostr.writeInt(this.deny);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.applyHere = istr.readBool();
        this.applySubs = istr.readBool();
        this.inherited = istr.readBool();
        this.userid = istr.readInt();
        this.group = istr.readString();
        this.allow = istr.readInt();
        this.deny = istr.readInt();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, ACL v)
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

    static public ACL ice_read(com.zeroc.Ice.InputStream istr)
    {
        ACL v = new ACL();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<ACL> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, ACL v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<ACL> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(ACL.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final ACL _nullMarshalValue = new ACL();

    /** @hidden */
    public static final long serialVersionUID = -1407557889592200100L;
}
