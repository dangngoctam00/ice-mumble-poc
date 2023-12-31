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
 * Helper class for marshaling/unmarshaling UserList.
 **/
public final class UserListHelper
{
    public static void write(com.zeroc.Ice.OutputStream ostr, User[] v)
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
                User.ice_write(ostr, v[i0]);
            }
        }
    }

    public static User[] read(com.zeroc.Ice.InputStream istr)
    {
        final User[] v;
        final int len0 = istr.readAndCheckSeqSize(60);
        v = new User[len0];
        for(int i0 = 0; i0 < len0; i0++)
        {
            v[i0] = User.ice_read(istr);
        }
        return v;
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<User[]> v)
    {
        if(v != null && v.isPresent())
        {
            write(ostr, tag, v.get());
        }
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, User[] v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            UserListHelper.write(ostr, v);
            ostr.endSize(pos);
        }
    }

    public static java.util.Optional<User[]> read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            User[] v;
            v = UserListHelper.read(istr);
            return java.util.Optional.of(v);
        }
        else
        {
            return java.util.Optional.empty();
        }
    }
}
