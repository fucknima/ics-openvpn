/*
 * Copyright (C) 2009, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.kghost.android.openvpn;

import android.os.Parcel;

/**
 * The profile for Openvpn type of VPN.
 * {@hide}
 */
public class OpenvpnProfile extends VpnProfile {
    private static final long serialVersionUID = 1L;

    private static final String PROTO_UDP = "udp";

    private static final String PROTO_TCP = "tcp";

    // Standard Settings
    private boolean mUserAuth = false;

    private String mCert;

    // Advanced Settings
    private int mPort = 1194;

    private String mProto = PROTO_UDP;

    private boolean mUseCompLzo = false;

    private boolean mSupplyAddr = false;

    private boolean mRedirectGateway = false;

    private String mLocalAddr;

    private String mRemoteAddr;

    private String mCipher;

    private int mKeySize;

    private String mExtra;

    private boolean mUseTlsAuth;

    private String mTlsAuthKey;

    private String mTlsAuthKeyDirection;

    public void setPort(String port) {
        try {
            mPort = Integer.parseInt(port);
        } catch (NumberFormatException e) {
            // no update
        }
    }

    public String getPort() {
        return Integer.toString(mPort);
    }

    public String getProto() {
        return mProto;
    }

    public CharSequence[] getProtoList() {
        String[] s = new String[2];
        s[0] = PROTO_UDP;
        s[1] = PROTO_TCP;
        return s;
    }

    public void setProto(String p) {
        if (p.contains(PROTO_TCP))
            mProto = PROTO_TCP;
        else if (p.contains(PROTO_UDP))
            mProto = PROTO_UDP;
    }

    public boolean getUserAuth() {
        return mUserAuth;
    }

    public void setUserAuth(boolean auth) {
        mUserAuth = auth;
    }

    public String getCertName() {
        return mCert;
    }

    public void setCertName(String name) {
        mCert = name;
    }

    public void setUseCompLzo(boolean b) {
        mUseCompLzo = b;
    }

    public boolean getUseCompLzo() {
        return mUseCompLzo;
    }

    public void setRedirectGateway(boolean b) {
        mRedirectGateway = b;
    }

    public boolean getRedirectGateway() {
        return mRedirectGateway;
    }

    public void setSupplyAddr(boolean b) {
        mSupplyAddr = b;
    }

    public boolean getSupplyAddr() {
        return mSupplyAddr;
    }

    public void setLocalAddr(String addr) {
        mLocalAddr = addr;
    }

    public String getLocalAddr() {
        return mLocalAddr;
    }

    public void setRemoteAddr(String addr) {
        mRemoteAddr = addr;
    }

    public String getRemoteAddr() {
        return mRemoteAddr;
    }

    public void setCipher(String cipher) {
        mCipher = cipher;
    }

    public String getCipher() {
        return mCipher;
    }

    public void setKeySize(String keysize) {
        try {
            if (keysize.equals("0"))
                mKeySize = 0;
            else
                mKeySize = Integer.parseInt(keysize);
        } catch (NumberFormatException e) {
            // no update
        }
    }

    public String getKeySize() {
        return Integer.toString(mKeySize);
    }

    public void setUseTlsAuth(boolean t) {
        mUseTlsAuth = t;
    }

    public boolean getUseTlsAuth() {
        return mUseTlsAuth;
    }

    public void setTlsAuthKey(String k) {
        mTlsAuthKey = k;
    }

    public String getTlsAuthKey() {
        return mTlsAuthKey;
    }

    public void setTlsAuthKeyDirection(String d) {
        mTlsAuthKeyDirection = d;
    }

    public String getTlsAuthKeyDirection() {
        return mTlsAuthKeyDirection;
    }

    public void setExtra(String extra) {
        mExtra = extra;
    }

    public String getExtra() {
        return mExtra;
    }

    @Override
    protected void readFromParcel(Parcel in) {
        super.readFromParcel(in);
        mPort = in.readInt();
        mProto = in.readString();
        mUserAuth = in.readInt() == 1;
        mCert = in.readString();
        mUseCompLzo = in.readInt() == 1;
        mRedirectGateway = in.readInt() == 1;
        mSupplyAddr = in.readInt() == 1;
        mLocalAddr = in.readString();
        mRemoteAddr = in.readString();
        mCipher = in.readString();
        mKeySize = in.readInt();
        mExtra = in.readString();
        mUseTlsAuth = in.readInt() == 1;
        mTlsAuthKey = in.readString();
        mTlsAuthKeyDirection = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        super.writeToParcel(parcel, flags);
        parcel.writeInt(mPort);
        parcel.writeString(mProto);
        parcel.writeInt(mUserAuth ? 1 : 0);
        parcel.writeString(mCert);
        parcel.writeInt(mUseCompLzo ? 1 : 0);
        parcel.writeInt(mRedirectGateway ? 1 : 0);
        parcel.writeInt(mSupplyAddr ? 1 : 0);
        parcel.writeString(mLocalAddr);
        parcel.writeString(mRemoteAddr);
        parcel.writeString(mCipher);
        parcel.writeInt(mKeySize);
        parcel.writeString(mExtra);
        parcel.writeInt(mUseTlsAuth ? 1 : 0);
        parcel.writeString(mTlsAuthKey);
        parcel.writeString(mTlsAuthKeyDirection);
    }
}