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
 * Helper class for marshaling/unmarshaling ACLList.
 **/
public final class ACLListHelper
{
    public static void write(com.zeroc.Ice.OutputStream ostr, ACL[] v)
    {
        if(v == null)
        {
            ostr.writeSize(0);
        }
        else
        {
            ostr.writeSize(v.length);
            for(int i0 = 0; i0 < v.length; i0++)
            {
                ACL.ice_write(ostr, v[i0]);
            }
        }
    }

    public static ACL[] read(com.zeroc.Ice.InputStream istr)
    {
        final ACL[] v;
        final int len0 = istr.readAndCheckSeqSize(16);
        v = new ACL[len0];
        for(int i0 = 0; i0 < len0; i0++)
        {
            v[i0] = ACL.ice_read(istr);
        }
        return v;
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<ACL[]> v)
    {
        if(v != null && v.isPresent())
        {
            write(ostr, tag, v.get());
        }
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, ACL[] v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ACLListHelper.write(ostr, v);
            ostr.endSize(pos);
        }
    }

    public static java.util.Optional<ACL[]> read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            ACL[] v;
            v = ACLListHelper.read(istr);
            return java.util.Optional.of(v);
        }
        else
        {
            return java.util.Optional.empty();
        }
    }
}